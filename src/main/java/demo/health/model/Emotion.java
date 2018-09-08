package demo.health.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Emotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="emotion_id")
    private int id;
    private String emotionName;
    private String type;


    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "mood_emotion",
            joinColumns = { @JoinColumn(name = "emotion_id") },
            inverseJoinColumns = { @JoinColumn(name = "mood_id") })
    private List<Mood> moods;


    public Emotion() {
    }

    public Emotion(String emotionName, String type, List<Mood> moods) {
        this.emotionName = emotionName;
        this.type = type;
        this.moods = moods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmotionName() {
        return emotionName;
    }

    public void setEmotionName(String emotionName) {
        this.emotionName = emotionName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Mood> getMoods() {
        return moods;
    }

    public void setMoods(List<Mood> moods) {
        this.moods = moods;
    }
}
