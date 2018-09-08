package demo.health.model;


import javax.persistence.*;

@Entity
public class NutritionalValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int kcals;
    private int proteins;
    private int lipids;
    private int carbohydrates;


    @com.fasterxml.jackson.annotation.JsonIgnore
    @OneToOne
    private Aliment aliment;


    public NutritionalValue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKcals() {
        return kcals;
    }

    public void setKcals(int kcals) {
        this.kcals = kcals;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getLipids() {
        return lipids;
    }

    public void setLipids(int lipids) {
        this.lipids = lipids;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Aliment getAliment() {
        return aliment;
    }

    public void setAliment(Aliment aliment) {
        this.aliment = aliment;
    }
}









