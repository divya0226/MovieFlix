package io.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.movieflix.dao.RatingAndCommentDao;
import io.movieflix.entity.RatingAndComment;


@Service
@Transactional
public class RatingAndCommentServiceImpl implements RatingAndCommentService {
	
	@Autowired
	private RatingAndCommentDao dao;

	@Override
	public RatingAndComment saveUserOpinion(RatingAndComment ratingAndComment) {
		
		return dao.saveUserOpinion(ratingAndComment);
	}

}
