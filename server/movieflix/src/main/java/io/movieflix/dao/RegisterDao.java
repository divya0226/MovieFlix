package io.movieflix.dao;

import java.util.List;

import io.movieflix.entity.Register;

public interface RegisterDao {

	public Register createUser(Register register);
	public Register findByEmailandPassword(String emailid, String password);
	public List<Register> findByEmail(String email);
}
