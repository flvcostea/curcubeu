package demo.health.service;

import demo.health.model.Booking;
import demo.health.model.Person;
import demo.health.model.Seminary;
import demo.health.repository.BookingRepository;
import demo.health.repository.PersonRepository;
import demo.health.repository.SeminaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {
    @Qualifier("bookingRepository")
    @Autowired
    BookingRepository bookingRepository;
    @Qualifier("personRepository")
    @Autowired
    PersonRepository personRepository;
    @Qualifier("seminaryRepository")
    @Autowired
    SeminaryRepository seminaryRepository;

    @Override
    public String addBooking(Booking booking) {
        if (booking != null) {



            Person person = personRepository.getOne(booking.getPerson().getId());
            Seminary seminary = seminaryRepository.getOne(booking.getSeminary().getId());

            booking.setPerson(person);
            booking.setSeminary(seminary);

            List<Booking> bookingsP = person.getBooking();
            List<Booking> bookingsS = seminary.getBookings();

            //adaugi in liste Bookingul nou care contine obiecte de tip Person si Seminary
            bookingsP.add(booking);
            bookingsS.add(booking);

            person.setBooking(bookingsP);
            seminary.setBookings(bookingsS);

            bookingRepository.save(booking);

        } else {
            return "Entry was not saved.";
        }
        return "Succesfully saved!";
    }


    @Override
    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(int id) {
        return bookingRepository.findById(id).get();
    }

    @Override
    public Booking findByDate(Date date) {
        for (Booking b : bookingRepository.findAll()) {
            if (b.getDateOfBooking().equals(date))
                return b;
        }
        return null;

    }

    @Override
    public void deleteBooking(int id) {

        Booking bookingFound=bookingRepository.getOne(id);

        Person person=bookingFound.getPerson();
        List<Booking> bookings=person.getBooking();

        Seminary seminary=bookingFound.getSeminary();
        List<Booking> bookings1=seminary.getBookings();



        for (Booking b:bookings)
        {
            if (b.equals(bookingFound))
            {
                bookingFound.setPerson(null);
                bookingRepository.delete(b);
            }
        }

        for(Booking b1: bookings1){
            if (b1.equals(bookingFound))
            {
                bookingFound.setSeminary(null);
                bookingRepository.delete(b1);
            }
        }


    }



}
