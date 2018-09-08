package demo.health.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSubTypes;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int height;
    private int weight;
    private String sex;
    private int age;


    @com.fasterxml.jackson.annotation.JsonIgnore
    @OneToMany(mappedBy="person")
    private List<Meal> meals;

    @com.fasterxml.jackson.annotation.JsonIgnore
    @OneToMany(mappedBy="person")
    private List<Mood>moods;

    @com.fasterxml.jackson.annotation.JsonIgnore
    @OneToMany(mappedBy="person")
    private List<Recreation> recreations;

    @com.fasterxml.jackson.annotation.JsonIgnore
    @OneToMany(mappedBy="person")
    private List<Booking> booking;

    public Person() {
    }

    public Person(String name, int height, int weight, String sex, int age, List<Meal> meals, List<Mood> moods, List<Recreation> recreations, List<Booking> booking) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.age = age;
        this.meals = meals;
        this.moods = moods;
        this.recreations = recreations;
        this.booking = booking;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Mood> getMoods() {
        return moods;
    }

    public void setMoods(List<Mood> moods) {
        this.moods = moods;
    }

    public List<Recreation> getRecreations() {
        return recreations;
    }

    public void setRecreations(List<Recreation> recreations) {
        this.recreations = recreations;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }
}
