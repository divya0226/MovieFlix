package io.movieflix.dao;

import io.movieflix.entity.RatingAndComment;


public interface RatingAndCommentDao {

	public RatingAndComment saveUserOpinion(RatingAndComment ratingAndComment);
}
