package demo.health.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private String email;
    private  String description;
    private String role;

    @Lob
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Blob image;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;


    public User() {
    }

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public User(String username, String password, String email, String description, String role, Person person) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.description = description;
        this.role = role;
        this.person = person;
    }


    public User(int id,String username, String password, String email, String role, Person person) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
