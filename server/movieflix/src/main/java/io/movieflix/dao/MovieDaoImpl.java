package io.movieflix.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.movieflix.entity.MovieFlix;

@Repository
public class MovieDaoImpl implements MovieDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<MovieFlix> findList(int initialValue, int maxValue) {
		//SELECT * from Register limit initialValue, maxValue
		Query query = em.createQuery("from MovieFlix");
		query.setFirstResult(initialValue);
		query.setMaxResults(maxValue);
		List<MovieFlix> result = query.getResultList();
		return result;
	}

	@Override
	public List<MovieFlix> showTopRatedMovies() {
		TypedQuery<MovieFlix> query = em.createQuery("SELECT * FROM MovieFlix WHERE type =: pMovie ORDER BY imdbRating", MovieFlix.class);
		
		query.setParameter("pMovie", "movie");
		return query.getResultList();
	}

	@Override
	public List<MovieFlix> showTopRatedTvseries() {
		TypedQuery<MovieFlix> query = em.createQuery("ELECT * FROM MovieFlix WHERE type =: pTvseries ORDER BY imdbRating", MovieFlix.class);
		query.setParameter("pTvseries", "series");
		return query.getResultList();
	}

	@Override
	public MovieFlix showDetail(String imdbId) {
		
		return em.find(MovieFlix.class, imdbId);
	}

	@Override
	public List<MovieFlix> searchValueByType(String value) {
		TypedQuery<MovieFlix> query = em.createQuery("Select * from MovieFlix where type = value",MovieFlix.class);
		return query.getResultList();
	}

	@Override
	public List<MovieFlix> searchValueByYear(String value) {
		TypedQuery<MovieFlix> query = em.createQuery("Select * from MovieFlix where year = value",MovieFlix.class);
		return query.getResultList();
	}

	@Override
	public List<MovieFlix> searchValueByGenre(String value) {
		TypedQuery<MovieFlix> query = em.createQuery("Select * from MovieFlix where genre = value",MovieFlix.class);
		return query.getResultList();
	}

//	@Override
//		public List<MovieFlix> sortValue(String value) {
//		TypedQuery<MovieFlix> query = em.createQuery("Select * from MovieFlix ordery by value");
//		return query.getResultList();
//	}
}
