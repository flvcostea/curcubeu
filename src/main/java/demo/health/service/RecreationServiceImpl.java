package demo.health.service;

import demo.health.model.Activity;
import demo.health.model.Person;
import demo.health.model.Recreation;
import demo.health.repository.ActivityRepository;
import demo.health.repository.PersonRepository;
import demo.health.repository.RecreationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service("recreationService")
public class RecreationServiceImpl implements RecreationService {

    @Qualifier("recreationRepository")
    @Autowired
    private RecreationRepository recreationRepository;

    @Qualifier("personRepository")
    @Autowired
    PersonRepository personRepository;

    @Qualifier("activityRepository")
    @Autowired
    ActivityRepository activityRepository;

    @Override
    public String addRecreation(Recreation recreation) {
        if (recreationRepository != null) {

            Person person = personRepository.getOne(recreation.getPerson().getId());
            recreation.setPerson(person);

            List<Recreation> recreations = person.getRecreations();
            recreations.add(recreation);
            person.setRecreations(recreations);

            recreationRepository.save(recreation);

        } else {
            return "Entry was not saved.";
        }
        return "Succesfully saved!";
    }

    @Override
    public List<Recreation> findAllRecreations() {
        return recreationRepository.findAll();
    }

    @Override
    public Recreation findByDate(Date date) {
        for (Recreation r : recreationRepository.findAll()) {
            if (r.getActivityDate().equals(date))
                return r;
        }
        return null;

    }


    @Override
    @Transactional
    public void addActivityToRecreation(int activityId, int recreationId) {


        Activity activity = activityRepository.getOne(activityId);
        Recreation recreation = recreationRepository.getOne(recreationId);

        List<Activity> activities = recreation.getActivities();
        activities.add(activity);
        recreation.setActivities(activities);
        recreationRepository.save(recreation);


    }

    @Override
    public void deleteRecreation(int id) {
        Recreation recreationFound =recreationRepository.getOne(id);
        Person person=recreationFound.getPerson();

        List<Recreation> recreations=person.getRecreations();
        for (Recreation r:recreations)
        {
            if (r.equals(recreationFound))
            {
                recreationRepository.delete(r);
            }
        }
        person.setRecreations(recreations);
        personRepository.save(person);
    }
}
