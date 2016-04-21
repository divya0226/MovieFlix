package io.movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="User Already Exist")
public class UserAlreadyExist extends Exception {
	
	private static final long serialVersionUID = 1L;

}
