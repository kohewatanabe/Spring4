package com.example.training;

import java.util.List;

import com.example.training.entity.Training;
import com.example.training.repository.JdbcTrainingRepository;
import com.example.training.repository.TrainingRepository;
import com.example.training.service.TrainingService;
import com.example.training.service.TrainingServiceImpl;

public class TrainingApplication {//おそらくこのファイルがController。
    public static void main(String[] args) {
        TrainingRepository trainingRepository = new JdbcTrainingRepository();
        TrainingService trainingService = new TrainingServiceImpl(trainingRepository);

        List<Training> trainings = trainingService.findAll();//業務ロジックを呼び出す。
        for (Training training : trainings) {
            System.out.println(training.getTitle());
        }
    }
}

