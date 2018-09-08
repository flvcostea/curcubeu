package demo.health.service;

import demo.health.model.Aliment;
import demo.health.model.Meal;
import demo.health.model.Person;
import demo.health.repository.AlimentRepository;
import demo.health.repository.MealRepository;
import demo.health.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service("mealService")
public class MealServiceImpl implements MealService {
    @Qualifier("mealRepository")
    @Autowired
    private MealRepository mealRepository;
    @Qualifier("personRepository")
    @Autowired
    private PersonRepository personRepository;
    @Qualifier("alimentRepository")
    @Autowired
    private AlimentRepository alimentRepository;
/* @Override
    public String addMeal(Meal meal) {
        if (mealRepository != null) {
            mealRepository.save(meal);
        } else {
            return "Entry was not saved.";
        }
        return "Succesfully saved!";
    }

    */

    //adaugi un id de meal nou, cu lista de almente goala, pentru o persoana data.
    @Override
    public String addMeal(Meal meal) {
        if (meal != null) {
            Person person = personRepository.getOne(meal.getPerson().getId());
            meal.setPerson(person);

            List<Meal> meals = person.getMeals();
            meals.add(meal);
            person.setMeals(meals);

            mealRepository.save(meal);
        } else {
            return "Entry was not saved.";
        }
        return "Succesfully saved.";
    }


    @Override
    public List<Meal> findAllMeals() {
        return mealRepository.findAll();
    }


    @Override
    public Meal findByDate(Date date) {
        for (Meal m : mealRepository.findAll()) {
            if (m.getMealDate().equals(date))
                return m;
        }
        return null;

    }


    @Override
    @Transactional
    public Meal addAlimentToMeal(int alimentId, int mealId) {

        Aliment aliment = alimentRepository.getOne(alimentId);
        Meal meal = mealRepository.getOne(mealId);
        List<Aliment> aliments = meal.getAliments();
        aliments.add(aliment);
        meal.setAliments(aliments);
        mealRepository.save(meal);

        //<Meal> meals = aliment.getMeals();
       // meals.add(meal);
        //aliment.setMeals(meals);
       // alimentRepository.save(aliment);


        return meal;
    }

    @Override
    public void deleteMeal(int id) {

        Meal mealFound=mealRepository.getOne(id);
        Person person=mealFound.getPerson();

        List<Meal> meals=person.getMeals();
        for (Meal m:meals)
        {
            if (m.equals(mealFound))
            {
                mealRepository.delete(m);
            }
        }

    }
}
