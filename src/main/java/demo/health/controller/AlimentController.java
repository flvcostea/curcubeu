package demo.health.controller;


import demo.health.model.Aliment;
import demo.health.service.AlimentService;
import demo.health.service.MealService;
import demo.health.service.NutritionalValService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
public class AlimentController {
    @Autowired
    private AlimentService alimentService;


    @RequestMapping(value = "/addAliment", method = RequestMethod.POST)
    public String addAliment(@RequestBody Aliment aliment) {
        return alimentService.addAliment(aliment);
    }

    @RequestMapping(value = "/aliments", method = RequestMethod.GET)
    public List<Aliment> getAliments() {
        return alimentService.findAllAliments();
    }


    @RequestMapping(value = "/alimentId/{id}", method = RequestMethod.GET)
    public Aliment alimentId(@PathVariable("id") int id) {
        return alimentService.findById(id);
    }


    @RequestMapping(value = "/updateAliment/{id}", method = RequestMethod.PUT)
    public Aliment updateAliment(@PathVariable("id") int id, @RequestBody Aliment aliment) {

        return alimentService.updateAliment(id, aliment);

    }

    @RequestMapping(value = "/deleteAliment/{id}", method = RequestMethod.DELETE)
    public void deleteAliment(@PathVariable("id") int id) {

        alimentService.deleteAliment(id);

    }

}
