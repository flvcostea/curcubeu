package demo.health.service;

import demo.health.model.Recreation;

import java.util.Date;
import java.util.List;

public interface RecreationService {
    String addRecreation(Recreation recreation);

    List<Recreation> findAllRecreations();

    public Recreation findByDate(Date date);

    void addActivityToRecreation(int activityId, int recreationId);

    void deleteRecreation(int id);
}
