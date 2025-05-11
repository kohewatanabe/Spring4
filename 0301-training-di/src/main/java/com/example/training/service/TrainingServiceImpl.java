package com.example.training.service;

import java.util.List;

import com.example.training.entity.Training;
import com.example.training.repository.TrainingRepository;

public class TrainingServiceImpl implements TrainingService {//Ropositoryオブジェクトが取得したデータを処理するServiceクラス。

    private final TrainingRepository trainingRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public List<Training> findAll() {//具体的な業務ロジック。ここではただRepositoryが取得したデータをそのままControllerに返しているだけ。
        return trainingRepository.selectAll();
    }

}
