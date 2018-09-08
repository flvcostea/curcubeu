package demo.health.service;

import demo.health.model.NutritionalValue;

import java.util.List;

public interface NutritionalValService {
    String addNVal(NutritionalValue nutritionalValue);

    List<NutritionalValue> findAllNVal();

    NutritionalValue findById(int id);

    NutritionalValue updateNutritionalValue(int id, NutritionalValue nutritionalValue);
}
