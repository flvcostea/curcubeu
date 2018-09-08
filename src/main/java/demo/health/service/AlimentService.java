package demo.health.service;

import demo.health.model.Aliment;

import java.util.List;

public interface AlimentService {
    String addAliment(Aliment aliment);

    List<Aliment> findAllAliments();

    Aliment findById(int id);

    void deletebyId(int id);

    void deleteAliment(int id);

    public Aliment updateAliment(int id, Aliment aliment);

}
