package demo.health.service;

import demo.health.model.Activity;

import java.util.List;

public interface ActivityService {
    String addActivity(Activity activity);

    List<Activity> findAllActivities();

    Activity findById(int id);

    void deleteActivity(int id );

    Activity updateActivity(int id, Activity activity);

}

