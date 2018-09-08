package demo.health.repository;

import demo.health.model.Seminary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("seminaryRepository")
public interface SeminaryRepository extends JpaRepository<Seminary, Integer> {
}
