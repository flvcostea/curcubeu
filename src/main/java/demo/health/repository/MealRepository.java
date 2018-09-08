package demo.health.repository;

import demo.health.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("mealRepository")
public interface MealRepository extends JpaRepository<Meal, Integer> {
}
