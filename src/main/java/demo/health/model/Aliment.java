package demo.health.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Aliment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="aliment_id")
    private int id;
    private String alimentName;

    @OneToOne
    private NutritionalValue nutritionalVal;


    private String type;

    @com.fasterxml.jackson.annotation.JsonIgnore
    @ManyToMany
    @JoinTable(name = "meal_aliment",
            joinColumns = { @JoinColumn(name = "aliment_id") },
            inverseJoinColumns = { @JoinColumn(name = "meal_id") })
    private List<Meal> meals;


    public Aliment() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlimentName() {
        return alimentName;
    }

    public void setAlimentName(String alimentName) {
        this.alimentName = alimentName;
    }

    public NutritionalValue getNutritionalVal() {
        return nutritionalVal;
    }

    public void setNutritionalVal(NutritionalValue nutritionalVal) {
        this.nutritionalVal = nutritionalVal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
