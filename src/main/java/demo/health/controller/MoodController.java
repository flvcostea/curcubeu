package demo.health.controller;

import demo.health.model.Mood;
import demo.health.service.EmotionService;
import demo.health.service.MoodService;
import demo.health.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class MoodController {
    @Autowired
    private MoodService moodService;


    @InitBinder
    public static void bindingPreparationUtil(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
    }
    @RequestMapping(value = "/addMood", method = RequestMethod.POST)
    public String addMood(@RequestBody Mood mood) {
        return moodService.addMood(mood);
    }

    @RequestMapping(value = "/moods", method = RequestMethod.GET)
    public List<Mood> getMoods() {
        return moodService.findAllMoods();
    }


    @RequestMapping(value = "/moodDate/{date}", method = RequestMethod.GET)
    public Mood moodDate(@PathVariable("date") Date date) {
        return moodService.findByDate(date);
    }

    @RequestMapping(value = "/addEmotionMood/{moodId}/{emotionId}", method = RequestMethod.GET)
    public void addEmotionMood(@PathVariable("moodId") int moodId, @PathVariable("emotionId") int emotionId) {
      moodService.addEmotionToMood(emotionId, moodId);
    }

    @RequestMapping(value = "/deleteMood/{id}", method = RequestMethod.DELETE)
    public void deleteMood(@PathVariable("id") int id) {
        moodService.deleteMood(id);
    }
}

