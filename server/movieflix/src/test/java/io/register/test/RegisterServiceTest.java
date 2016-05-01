package io.register.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.movieflix.configuration.TestConfig;
import io.movieflix.dao.RegisterDao;
import io.movieflix.entity.Register;
import io.movieflix.exception.UserAlreadyExist;
import io.movieflix.exception.UserNotFound;
import io.movieflix.exception.UserRoleNotExist;
import io.movieflix.services.RegisterService;
import io.movieflix.services.RegisterServiceImpl;
import org.junit.Assert;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class RegisterServiceTest {

	@Mock
	private RegisterDao dao;
	
	@InjectMocks
	private RegisterService service = new RegisterServiceImpl();
	
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
	public void testLogin() throws UserNotFound, UserRoleNotExist{
		Mockito.when(dao.findByEmailandPassword(register.getEmail(), register.getPassword())).thenReturn(register);
		
		Register actual = service.login(register.getEmail(), register.getPassword());
		Assert.assertEquals(register, actual);
	}
	
	@Test(expected=UserNotFound.class)
	public void testLoginByNull() throws UserNotFound, UserRoleNotExist{
		Mockito.when(dao.findByEmailandPassword(register.getEmail(), register.getPassword())).thenReturn(null);
		
		service.login(register.getEmail(), register.getPassword());
	}
	
	@Test(expected=UserRoleNotExist.class)
	public void testLoginByRoleNotExist() throws UserNotFound, UserRoleNotExist{
		Mockito.when(dao.findByEmailandPassword(register.getEmail(), register.getPassword())).thenReturn(null);
		
		service.login(register.getEmail(), register.getPassword());
	}
	
	@Test
	public void testCreate() throws UserAlreadyExist{
		Mockito.when(dao.createUser(register)).thenReturn(null);
		service.createUser(register);
	}
	
	@Test(expected=UserAlreadyExist.class)
	public void testCreateByNull() throws UserAlreadyExist{
		Mockito.when(dao.createUser(register)).thenReturn(register);
		service.createUser(register);
	}
	
	
	
	
	
	
	
	
}
