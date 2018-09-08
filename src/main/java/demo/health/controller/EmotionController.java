package demo.health.controller;

import demo.health.model.Emotion;
import demo.health.model.Mood;
import demo.health.service.EmotionService;
import demo.health.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmotionController {
    @Autowired
    EmotionService emotionService;

    @Autowired
    MoodService moodService;

    @RequestMapping(value = "/addEmotion", method = RequestMethod.POST)
    public String addEmotion(@RequestBody Emotion emotion) {

        List<Mood> moods = new ArrayList<Mood>();
        emotion.setMoods(moods);

        return emotionService.addEmotion(emotion);
    }

    @RequestMapping(value = "/emotions", method = RequestMethod.GET)
    public List<Emotion> getEmotions() {
        return emotionService.findAllEmotions();
    }

    @RequestMapping(value = "/emotionId/{id}", method = RequestMethod.GET)
    public Emotion emotionId(@PathVariable("id") int id) {
        return emotionService.findById(id);
    }


    @RequestMapping(value = "/updateEmotion/{id}", method = RequestMethod.PUT)
    public Emotion updateEmotion(@PathVariable("id") int id, @RequestBody Emotion emotion) {

        return emotionService.updateEmotion(id, emotion);

    }

    @RequestMapping(value = "/deleteEmotion/{id}", method = RequestMethod.DELETE)
    public void deleteEmotion(@PathVariable("id") int id) {
        emotionService.deleteEmotion(id);
    }
}
