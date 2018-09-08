package demo.health.service;

import demo.health.model.Aliment;
import demo.health.model.NutritionalValue;
import demo.health.repository.AlimentRepository;
import demo.health.repository.NutritionalValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("nutritionalValService")
public class NutritionalValServiceImpl implements NutritionalValService {

    @Qualifier("nutrValueRepository")
    @Autowired
    private NutritionalValueRepository nutritionalValueRepository;

    @Qualifier("alimentRepository")
    @Autowired
    private AlimentRepository alimentRepository;

    @Override
    public String addNVal(NutritionalValue nutritionalValue) {
        if (nutritionalValue != null) {
           // Aliment aliment = alimentRepository.getOne(nutritionalValue.getAliment().getId());
           // nutritionalValue.setAliment(aliment);

            nutritionalValueRepository.save(nutritionalValue);
        } else {
            return "Entry was not saved.";
        }
        return "Succesfully saved!";
    }

    @Override
    public List<NutritionalValue> findAllNVal() {
        return nutritionalValueRepository.findAll();
    }

    @Override
    public NutritionalValue findById(int id) {
        return nutritionalValueRepository.getOne(id);
    }

    @Override
    public NutritionalValue updateNutritionalValue(int id, NutritionalValue nutritionalValue) {
        NutritionalValue updatedNutritionalValue = findById(id);
       // Aliment aliment = alimentRepository.getOne(updatedNutritionalValue.getAliment().getId());

        if(nutritionalValue.getCarbohydrates()!=0)updatedNutritionalValue.setCarbohydrates(nutritionalValue.getCarbohydrates());
        if(nutritionalValue.getKcals()!=0)updatedNutritionalValue.setKcals(nutritionalValue.getKcals());
        if(nutritionalValue.getProteins()!=0)updatedNutritionalValue.setProteins(nutritionalValue.getProteins());
        if(nutritionalValue.getLipids()!=0)updatedNutritionalValue.setLipids(nutritionalValue.getLipids());

       // aliment.setNutritionalVal(updatedNutritionalValue);

        return nutritionalValueRepository.save(updatedNutritionalValue);


    }
}
