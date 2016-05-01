package io.movieflix.services;

import io.movieflix.entity.Register;
import io.movieflix.exception.UserAlreadyExist;
import io.movieflix.exception.UserNotFound;
import io.movieflix.exception.UserRoleNotExist;

public interface RegisterService {

	public Register login(String email, String password) throws UserNotFound, UserRoleNotExist;
	public Register createUser(Register register) throws UserAlreadyExist;
	
}
