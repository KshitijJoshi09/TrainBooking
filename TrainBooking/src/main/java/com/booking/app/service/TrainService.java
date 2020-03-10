package com.booking.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.app.dto.Train;
import com.booking.app.respository.TrainRepository;

@Service
public class TrainService {

	@Autowired
	private TrainRepository trainRepository;

	public int saveTrain(Train train) {

		return trainRepository.saveTrain(train);
	}

	public List<Train> searchTrainByDestination(String from, String to) {
		List<Train> trains = trainRepository.searchTrainByDestination(from, to);
		// busness logic for gst will be written below

		for (Train train : trains) {

			double gst = 1.18;
			train.setTrainFare(train.getTrainFare() * gst);

		}

		return trains;
	}

	public void deleteTrainById(int id) {
		trainRepository.deleteTrainById(id);
	}

	public Train findTrainById(int id) {
	return trainRepository.findTrainById(id);
		
	}

	public void updateTrain(Train train) {
		trainRepository.updateTrain(train);
	}

}
