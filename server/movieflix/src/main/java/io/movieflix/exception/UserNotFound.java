package io.movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason = "User Not Found")
public class UserNotFound extends Exception{
	
	private static final long serialVersionUID = 1L;

}
