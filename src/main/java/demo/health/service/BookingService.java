package demo.health.service;

import demo.health.model.Booking;

import java.util.Date;
import java.util.List;

public interface BookingService {

    String addBooking(Booking booking);

    List<Booking> findAllBookings();

    Booking findById(int id);

    Booking findByDate(Date date);

    void deleteBooking(int id);
}
