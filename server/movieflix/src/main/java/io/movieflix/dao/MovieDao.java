package io.movieflix.dao;

import java.util.List;

import io.movieflix.entity.MovieFlix;

public interface MovieDao {
	
	public List<MovieFlix> findList(int initialValue, int maxValue);
	//public List<MovieFlix> sortValue(String value);
	public List<MovieFlix> showTopRatedMovies();
	public List<MovieFlix> showTopRatedTvseries();
	public MovieFlix showDetail(String id);
	public List<MovieFlix> searchValueByType(String type);
	public List<MovieFlix> searchValueByYear(String year);
	public List<MovieFlix> searchValueByGenre(String genre);
}
