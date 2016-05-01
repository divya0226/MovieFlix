package io.movieflix.test;


import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.movieflix.configuration.TestConfig;
import io.movieflix.dao.MovieDao;
import io.movieflix.entity.MovieFlix;
import io.movieflix.services.MovieService;
import io.movieflix.services.MovieServiceImpl;
import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class MovieServiceTest {

	
	@Mock
	private MovieDao dao;
	
	@InjectMocks
	private MovieService service = new MovieServiceImpl();
	
	private MovieFlix movie;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		MovieFlix movie = new MovieFlix();
		movie.setTitle("Age of Ultron");
		movie.setYear("2015");
		movie.setRated("PG-13");
		movie.setReleased("01 May 2015");
		movie.setRuntime("141 min");
		movie.setGenre("Action, Adventure, Sci-Fi");
		movie.setDirector("Joss Whedon");
		movie.setWriters("Joss Whedon");
		movie.setActors("Robert Downey Jr");
		movie.setPlot("When Tony Stark and Bruce Banner try to jump-start.");
		movie.setLanguage("English");
		movie.setCountry("USA");
		movie.setAwards("1 win & 12 nominations.");
		movie.setPoster(
				"http://ia.media-imdb.com/images/M/MV5BMTU4MDU3NDQ5Ml5BMl5BanBnXkFtZTgwOTU5MDUxNTE@._V1_SX300.jpg");
		movie.setMetascore("66");
		movie.setImdbRating("7.6");
		movie.setImdbVotes("370,909");
		movie.setimdbID("tt2395427");
		movie.setType("movie");
	}
	
	@Test
	public void testShowList(){
		
		List<MovieFlix> expected = Arrays.asList(movie);
		Mockito.when(dao.findList(0, 5)).thenReturn(expected);
		
		List<MovieFlix> actual = service.showList(0, 5);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testShowNextList(){
		
		List<MovieFlix> expected = Arrays.asList(movie);
		Mockito.when(dao.findList(0, 5)).thenReturn(expected);
		
		List<MovieFlix> actual = service.showNextList(0, 5);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testShowPreviousList(){
		
		List<MovieFlix> expected = Arrays.asList(movie);
		Mockito.when(dao.findList(0, 5)).thenReturn(expected);
		
		List<MovieFlix> actual = service.showPreviousList(0, 5);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testSearchByType(){
		
		List<MovieFlix> expected = Arrays.asList(movie);
		Mockito.when(dao.searchValueByType(movie.getType())).thenReturn(expected);
		
		List<MovieFlix> actual = service.searchValueByType(movie.getType());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testSearchByYear(){
		
		List<MovieFlix> expected = Arrays.asList(movie);
		Mockito.when(dao.searchValueByYear(movie.getYear())).thenReturn(expected);
		
		List<MovieFlix> actual = service.searchValueByYear(movie.getYear());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testSearchByGenre(){
		
		List<MovieFlix> expected = Arrays.asList(movie);
		Mockito.when(dao.searchValueByGenre(movie.getGenre())).thenReturn(expected);
		
		List<MovieFlix> actual = service.searchValueByGenre(movie.getGenre());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testShowTopRatedMovies(){
		service.showTopRatedMovies();
		Mockito.verify(dao).showTopRatedMovies();
	}
	
	@Test
	public void testShowTopRatedTvSeries(){
		service.showTopRatedTvseries();
		Mockito.verify(dao).showTopRatedTvseries();
	}
	
	@Test
	public void testShowDetail(){
		service.showDetail(movie.getimdbID());
		Mockito.verify(dao).showDetail(movie.getimdbID());
	}
	
}
