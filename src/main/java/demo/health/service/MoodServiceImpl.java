package demo.health.service;

import demo.health.model.Emotion;
import demo.health.model.Mood;
import demo.health.model.Person;
import demo.health.repository.EmotionRepository;
import demo.health.repository.MoodRepository;
import demo.health.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service("moodService")
public class MoodServiceImpl implements MoodService {

    @Qualifier("moodRepository")
    @Autowired
    private MoodRepository moodRepository;

    @Qualifier("personRepository")
    @Autowired
    PersonRepository personRepository;

    @Qualifier("emotionRepository")
    @Autowired
    EmotionRepository emotionRepository;

    @Override
    public String addMood(Mood mood) {
        if (mood != null) {
            Person person = personRepository.getOne(mood.getPerson().getId());
            mood.setPerson(person);

            List<Mood> moods = person.getMoods();
            moods.add(mood);
            person.setMoods(moods);

            moodRepository.save(mood);
        } else {
            return "Entry was not saved.";
        }
        return "Succesfully saved.";
    }

    @Override
    public List<Mood> findAllMoods() {
        return moodRepository.findAll();
    }

    @Override
    public Mood findByDate(Date date) {
        for (Mood m : moodRepository.findAll()) {
            if (m.getMoodDate().equals(date))
                return m;
        }
        return null;

    }

    @Override
    @Transactional
    public Mood addEmotionToMood(int emotionId, int moodId) {
        Emotion emotion = emotionRepository.getOne(emotionId);
        Mood mood = moodRepository.getOne(moodId);

        List<Emotion> emotions = mood.getEmotions();
        emotions.add(emotion);
        mood.setEmotions(emotions);
        moodRepository.save(mood);
        return mood;



    }

    @Override
    public void deleteMood(int id) {
        Mood moodFound=moodRepository.getOne(id);
        Person person=moodFound.getPerson();

        List<Mood> moods=person.getMoods();
        for (Mood m:moods)
        {
            if (m.equals(moodFound))
            {
                moodRepository.delete(m);
            }
        }

    }
}
