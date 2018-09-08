package demo.health.service;

import demo.health.model.Seminary;

import java.util.Date;
import java.util.List;

public interface SeminaryService {
    String addSeminary(Seminary seminary);

    List<Seminary> findAllSeminaries();

    Seminary findById(int id);

    Seminary findByTitle(String title);

     Seminary findByDate(Date date);

     Seminary updateSeminary(int id, Seminary seminary);

    void updateSeminarySpeaker(int id, int idSpeakerNew);


}
