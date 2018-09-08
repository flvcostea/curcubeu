package demo.health.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
public class Mood {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="mood_id")
    private int id;
    @JsonIgnore
    @ManyToOne
    private Person person;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "mood_emotion",
            joinColumns = { @JoinColumn(name = "mood_id") },
            inverseJoinColumns = { @JoinColumn(name = "emotion_id") })
    private List<Emotion> emotions;

    @Type(type="date")
    private Date moodDate;


    public Mood() {
    }

    public Mood(Person person, List<Emotion> emotions, Date moodDate) {
        this.person = person;
        this.emotions = emotions;
        this.moodDate = moodDate;
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

    public List<Emotion> getEmotions() {
        return emotions;
    }

    public void setEmotions(List<Emotion> emotions) {
        this.emotions = emotions;
    }

    public Date getMoodDate() {
        return moodDate;
    }

    public void setMoodDate(Date moodDate) {
        this.moodDate = moodDate;
    }
}
