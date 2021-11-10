package io.github.mariazevedo88.travelsapi.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.mariazevedo88.travelsapi.model.Statistic;
import io.github.mariazevedo88.travelsapi.model.Travel;
import io.github.mariazevedo88.travelsapi.service.StatisticService;
import io.github.mariazevedo88.travelsapi.service.TravelService;

/**
 * SpringBoot RestController that creates all service end-points related to the statistics.
 * 
 */
@RestController
@RequestMapping("/api-travels/statistics")
public class StatisticController {
	
	public String hello() { 
		return "Ola Mundo";
	}
	private static final Logger logger = Logger.getLogger(StatisticController.class);
	
	@Autowired
	private TravelService tripsService;
	
	@Autowired
	private StatisticService statisticsService;
	
	
	/**
	 * Method that returns the statistics based on the trips
	 * 
	 * @return ResponseEntity - 200
	 */
	@GetMapping(produces = { "application/json" })
	public ResponseEntity<Statistic> getStatistics() {
		
		List<Travel> trips = tripsService.find();
		Statistic statistics = statisticsService.create(trips);
		
		logger.info(statistics);
		
		return ResponseEntity.ok(statistics);
	}

}
