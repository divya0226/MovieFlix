package io.register.test;

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
import io.movieflix.controller.RegisterController;
import io.movieflix.entity.Register;
import io.movieflix.exception.UserAlreadyExist;
import io.movieflix.exception.UserNotFound;
import io.movieflix.exception.UserRoleNotExist;
import io.movieflix.services.RegisterService;
import io.movieflix.services.RegisterServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class RegisterControllerTest {

	
	@InjectMocks
	private RegisterController registerController;
	
	@Mock
	private RegisterService service = new RegisterServiceImpl();
	
	private Register register;
	
	MockMvc mockMvc;
	
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
		
		mockMvc = MockMvcBuilders.standaloneSetup(registerController).build();
	}
	
	
	@Test
	public void testLogin() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/login/" +register.getEmail() + register.getPassword()))
		.andExpect(MockMvcResultMatchers.status().isOk());

		Mockito.verify(service).login(register.getEmail(), register.getPassword());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testLoginUserNotFound() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/login/asdcasdfs/dcqv")).
		andExpect(MockMvcResultMatchers.status().isNotFound());
		
		Mockito.when(service.login(register.getEmail(), register.getPassword())).thenThrow(UserNotFound.class);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testLoginUserRoleNotFound() throws Exception{
		Mockito.when(service.login(register.getEmail(), register.getPassword())).thenThrow(UserRoleNotExist.class);
		mockMvc.perform(MockMvcRequestBuilders.post("/login/asdcasdfs/dcqv")).
		andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	@Test
	public void testCreate() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/create"))
		.andExpect(MockMvcResultMatchers.status().isOk());

		Mockito.verify(service).createUser(register);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCreateUserAlreadyExist() throws Exception{
		Mockito.when(service.createUser(register)).thenThrow(UserAlreadyExist.class);
		mockMvc.perform(MockMvcRequestBuilders.post("/create"))
		.andExpect(MockMvcResultMatchers.status().isFound());

		Mockito.verify(service).createUser(register);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
