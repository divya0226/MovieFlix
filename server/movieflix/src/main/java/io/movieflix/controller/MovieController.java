package io.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.movieflix.entity.MovieFlix;
import io.movieflix.services.MovieService;


@RestController
@RequestMapping(value="/list")
public class MovieController {

	
	@Autowired
	public MovieService movieService;
	
	//This value initially when the page loads will be (0,10);
	@RequestMapping(value="/initialList/{initialValue}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieFlix> movieList(@PathVariable("initialValue") int initialValue){
		return movieService.showList(initialValue, 10);
	}
	
	
	//When the user clicks on the next button, value should be (initialValue = initialValue + 10,10) and so on ..
	@RequestMapping(value="/nextList/{nextValue}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieFlix> nextMovielist(@PathVariable("nextValue") int nextValue){

		return movieService.showNextList(nextValue, 10);
	}
	
	//When the user clicks on the next button, value should be (previousValue = 9initialValue - 10,10) and so on ..
	@RequestMapping(value="/previousList/{previousValue}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieFlix> previousMovieList(@PathVariable("previousValue") int previousValue){
		
		return movieService.showPreviousList(previousValue, 10);
	}
	
	@RequestMapping(value="/filter/{filterType}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieFlix> filterByType(@PathVariable("filterType") String type){
		return movieService.searchValueByType(type);
	}
	
	@RequestMapping(value="/filter/{filterYear}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieFlix> filterByYear(@PathVariable("filterYear") String year){
		return movieService.searchValueByYear(year);
	}
	
	@RequestMapping(value="/filter/{filterGenre}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieFlix> filterByGenre(@PathVariable("filterGenre") String genre){
		return movieService.searchValueByGenre(genre);
	}
	
//	@RequestMapping(value="/sort/{sortByValue}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public List<MovieFlix> sortCatalog(@PathVariable("sortByValue") String value, @RequestBody List<MovieFlix> movieFlli){
//		return movieService.sortValue(value);
//	}
	
	@RequestMapping(value="/topRatedMovies", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieFlix> viewTopRatedMovies(){
		return movieService.showTopRatedMovies();
	}
	
	@RequestMapping(value="/topRatedTvseries", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieFlix> viewTopRatedTvseries(){
		return movieService.showTopRatedTvseries();
	}
	
	@RequestMapping(value="/getDetail/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieFlix detail(@PathVariable("id") String imdbId){
		
		return movieService.showDetail(imdbId);
	}
	
}










