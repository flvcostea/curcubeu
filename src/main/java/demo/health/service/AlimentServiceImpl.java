package demo.health.service;

import demo.health.model.Aliment;
import demo.health.model.Meal;
import demo.health.model.NutritionalValue;
import demo.health.model.Recreation;
import demo.health.repository.AlimentRepository;
import demo.health.repository.MealRepository;
import demo.health.repository.NutritionalValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service("alimentService")
public class AlimentServiceImpl implements AlimentService {

    @Qualifier("alimentRepository")
    @Autowired
    private AlimentRepository alimentRepository;

    @Autowired
    private NutritionalValueRepository nutritionalValueRepository;

    @Qualifier("mealRepository")
    @Autowired
    private MealRepository mealRepository;

    @Override
    @Transactional
    public String addAliment(Aliment aliment) {
        if (alimentRepository != null) {
            NutritionalValue nutritionalValue = nutritionalValueRepository.save(aliment.getNutritionalVal());
            aliment.setNutritionalVal(nutritionalValue);
            alimentRepository.save(aliment);
           // nutritionalValue.setAliment(aliment);
            //nutritionalValueRepository.save(nutritionalValue);

        } else {
            return "Entry was not saved.";
        }
        return "Succesfully saved!";
    }

    @Override
    public List<Aliment> findAllAliments() {
        return alimentRepository.findAll();
    }

    @Override
    public Aliment findById(int id) {
        return alimentRepository.getOne(id);
    }

    @Override
    public Aliment updateAliment(int id, Aliment aliment) {
        Aliment updatedAliment = findById(id);
        NutritionalValue nutritionalValue = nutritionalValueRepository.getOne(updatedAliment.getNutritionalVal().getId());

        if (aliment.getAlimentName()!=null)updatedAliment.setAlimentName(aliment.getAlimentName());
        if (aliment.getType()!=null)updatedAliment.setType(aliment.getType());

        nutritionalValue.setAliment(updatedAliment);

        return alimentRepository.save(updatedAliment);

    }


    //DELETE

    @Override
    public void deletebyId(int id) {
        //relatie one to tone aliment cu nutritional value
        Aliment deletedAliment = findById(id);
        NutritionalValue nutritionalValue = nutritionalValueRepository.getOne(deletedAliment.getNutritionalVal().getId());
        //stergi aliment-> stergi si nutrvalue


        nutritionalValueRepository.delete(nutritionalValue);
        alimentRepository.delete(deletedAliment);

        //stergere din lista de Meals??

    }

    @Override
    @Transactional
    public void deleteAliment(int id) {
        Aliment alimentFound = alimentRepository.getOne(id);

        List<Meal> meals = alimentFound.getMeals();
        for (Meal m : meals) {

                if (m.getAliments().contains(alimentFound)) {
                   List<Aliment> aliments =  m.getAliments();
                    aliments.remove(alimentFound);
                    m.setAliments(aliments);
                    mealRepository.save(m);



            }

        }
        NutritionalValue nutritionalValue = alimentFound.getNutritionalVal();
        nutritionalValue.setAliment(null);
        nutritionalValueRepository.delete(nutritionalValue);
        alimentRepository.delete(alimentFound);
    }


}
