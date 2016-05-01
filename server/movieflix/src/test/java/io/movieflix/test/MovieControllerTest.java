package io.movieflix.test;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import io.movieflix.configuration.TestConfig;
import io.movieflix.controller.MovieController;
import io.movieflix.entity.MovieFlix;
import io.movieflix.services.MovieService;
import io.movieflix.services.MovieServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class MovieControllerTest {

	@Mock
	private MovieService service = new MovieServiceImpl();

	@InjectMocks
	private MovieController movieController;

	private MovieFlix movie;

	MockMvc mockMvc;

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

		mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
	}

	@Test
	public void testMovielist() throws Exception {
		int initialValue = 10;
		mockMvc.perform(MockMvcRequestBuilders.get("/list/initialList/{initialValue}", initialValue))
				.andExpect(MockMvcResultMatchers.status().isOk());

		Mockito.verify(service).showList(initialValue, 10);
	}

	@Test
	public void testNextMovieList() throws Exception {
		int nextValue = 10;
		mockMvc.perform(MockMvcRequestBuilders.get("/list/nextList/{nextValue}", nextValue))
				.andExpect(MockMvcResultMatchers.status().isOk());

		Mockito.verify(service).showNextList(nextValue, 10);
	}

	@Test
	public void testPreviousMovieList() throws Exception {
		int previousValue = 0;
		mockMvc.perform(MockMvcRequestBuilders.get("/list/previousList/{previousValue}", previousValue))
				.andExpect(MockMvcResultMatchers.status().isOk());

		Mockito.verify(service).showPreviousList(previousValue, 10);
	}

	@Test
	public void testFilterByType() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/filter/" + movie.getType()))
				.andExpect(MockMvcResultMatchers.status().isOk());

		Mockito.verify(service).searchValueByType(movie.getType());
	}

	@Test
	public void testFilterByYear() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/filter/" + movie.getYear()))
				.andExpect(MockMvcResultMatchers.status().isOk());

		Mockito.verify(service).searchValueByYear(movie.getYear());
	}

	@Test
	public void testFilterByGenre() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/filter/" + movie.getGenre()))
				.andExpect(MockMvcResultMatchers.status().isOk());

		Mockito.verify(service).searchValueByGenre(movie.getGenre());
	}

	@Test
	public void testGetDetail() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/getDetail/" + movie.getimdbID()))
				.andExpect(MockMvcResultMatchers.status().isOk());

		Mockito.verify(service).showDetail(movie.getimdbID());
	}

	@Test
	public void testShowTopRatedovies() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/topRatedMovies")).andExpect(MockMvcResultMatchers.status().isOk());

		Mockito.verify(service).showTopRatedMovies();
	}

	@Test
	public void testShowTopRatedTvSeries() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/topRatedTvseries"))
				.andExpect(MockMvcResultMatchers.status().isOk());

		Mockito.verify(service).showTopRatedTvseries();
	}

}
