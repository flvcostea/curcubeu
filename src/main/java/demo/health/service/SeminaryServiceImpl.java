package demo.health.service;

import demo.health.model.Booking;
import demo.health.model.Seminary;
import demo.health.model.Speaker;
import demo.health.repository.BookingRepository;
import demo.health.repository.SeminaryRepository;
import demo.health.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.util.Date;
import java.util.List;

@Service("seminaryService")
public class SeminaryServiceImpl implements SeminaryService {
    @Qualifier("seminaryRepository")
    @Autowired
    SeminaryRepository seminaryRepository;

    @Qualifier("speakerRepository")
    @Autowired
    SpeakerRepository speakerRepository;


    @Qualifier("bookingRepository")
    @Autowired
    BookingRepository bookingRepository;

    @Override
    public String addSeminary(Seminary seminary) {
        if (seminary != null) {
            Speaker speaker = speakerRepository.getOne(seminary.getSpeaker().getId());
            seminary.setSpeaker(speaker);

            //lista de seminarii pt speaker ul gasit
            List<Seminary> seminaries = speaker.getSeminaries();
            seminaries.add(seminary);
            speaker.setSeminaries(seminaries);

            seminaryRepository.save(seminary);
        } else {
            return "Entry was not saved.";
        }
        return "Succesfully saved!";
    }

    @Override
    public List<Seminary> findAllSeminaries() {
        return seminaryRepository.findAll();
    }

    @Override
    public Seminary findById(int id) {
        return seminaryRepository.getOne(id);
    }

    @Override
    public Seminary findByTitle(String title) {
        for (Seminary s : seminaryRepository.findAll()) {
            if (s.getTitle().equals(title))
                return s;
        }
        return null;
    }

    @Override
    public Seminary findByDate(Date date) {
        for (Seminary s : seminaryRepository.findAll()) {
            if (s.getDate().equals(date))
                return s;
        }
        return null;

    }

    @Override
    public Seminary updateSeminary(int id, Seminary seminary) {

        Seminary updatedSeminary = findById(id);


           if (seminary.getDate()!=null) updatedSeminary.setDate(seminary.getDate());
           if (seminary.getTitle()!=null) updatedSeminary.setTitle(seminary.getTitle());

            //speaker stays the same
            updatedSeminary.setSpeaker(updatedSeminary.getSpeaker());

            if (seminary.getLocation()!=null)updatedSeminary.setLocation(seminary.getLocation());
            if (seminary.getNbOfSeats()!=0)updatedSeminary.setNbOfSeats(seminary.getNbOfSeats());

        return seminaryRepository.save(updatedSeminary);

    }

    @Override
    public void updateSeminarySpeaker(int idSeminar, int idSpeakerNew) {

        Seminary updatedSeminar = seminaryRepository.getOne(idSeminar);
        int idSpeakerOld;

        //ai idSpeakerNew
        idSpeakerOld = updatedSeminar.getSpeaker().getId();

        Speaker speakerOld = speakerRepository.getOne(idSpeakerOld);
        Speaker speakerNew = speakerRepository.getOne(idSpeakerNew);

        List<Seminary> seminariesOld = speakerOld.getSeminaries();
        List<Seminary> seminariesNew = speakerNew.getSeminaries();

        // adauga l in cea noua, elimina seminarul din lista veche
        //parcurge lista veche


        seminariesNew.add(updatedSeminar);
        speakerNew.setSeminaries(seminariesNew);
        updatedSeminar.setSpeaker(speakerNew);

        speakerRepository.save(speakerNew);

        for (Seminary s : seminariesOld) {

            if (s.equals(updatedSeminar)) {
                seminaryRepository.delete(s);
            }
        }

        speakerOld.setSeminaries(seminariesOld);
        speakerRepository.save(speakerOld);

        seminaryRepository.save(updatedSeminar);

    }
}



    /*
    @Override
    public void deleteSeminary(int id) {

        /*
        Seminary seminaryFound = seminaryRepository.getOne(id);
        Speaker speaker = seminaryFound.getSpeaker();
        List<Booking> bookings = seminaryFound.getBookings();

        List<Seminary> seminaries = speaker.getSeminaries();
        for (Seminary s : seminaries) {
            if (s.equals(seminaryFound)) {
                s.setSpeaker(null);
                seminaryRepository.delete(s);
            }
        }
        for (Booking b : bookings) {
            b.setSeminary(null);
            //*********DELETE BOOKING cu id ul respectiv**************
            bookingRepository.delete(b);
        }

        speaker.setSeminaries(seminaries);
        speakerRepository.save(speaker);
        seminaryRepository.delete(seminaryFound);
    }

          /*

        Seminary seminaryFound = seminaryRepository.getOne(id);
        Speaker speaker = seminaryFound.getSpeaker();

        List<Seminary> seminaries = speaker.getSeminaries();


        List<Booking> bookings = seminaryFound.getBookings();


        for (Seminary s : seminaries) {
            if (s.equals(seminaryFound)) {
                seminaryFound.setSpeaker(null);
                seminaryRepository.delete(s);
            }
        }



        for (Booking b1 : bookings) {
            if (b1.getSeminary().equals(seminaryFound)) {
                b1.setSeminary(null);
                bookingRepository.delete(b1);
            }
        }


        speaker.setSeminaries(seminaries);
        speakerRepository.save(speaker);

        seminaryFound.setSpeaker(null);
        seminaryFound.setBookings(null);
        seminaryRepository.delete(seminaryFound);
    }
     */







