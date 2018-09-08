package demo.health.service;

import demo.health.model.Speaker;

import java.util.List;

public interface SpeakerService {
    String addSpeaker(Speaker speaker);

    List <Speaker> findAllSpeakers();

    Speaker findById(int id);
    Speaker findByEmail(String emailAddress);
    public Speaker findByfullName(String fullName);

    Speaker updateSpeaker(int id, Speaker speaker);

}
