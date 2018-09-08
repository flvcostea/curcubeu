package demo.health.service;

import demo.health.model.Meal;

import java.util.Date;
import java.util.List;

public interface MealService {
    String addMeal(Meal meal);

    List<Meal> findAllMeals();

    public Meal findByDate(Date date);

    Meal addAlimentToMeal(int alimentId, int mealId);

    void deleteMeal(int id);
}
