package demo.health.controller;

import demo.health.model.Person;
import demo.health.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public String addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }


    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<Person> getPersons() {
        return personService.findAllPersons();
    }


    @RequestMapping(value = "/personId/{id}", method = RequestMethod.GET)
    public Person personId(@PathVariable("id") int id) {
        return personService.findById(id);
    }


    @RequestMapping(value = "/updatePerson/{id}", method = RequestMethod.PUT)
    public Person personUpdate(@PathVariable("id") int id, @RequestBody Person person) {

        return personService.updatePerson(id, person);
    }

    @RequestMapping(value = "/deletePerson/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable("id") int id) {
        personService.deletePerson(id);
    }
}

