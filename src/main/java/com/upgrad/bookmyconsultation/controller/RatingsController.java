package com.upgrad.bookmyconsultation.controller;

import com.upgrad.bookmyconsultation.dto.RatingDTO;
import com.upgrad.bookmyconsultation.entity.Rating;
import com.upgrad.bookmyconsultation.service.RatingsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RatingsController {

	@Autowired
	private RatingsService ratingsService;

	@Autowired
	private ModelMapper modelMapper;

	//create a post method named submitRatings with return type as ResponseEntity
		//define the method parameter rating of type Rating, use @RequestBody for mapping
		//submit the ratings
		//return http response with status set to OK
	@PostMapping(value="/ratings",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity submitRatings(@RequestBody RatingDTO ratingDTO){
		Rating rating = modelMapper.map(ratingDTO,Rating.class);
		ratingsService.submitRatings(rating);
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
