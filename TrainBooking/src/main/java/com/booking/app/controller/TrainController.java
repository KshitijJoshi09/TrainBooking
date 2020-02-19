package com.booking.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.app.dto.Train;
import com.booking.app.service.TrainService;

@Controller
public class TrainController {

	// auto the service
	@Autowired
	private TrainService trainService;

	// this method will be used to dispaly save page for train
	@RequestMapping("/saveTrainPage")
	public String displaySaveTrainPage() {
		return "saveTrainPage";
	}

	// this method is to get data from <form>tag
	// in saveTrainPage.jsp file
	@RequestMapping(value = "/saveTrain", method = RequestMethod.POST)
	public String saveTrain(Train train, BindingResult result, Model model) {
		System.out.println(train);

		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();

			for (FieldError fieldError : errors) {
				model.addAttribute(fieldError.getField(), "this filed has some error");
			}

			/*
			 * String errorNames = "";
			 * 
			 * for (FieldError fieldError : errors) { errorNames += fieldError.getField()
			 * +" "; }
			 * 
			 * System.out.println("wrong data entered in " +errorNames);
			 * model.addAttribute("msg", "wrong data entered in " +errorNames);
			 */

			return "saveTrainPage";

		}

		int pk = trainService.saveTrain(train);
		if (pk > 0) {

			model.addAttribute("msg", "train saved with pk ->+ " + pk);
			return "saveTrainPage";
		} else {
			model.addAttribute("msg", "train not saved");
		}

		return "saveTrainPage";
	}

	// redirect to seacrh page
	@RequestMapping("/searchTrainPage")
	public String searchTrainPage() {
		return "searchTrainPage";
	}

	@RequestMapping("/searchTrainByDestination")
	public String searchTrain(@RequestParam String from, @RequestParam String to, Model model) {
		System.out.println("from -> " + from + "   to -> " + to);

		// logic to find train from db
		List<Train> trains = trainService.searchTrainByDestination(from, to);
		
		if (trains == null || trains.size() <= 0) {
			System.out.println("No trains avalilable");
		}

		for (Train train : trains) {
			System.out.println(train);
		}

		// return it to the same page
		// so that he can search more options
		return "searchTrainPage";
	}

}
