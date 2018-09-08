package demo.health.repository;

import demo.health.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("speakerRepository")
public interface SpeakerRepository extends JpaRepository<Speaker, Integer> {
}
