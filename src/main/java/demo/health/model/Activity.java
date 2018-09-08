package demo.health.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="activity_id")
    private int id;
    private String activityName;
    private String type;

    @com.fasterxml.jackson.annotation.JsonIgnore
    @ManyToMany
    @JoinTable(name = "activity_recreation",
            joinColumns = { @JoinColumn(name = "activity_id") },
            inverseJoinColumns = { @JoinColumn(name = "recreation_id") })
    private List<Recreation> recreations;


    public Activity() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Recreation> getRecreation() {
        return recreations;
    }

    public void setRecreation(List<Recreation> recreations) {
        this.recreations = recreations;
    }
}
