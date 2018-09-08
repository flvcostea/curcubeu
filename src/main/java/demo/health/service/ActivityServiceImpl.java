package demo.health.service;

import demo.health.model.Activity;
import demo.health.model.Recreation;
import demo.health.repository.ActivityRepository;
import demo.health.repository.RecreationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
    @Qualifier("activityRepository")
    @Autowired
    private ActivityRepository activityRepository;

    @Qualifier("recreationRepository")
    @Autowired
    private RecreationRepository recreationRepository;

    @Override
    public String addActivity(Activity activity) {
        if (activityRepository != null) {
            activityRepository.save(activity);
        } else {
            return "Entry was not saved.";
        }
        return "Succesfully saved!";
    }

    @Override
    public List<Activity> findAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public Activity findById(int id) {
        return activityRepository.getOne(id);
    }


    @Override
    public void deleteActivity(int id) {

        Activity activityFound =activityRepository.getOne(id);

        List<Recreation> recreations = activityFound.getRecreation();
        for(Recreation r: recreations)
        {
            if (r.getActivities().contains(activityFound)){
                List<Activity> activities=r.getActivities();
                activities.remove(activityFound);
                r.setActivities(activities);
                recreationRepository.save(r);
            }
        }
        activityRepository.delete(activityFound);

    }

    @Override
    public Activity updateActivity(int id, Activity activity) {
        Activity updatedActivity = findById(id);

        if (activity.getActivityName()!=null)updatedActivity.setActivityName(activity.getActivityName());
        if (activity.getType()!=null)updatedActivity.setType(activity.getType());

        return activityRepository.save(updatedActivity);


    }



}
