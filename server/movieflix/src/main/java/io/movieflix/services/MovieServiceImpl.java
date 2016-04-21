package io.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.movieflix.dao.MovieDao;
import io.movieflix.entity.MovieFlix;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieDao movieDao; 

	@Override
	public List<MovieFlix> showList(int initialValue, int maxValue) {
		
		return movieDao.findList(initialValue, maxValue);
	}

	@Override
	public List<MovieFlix> showNextList(int initialValue, int maxValue) {
		
		return movieDao.findList(initialValue, maxValue);
	}

	@Override
	public List<MovieFlix> showPreviousList(int initialValue, int maxValue) {
		
		return movieDao.findList(initialValue, maxValue);
	}


	@Override
	public List<MovieFlix> showTopRatedMovies() {
		
		return movieDao.showTopRatedMovies();
	}

	@Override
	public List<MovieFlix> showTopRatedTvseries() {
		
		return movieDao.showTopRatedTvseries();
	}

	@Override
	public MovieFlix showDetail(String imdbId) {
		
		return movieDao.showDetail(imdbId);
	}

	@Override
	public List<MovieFlix> searchValue(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieFlix> searchValueByType(String type) {
		
		return movieDao.searchValueByType(type);
	}

	@Override
	public List<MovieFlix> searchValueByYear(String year) {
		
		return movieDao.searchValueByYear(year);
	}

	@Override
	public List<MovieFlix> searchValueByGenre(String genre) {
		
		return movieDao.searchValueByGenre(genre);
	}

//	@Override
//	public List<MovieFlix> sortValue(String value) {
//		
//		return movieDao.sortValue(value);
//	}
}
