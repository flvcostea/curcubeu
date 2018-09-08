package demo.health.controller;

import demo.health.model.Speaker;
import demo.health.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpeakerController {
    @Autowired
    private SpeakerService speakerService;

    @RequestMapping(value = "/addSpeaker", method = RequestMethod.POST)
    public String addSpeaker(@RequestBody Speaker speaker) {

        return speakerService.addSpeaker(speaker);
    }

    @RequestMapping(value = "/speakers", method = RequestMethod.GET)
    public List<Speaker> findAll() {

        return speakerService.findAllSpeakers();
    }

    @RequestMapping(value = "/speakerId/{id}", method = RequestMethod.GET)
    public Speaker speakerId(@PathVariable("id") int id) {
        return speakerService.findById(id);
    }

    @RequestMapping(value = "/speakerEmail/{emailAddress}", method = RequestMethod.GET)
    public Speaker speakerEmail(@PathVariable("emailAddress") String emailAddress) {
        return speakerService.findByEmail(emailAddress);
    }

    @RequestMapping(value = "/speakerName/{fullName}", method = RequestMethod.GET)
    public Speaker speakerFullName(@PathVariable("fullName") String fullName) {
        return speakerService.findByfullName(fullName);
    }

    @RequestMapping(value = "/updateSpeaker/{id}", method = RequestMethod.PUT)
    public Speaker updateSpeaker(@PathVariable("id") int id, @RequestBody Speaker speaker) {

        return speakerService.updateSpeaker(id, speaker);
    }

}
