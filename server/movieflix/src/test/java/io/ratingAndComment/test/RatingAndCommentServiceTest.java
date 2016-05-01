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

import io.movieflix.configuration.TestConfig;
import io.movieflix.dao.RatingAndCommentDao;
import io.movieflix.entity.RatingAndComment;
import io.movieflix.services.RatingAndCommentService;
import io.movieflix.services.RatingAndCommentServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class RatingAndCommentServiceTest {

	@Mock
	private RatingAndCommentDao dao;
	
	@InjectMocks
	private RatingAndCommentService service = new RatingAndCommentServiceImpl();
	
	private RatingAndComment rac;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		RatingAndComment rac = new RatingAndComment();
		rac.setId(UUID.randomUUID().toString());
		rac.setFirstName("Divya");
		rac.setImdbId("23234124");
		rac.setComment("Like!!!");
		rac.setRating("9.0");
	}
	
	@Test
	public void testSaveUserOpinion(){
		Mockito.when(dao.saveUserOpinion(rac)).thenReturn(rac);
		service.saveUserOpinion(rac);
	}
}
