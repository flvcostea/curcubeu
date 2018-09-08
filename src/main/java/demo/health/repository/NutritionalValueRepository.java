package demo.health.repository;

import demo.health.model.NutritionalValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("nutrValueRepository")
public interface NutritionalValueRepository extends JpaRepository<NutritionalValue, Integer> {
}
