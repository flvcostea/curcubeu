package demo.health.repository;

import demo.health.model.Aliment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("alimentRepository")
public interface AlimentRepository extends JpaRepository<Aliment, Integer> {
}
