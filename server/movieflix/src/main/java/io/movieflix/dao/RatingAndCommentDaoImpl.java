package io.movieflix.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.movieflix.entity.RatingAndComment;

@Repository
public class RatingAndCommentDaoImpl implements RatingAndCommentDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public RatingAndComment saveUserOpinion(RatingAndComment ratingAndComment) {
		
		em.persist(ratingAndComment);
		 return ratingAndComment;
	}

}
