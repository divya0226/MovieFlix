package io.movieflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.movieflix.entity.RatingAndComment;
import io.movieflix.services.RatingAndCommentService;

@RestController
@RequestMapping(value="/enter")
public class RatingAndCommentController {
	
	@Autowired
	private RatingAndCommentService service;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public RatingAndComment userOpinion(@RequestBody RatingAndComment ratingAndComment){
		return service.saveUserOpinion(ratingAndComment);
	}

}
