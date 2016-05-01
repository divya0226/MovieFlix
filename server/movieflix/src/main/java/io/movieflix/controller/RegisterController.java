package io.movieflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.movieflix.entity.Register;
import io.movieflix.exception.UserAlreadyExist;
import io.movieflix.exception.UserNotFound;
import io.movieflix.exception.UserRoleNotExist;
import io.movieflix.services.RegisterService;

@RestController
@RequestMapping(value="/register")
public class RegisterController {
	
	@Autowired
	public RegisterService registerService;
	

	@RequestMapping(value="/login/{emailid}/{password}", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Register login(@PathVariable("emailid") String email, @PathVariable("password") String password) throws UserNotFound, UserRoleNotExist{
		return registerService.login(email, password);
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Register createUser(@RequestBody Register register) throws UserAlreadyExist{
		return registerService.createUser(register);
	}
	
}
