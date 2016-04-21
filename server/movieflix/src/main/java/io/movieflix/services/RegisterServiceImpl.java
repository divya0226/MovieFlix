package io.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.movieflix.dao.RegisterDao;
import io.movieflix.entity.Register;
import io.movieflix.exception.UserAlreadyExist;
import io.movieflix.exception.UserNotFound;
import io.movieflix.exception.UserRoleNotExist;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	public RegisterDao registerdao;

	@Override
	public Register login(String emailid, String password) throws UserNotFound, UserRoleNotExist {
		Register register = registerdao.findByEmailandPassword(emailid, password);
		if(register == null){
				throw new UserNotFound();
			}
		if(register.getRole() != "user" || register.getRole() != "admin"){
			throw new UserRoleNotExist();
		}
		return register;
	}

	@Override
	public Register createUser(Register register) throws UserAlreadyExist{
		List<Register> registerdList = registerdao.findByEmail(register.getEmail());
		if(registerdList == null || registerdList.size() == 0){
			registerdao.createUser(register);
		}
		throw new UserAlreadyExist();
	}

}
