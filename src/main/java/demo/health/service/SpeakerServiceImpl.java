package demo.health.service;

import demo.health.model.Seminary;
import demo.health.model.Speaker;
import demo.health.model.User;
import demo.health.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService {
    @Qualifier("speakerRepository")
    @Autowired
    private SpeakerRepository speakerRepository;

    @Override
    public String addSpeaker(Speaker speaker) {
        if (speaker != null) {
            speakerRepository.save(speaker);
        } else {
            return "Entry was not saved.";
        }
        return "Succesfully saved!";
    }

    @Override
    public List<Speaker> findAllSpeakers() {
        return speakerRepository.findAll();
    }

    @Override
    public Speaker findById(int id) {
        return speakerRepository.getOne(id);
    }

    @Override
    public Speaker findByEmail(String emailAddress){
        for(Speaker  s : speakerRepository.findAll()){
            if (s.getEmailAddress().equals(emailAddress))
                return s;
        }
        return null;
    }

    @Override
    public Speaker findByfullName(String fullName){
        for(Speaker  s : speakerRepository.findAll()){
            if (s.getFullName().equals(fullName))
                return s;
        }
        return null;
    }



    @Override
    public Speaker updateSpeaker(int id, Speaker speaker) {

        Speaker updatedSpeaker = findById(id);
        if (speaker.getFullName()!=null)updatedSpeaker.setFullName(speaker.getFullName());
        if (speaker.getEmailAddress()!=null)updatedSpeaker.setEmailAddress(speaker.getEmailAddress());
        return speakerRepository.save(updatedSpeaker);


    }


}
