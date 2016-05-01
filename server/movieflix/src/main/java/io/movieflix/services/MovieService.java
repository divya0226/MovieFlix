package io.movieflix.services;

import java.util.List;

import io.movieflix.entity.MovieFlix;

public interface MovieService {
	public List<MovieFlix> showList(int initialValue, int maxValue);
	public List<MovieFlix> showNextList(int initialValue, int maxValue);
	public List<MovieFlix> showPreviousList(int initialValue, int maxValue);
	public List<MovieFlix> searchValue(String value);
	//public List<MovieFlix> sortValue(String value);
	public List<MovieFlix> showTopRatedMovies();
	public List<MovieFlix> showTopRatedTvseries();
	public MovieFlix showDetail(String id);
	public List<MovieFlix> searchValueByType(String type);
	public List<MovieFlix> searchValueByYear(String year);
	public List<MovieFlix> searchValueByGenre(String genre);
}
