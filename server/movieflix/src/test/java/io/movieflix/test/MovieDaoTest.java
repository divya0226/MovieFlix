package io.movieflix.test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
import io.movieflix.dao.MovieDaoImpl;
import io.movieflix.entity.MovieFlix;
import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class MovieDaoTest {

	@Mock
	private EntityManager em;

	@InjectMocks
	private MovieDao dao = new MovieDaoImpl();

	@Mock
	TypedQuery<MovieFlix> query;

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
	public void testFindList() {
		List<MovieFlix> expected = Arrays.asList(movie);

		Mockito.when(em.createQuery("from MovieFlix", MovieFlix.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);

		List<MovieFlix> movie = dao.findList(0, 5);
		Assert.assertEquals(expected, movie);

	}

	
	@Test
	public void testSearchByType(){
	
		List<MovieFlix> expected = Arrays.asList(movie);
		
		Mockito.when(em.createQuery("Select * from MovieFlix where type = value",MovieFlix.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);
		
		List<MovieFlix> actual = dao.searchValueByType(movie.getType());
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void testSearchByYear(){
		List<MovieFlix> expected = Arrays.asList(movie);
		
		Mockito.when(em.createQuery("Select * from MovieFlix where year = value",MovieFlix.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);
		
		List<MovieFlix> actual = dao.searchValueByYear(movie.getYear());
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void testSearchByGenre(){
		List<MovieFlix> expected = Arrays.asList(movie);
		
		Mockito.when(em.createQuery("Select * from MovieFlix where genre = value",MovieFlix.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);
		
		List<MovieFlix> actual = dao.searchValueByYear(movie.getGenre());
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testShowTopRatedMovies() {
		List<MovieFlix> expected = Arrays.asList(movie);

		Mockito.when(
				em.createQuery("SELECT * FROM MovieFlix WHERE type =: pMovie ORDER BY imdbRating", MovieFlix.class))
				.thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);

		List<MovieFlix> movie = dao.showTopRatedMovies();
		Assert.assertEquals(expected, movie);
	}

	@Test
	public void testShowTopRatedTvseries() {
		List<MovieFlix> expected = Arrays.asList(movie);

		Mockito.when(
				em.createQuery("SELECT * FROM MovieFlix WHERE type =: pTvseries ORDER BY imdbRating", MovieFlix.class))
				.thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);

		List<MovieFlix> movie = dao.showTopRatedTvseries();
		Assert.assertEquals(expected, movie);
	}

}
