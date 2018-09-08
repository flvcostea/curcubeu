package demo.health.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonIgnore
    @ManyToOne
    private Person person;

    @JsonIgnore
    @ManyToOne
    private Seminary seminary;
    @Type(type="date")
    private Date dateOfBooking;
    private int nbTickets;


    public Booking() {
    }

    public Booking(Person person, Seminary seminary, Date dateOfBooking, int nbTickets) {
        this.person = person;
        this.seminary = seminary;
        this.dateOfBooking = dateOfBooking;
        this.nbTickets = nbTickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public Seminary getSeminary() {
        return seminary;
    }

    public void setSeminary(Seminary seminary) {
        this.seminary = seminary;
    }

    public Date getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(Date dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public int getNbTickets() {
        return nbTickets;
    }

    public void setNbTickets(int nbTickets) {
        this.nbTickets = nbTickets;
    }
}
