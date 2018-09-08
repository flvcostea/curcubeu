package demo.health.controller;

import demo.health.model.Meal;
import demo.health.service.AlimentService;
import demo.health.service.MealService;
import demo.health.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class MealController {
    @Autowired
    private MealService mealService;

    @Autowired
    private PersonService personService;

    @Autowired
    private AlimentService alimentService;

    @RequestMapping(value = "/addMeal", method = RequestMethod.POST)
    public String addMeal(@RequestBody Meal meal) {
        return mealService.addMeal(meal);
    }

    @RequestMapping(value = "/meals", method = RequestMethod.GET)
    public List<Meal> getMeals() {
        return mealService.findAllMeals();
    }

    @RequestMapping(value= "/mealDate/{date}", method =RequestMethod.GET)
    public Meal mealDate  (@PathVariable("date") Date date )
    {
        return mealService.findByDate(date);
    }

    @RequestMapping(value = "/addAlimentMeal/{mealId}/{alimentId}", method = RequestMethod.POST)
    public Meal addAlimentMeal(@PathVariable("mealId") int mealId, @PathVariable("alimentId") int alimentId) {
        return mealService.addAlimentToMeal(alimentId, mealId);
    }

    @RequestMapping(value = "/deleteMeal/{id}", method = RequestMethod.DELETE)
    public void deleteMeal(@PathVariable("id") int id) {
        mealService.deleteMeal(id);
    }
}
