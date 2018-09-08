package demo.health.controller;

import demo.health.model.Seminary;
import demo.health.service.SeminaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeminaryController {

    @Autowired
    SeminaryService seminaryService;

    @RequestMapping(value = "/addSeminary", method = RequestMethod.POST)
    public String addSeminary(@RequestBody Seminary seminary) {
        return seminaryService.addSeminary(seminary);
    }

    @RequestMapping(value = "/seminaries", method = RequestMethod.GET)
    public List<Seminary> findAll() {

        return seminaryService.findAllSeminaries();
    }

    @RequestMapping(value = "/seminaryId/{id}", method = RequestMethod.GET)
    public Seminary seminaryId(@PathVariable("id") int id) {
        return seminaryService.findById(id);
    }

    @RequestMapping(value = "/seminaryTitle/{title}", method = RequestMethod.GET)
    public Seminary seminaryTitle(@PathVariable("title") String title) {
        return seminaryService.findByTitle(title);
    }

    @RequestMapping(value = "/updateSeminary/{id}", method = RequestMethod.PUT)
    public Seminary updateSeminary(@PathVariable("id") int id, @RequestBody Seminary seminary) {

        return seminaryService.updateSeminary(id, seminary);
    }



}
