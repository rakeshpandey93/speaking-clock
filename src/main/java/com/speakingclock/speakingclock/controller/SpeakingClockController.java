package com.speakingclock.speakingclock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speakingclock.speakingclock.exception.InvalidTimeException;
import com.speakingclock.speakingclock.service.SpeakingClockService;

@RestController
@RequestMapping("/api")
public class SpeakingClockController {
	
	
	private  SpeakingClockService speakingClockService;

	@Autowired
	@Qualifier("speakingClockService")
	public void setClientService(SpeakingClockService speakingClockService){
	    this.speakingClockService=speakingClockService;
	}
	
	@GetMapping("/speaking/clock/{time}")
	public String getSpeakingClockInWords(@PathVariable String time) throws InvalidTimeException{
		
		String convertInWords=speakingClockService.convert(time);
	    return convertInWords;
	}

}
