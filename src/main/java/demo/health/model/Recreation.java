package demo.health.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Recreation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="recreation_id")
    private int id;
    @ManyToOne
    private Person person;
    @com.fasterxml.jackson.annotation.JsonIgnore
    @ManyToMany
    @JoinTable(name = "activity_recreation",
            joinColumns = { @JoinColumn(name = "recreation_id") },
            inverseJoinColumns = { @JoinColumn(name = "activity_id") })
    private List<Activity> activities;

    @Type(type="date")
    private Date activityDate;


    public Recreation() {
    }

    public Recreation(Person person, List<Activity> activities, Date activityDate) {
        this.person = person;
        this.activities = activities;
        this.activityDate = activityDate;
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

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

}
