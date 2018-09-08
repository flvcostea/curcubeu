package demo.health.service;

import demo.health.model.Person;

import java.util.List;

public interface PersonService {
    String addPerson(Person person);

    List<Person> findAllPersons();

    Person findById(int id);

    //void addPersonMeal(int personId, int mealId);
    public Person updatePerson(int id, Person person);

    void deletePerson(int id);

}