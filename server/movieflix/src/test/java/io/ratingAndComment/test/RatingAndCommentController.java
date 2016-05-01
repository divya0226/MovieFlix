package io.ratingAndComment.test;

import java.util.UUID;

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
import io.movieflix.entity.RatingAndComment;
import io.movieflix.services.RatingAndCommentService;
import io.movieflix.services.RatingAndCommentServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class RatingAndCommentController {

	
	@InjectMocks
	private RatingAndCommentController ratingCommentController;
	
	@Mock
	RatingAndCommentService service = new RatingAndCommentServiceImpl();
	
	private RatingAndComment rac;
	
	MockMvc mockMvc;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		RatingAndComment rac = new RatingAndComment();
		rac.setId(UUID.randomUUID().toString());
		rac.setFirstName("Divya");
		rac.setImdbId("23234124");
		rac.setComment("Like!!!");
		rac.setRating("9.0");
		
		mockMvc = MockMvcBuilders.standaloneSetup(ratingCommentController).build();
	}
	
	@Test
	public void testUserOpinion() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/opinion")).andExpect(MockMvcResultMatchers.status().isOk());

		Mockito.verify(service).saveUserOpinion(rac);
	}
}
