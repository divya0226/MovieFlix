package io.register.test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
import io.movieflix.dao.RegisterDao;
import io.movieflix.dao.RegisterDaoImpl;
import io.movieflix.entity.Register;
import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class RegisterDaoTest {

	
	@Mock
	private EntityManager em;
	
	@InjectMocks
	private RegisterDao dao = new RegisterDaoImpl();
	
	@Mock
	private TypedQuery<Register> query;
	
	private Register register;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		Register register = new Register();
		register.setId(UUID.randomUUID().toString());
		register.setEmail("divyashree.vijaykgmail.com");
		register.setFirstName("divya");
		register.setLastName("vijay kumar");
		register.setPassword("blah");
		register.setRole("user");
	}
	
	@Test
	public void testCreateUser(){
		dao.createUser(register);
		Mockito.verify(em).persist(register);
	}
	
	@Test
	public void testFindByEmailAndPassword(){
		List<Register> expected = Arrays.asList(register);
		
		Mockito.when(em.createQuery("SELECT email, password FROM Register r WHERE r.email = emailid and r.password = password",
				Register.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);
		
		Register actual = dao.findByEmailandPassword(register.getEmail(), register.getPassword());
		Assert.assertEquals(expected, actual);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
