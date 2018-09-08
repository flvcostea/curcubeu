package demo.health.service;

import demo.health.model.Emotion;

import java.util.List;

public interface EmotionService {
    String addEmotion(Emotion emotion);

    List<Emotion> findAllEmotions();

    Emotion findById(int id);

    void deleteEmotion(int id);

    Emotion updateEmotion(int id, Emotion emotion);
}
