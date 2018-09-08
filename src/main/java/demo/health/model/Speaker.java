package demo.health.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.jws.Oneway;
import javax.persistence.*;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullName;
    private String emailAddress;

    @JsonIgnore
    @OneToMany(mappedBy="speaker")
    private List<Seminary> seminaries;

    public Speaker() {
    }

    public Speaker(String fullName, String emailAddress, List<Seminary> seminaries) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.seminaries = seminaries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Seminary> getSeminaries() {
        return seminaries;
    }

    public void setSeminaries(List<Seminary> seminaries) {
        this.seminaries = seminaries;
    }
}
