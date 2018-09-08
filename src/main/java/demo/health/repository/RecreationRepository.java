package demo.health.repository;

import demo.health.model.Recreation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("recreationRepository")
public interface RecreationRepository extends JpaRepository<Recreation,Integer> {
}
