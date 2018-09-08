package demo.health.service;

import demo.health.model.Mood;

import java.util.Date;
import java.util.List;

public interface MoodService {
    String addMood(Mood mood);

    List<Mood> findAllMoods();

    public Mood findByDate(Date date);

    Mood addEmotionToMood(int emotionId, int moodId);

    void deleteMood(int id);

}
