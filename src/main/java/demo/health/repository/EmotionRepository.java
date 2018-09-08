package demo.health.repository;

import demo.health.model.Emotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("emotionRepository")
public interface EmotionRepository extends JpaRepository<Emotion,Integer> {
}
