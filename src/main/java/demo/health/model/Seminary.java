package demo.health.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Seminary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    @Type(type="date")
    private Date date;
    private String location;
    private int nbOfSeats;

    @com.fasterxml.jackson.annotation.JsonIgnore
    @ManyToOne
    private Speaker speaker;

    @JsonIgnore
    @OneToMany(mappedBy = "seminary")
    private List<Booking> bookings;

    public Seminary() {
    }

    public Seminary(String title, Date date, String location, int nbOfSeats, Speaker speaker, List<Booking> bookings) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.nbOfSeats = nbOfSeats;
        this.speaker = speaker;
        this.bookings = bookings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNbOfSeats() {
        return nbOfSeats;
    }

    public void setNbOfSeats(int nbOfSeats) {
        this.nbOfSeats = nbOfSeats;
    }


    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }


    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
