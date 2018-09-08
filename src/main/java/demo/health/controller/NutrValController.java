package demo.health.controller;

import demo.health.model.Aliment;
import demo.health.model.NutritionalValue;
import demo.health.service.AlimentService;
import demo.health.service.NutritionalValService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NutrValController {

    @Autowired
    private NutritionalValService nutritionalValService;

/*
    @RequestMapping(value="/addNVal", method= RequestMethod.POST)
    public String addNValue(@RequestBody NutritionalValue nutritionalValue) {

        return nutritionalValService.addNVal(nutritionalValue);
    }
*/

    @RequestMapping(value = "/nValues", method = RequestMethod.GET)
    public List<NutritionalValue> getNValues() {
        return nutritionalValService.findAllNVal();
    }

    @RequestMapping(value = "/nValuesId/{id}", method = RequestMethod.GET)
    public NutritionalValue nValId (@PathVariable("id") int id) {
        return nutritionalValService.findById(id);
    }


    @RequestMapping(value = "/updateNValues/{id}", method = RequestMethod.PUT)
    public NutritionalValue updateNValues (@PathVariable("id") int id, @RequestBody NutritionalValue nutritionalValue  ) {

        return nutritionalValService.updateNutritionalValue(id, nutritionalValue);

    }

}
