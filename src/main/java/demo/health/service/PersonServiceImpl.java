package demo.health.service;


import demo.health.model.*;
import demo.health.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Qualifier("personRepository")

    @Autowired
    private PersonRepository personRepository;
    @Qualifier("mealRepository")
    @Autowired
    private MealRepository mealRepository;

    @Qualifier("moodRepository")
    @Autowired
    private MoodRepository moodRepository;

    @Qualifier("recreationRepository")
    @Autowired
    private RecreationRepository recreationRepository;

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Qualifier("bookingRepository")
    @Autowired
    BookingRepository bookingRepository;

    @Override
    @Transactional
    public String addPerson(Person person) {
        if (person != null) {
           /* User user = userRepository.getOne(person.getUser().getId());
            person.setUser(user);
            personRepository.save(person);
*/
            Person newPerson = personRepository.save(person);  //o salveaza, ii ia userul care i se cuvine
            //User u= newPerson.getUser();
            //u.setPerson(newPerson);      //  lui user i se seteaza noua persoana
            //userRepository.save(u);



        } else {
            return "Entry was not saved.";
        }
        return "Succesfully saved!";
    }












    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(int id) {
        return personRepository.getOne(id);
    }


    @Override
    public Person updatePerson(int id, Person person) {

        Person updatedPerson = findById(id);
        //User user = userRepository.getOne(updatedPerson.getUser().getId());

        if (person.getAge()!=0)updatedPerson.setAge(person.getAge());
        if (person.getHeight()!=0)updatedPerson.setHeight(person.getHeight());
        if (person.getName()!=null)updatedPerson.setName(person.getName());
        if (person.getSex()!=null)updatedPerson.setSex(person.getSex());
        if (person.getWeight()!=0)updatedPerson.setWeight(person.getWeight());

        //user.setPerson(updatedPerson);

        return personRepository.save(updatedPerson);

    }


    @Override
    public void deletePerson(int id) {
        Person person = personRepository.getOne(id);
        //userRepository.delete(person.getUser());  //se sterge din users


        List<Meal> meals = person.getMeals();
        for (Meal m : meals) {
            m.setPerson(null);
            mealRepository.delete(m);
        }
        person.setMeals(null);

        List<Booking> bookings = person.getBooking();
        for (Booking b : bookings) {
            b.setPerson(null);
            bookingRepository.delete(b);
        }
        person.setBooking(null);


        List<Mood> moods = person.getMoods();
        for (Mood m : moods) {
            m.setPerson(null);
            moodRepository.delete(m);
        }
        person.setMoods(null);

        List<Recreation> recreations = person.getRecreations();
        for (Recreation r : recreations) {
            r.setPerson(null);
            recreationRepository.delete(r);
        }
        person.setRecreations(null);

        personRepository.delete(person);
    }


}