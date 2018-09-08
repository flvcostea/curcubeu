package demo.health.repository;

import demo.health.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("activityRepository")
public interface ActivityRepository extends JpaRepository<Activity,Integer> {
}
