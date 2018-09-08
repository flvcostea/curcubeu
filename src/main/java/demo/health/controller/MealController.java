package demo.health.controller;

import demo.health.model.Meal;
import demo.health.service.AlimentService;
import demo.health.service.MealService;
import demo.health.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class MealController {
    @Autowired
    private MealService mealService;


    @InitBinder
    public static void bindingPreparationUtil(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
    }

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

    @RequestMapping(value = "/addAlimentMeal/{mealId}/{alimentId}", method = RequestMethod.GET)
    public void addAlimentMeal(@PathVariable("mealId") int mealId, @PathVariable("alimentId") int alimentId) {
         mealService.addAlimentToMeal(alimentId, mealId);
    }

    @RequestMapping(value = "/deleteMeal/{id}", method = RequestMethod.DELETE)
    public void deleteMeal(@PathVariable("id") int id) {
        mealService.deleteMeal(id);
    }
}
