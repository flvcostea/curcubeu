package demo.health.controller;

import demo.health.model.Recreation;
import demo.health.service.ActivityService;
import demo.health.service.PersonService;
import demo.health.service.RecreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class RecreationController {

    @Autowired
    private RecreationService recreationService;
    @Autowired
    private PersonService personService;
    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/addRecreation", method = RequestMethod.POST)
    public String addRecreation(@RequestBody Recreation recreation) {
        return recreationService.addRecreation(recreation);
    }

    @RequestMapping(value = "/recreations", method = RequestMethod.GET)
    public List<Recreation> getRecreations() {
        return recreationService.findAllRecreations();
    }

    @RequestMapping(value = "/recreationDate/{date}", method = RequestMethod.GET)
    public Recreation recreationDate(@PathVariable("date") Date date) {
        return recreationService.findByDate(date);
    }

    @RequestMapping(value = "/addActivityRecreation/{recreationId}/{activityId}", method = RequestMethod.POST)
    public void addActivityRecreation(@PathVariable("recreationId") int recreationId, @PathVariable("activityId") int activityId) {
        recreationService.addActivityToRecreation(activityId, recreationId);
    }

    @RequestMapping(value = "/deleteRecreation/{id}", method = RequestMethod.DELETE)
    public void deleteRecreation(@PathVariable("id") int id) {
        recreationService.deleteRecreation(id);
    }
}
