package com.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.booking.app.dto.Train;
import com.booking.app.service.TrainService;

@Controller
public class TrainController {
	
	//auto the service
	@Autowired
	private TrainService trainService;
	

	// this method will be used to dispaly save page for train
	@RequestMapping("/saveTrainPage")
	public String displaySaveTrainPage() {
		return "saveTrainPage";
	}
	
	// this method is to get data from <form>tag
	// in saveTrainPage.jsp file
	@RequestMapping(value = "/saveTrain" 
			, method = RequestMethod.POST)
	public String saveTrain(Train train ,BindingResult result, Model model) {
		System.out.println(train);
		
		if(result.hasErrors()) {
			
			model.addAttribute("msg", "wrong data entered");
			return "saveTrainPage";
		}
	
		int pk = trainService.saveTrain(train);	
		if(pk > 0) {
			
			model.addAttribute("msg", "train saved with pk ->+ " +pk);
			return "saveTrainPage";
		}
		else{
			model.addAttribute("msg", "train not saved");
		}

		return "saveTrainPage";
	}
	
	
	

}
