package demo.health.repository;

import demo.health.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("bookingRepository")
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
