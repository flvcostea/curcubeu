package demo.health.controller;

import demo.health.model.Booking;
import demo.health.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/addBooking", method = RequestMethod.POST)
    public String addBooking(@RequestBody Booking booking) {
        return bookingService.addBooking(booking);
    }

    @RequestMapping(value = "/bookings", method = RequestMethod.GET)
    public List<Booking> findAll() {

        return bookingService.findAllBookings();
    }

    @RequestMapping(value = "/bookingId/{id}", method = RequestMethod.GET)
    public Booking bookingId(@PathVariable("id") int id) {
        return bookingService.findById(id);
    }


    @RequestMapping(value = "/deleteBooking/{id}", method = RequestMethod.DELETE)
    public void deleteBooking(@PathVariable("id") int id) {
        bookingService.deleteBooking(id);
    }

}
