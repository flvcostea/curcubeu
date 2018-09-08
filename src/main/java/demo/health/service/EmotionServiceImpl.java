package demo.health.service;

import demo.health.model.Emotion;
import demo.health.model.Mood;
import demo.health.repository.EmotionRepository;
import demo.health.repository.MoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("emotionService")
public class EmotionServiceImpl implements EmotionService {

    @Qualifier("emotionRepository")
    @Autowired
    private EmotionRepository emotionRepository;

    @Qualifier("moodRepository")
    @Autowired
    protected MoodRepository moodRepository;

    @Override
    public String addEmotion(Emotion emotion) {
        if (emotion != null) {
            emotionRepository.save(emotion);
        } else {
            return "Entry was not saved.";
        }
        return "Succesfully saved!";
    }

    @Override
    public List<Emotion> findAllEmotions() {
        return emotionRepository.findAll();
    }

    @Override
    public Emotion findById(int id) {
        return emotionRepository.getOne(id);
    }

    @Override
    public Emotion updateEmotion(int id, Emotion emotion) {
        Emotion updatedEmotion = findById(id);
        if (emotion.getEmotionName()!=null)updatedEmotion.setEmotionName(emotion.getEmotionName());
        if (emotion.getType()!=null)updatedEmotion.setType(emotion.getType());

        return emotionRepository.save(updatedEmotion);

    }

    //delete?

    @Override
    @Transactional
    public void deleteEmotion(int id) {

        Emotion emotionFound=emotionRepository.getOne(id);

        List<Mood> moods = emotionFound.getMoods();
        for(Mood m: moods)
        {
            if (m.getEmotions().contains(emotionFound)){
                List<Emotion> emotions=m.getEmotions();
                emotions.remove(emotionFound);
                m.setEmotions(emotions);
                moodRepository.save(m);
            }
        }
        emotionRepository.delete(emotionFound);

    }

}


