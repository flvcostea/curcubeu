package demo.health.controller;

import demo.health.model.Activity;
import demo.health.service.ActivityService;
import demo.health.service.RecreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @RequestMapping(value = "/addActivity", method = RequestMethod.POST)
    public String addActivity(@RequestBody Activity activity) {
        return activityService.addActivity(activity);
    }

    @RequestMapping(value = "/activities", method = RequestMethod.GET)
    public List<Activity> getActivities() {
        return activityService.findAllActivities();
    }

    @RequestMapping(value = "/activityId/{id}", method = RequestMethod.GET)
    public Activity activityId(@PathVariable("id") int id) {
        return activityService.findById(id);
    }


    @RequestMapping(value = "/updateActivity/{id}", method = RequestMethod.PUT)
    public Activity updateActivity(@PathVariable("id") int id, @RequestBody Activity activity) {

        return activityService.updateActivity(id, activity);

    }

    @RequestMapping(value = "/deleteActivity/{id}", method = RequestMethod.DELETE)
    public void deleteActivity(@PathVariable("id") int id) {
        activityService.deleteActivity(id);
    }


}
