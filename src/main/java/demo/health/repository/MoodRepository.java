package demo.health.repository;

import demo.health.model.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("moodRepository")
public interface MoodRepository extends JpaRepository<Mood, Integer> {
}
