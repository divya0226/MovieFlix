package io.movieflix.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import io.movieflix.entity.Register;

@Repository
public class RegisterDaoImpl implements RegisterDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Register createUser(Register register) {
		register.setRole("user");
		em.persist(register);
		
		return register;
	}

	@Override
	public Register findByEmailandPassword(String emailid, String password) {

		TypedQuery<Register> query = em.createQuery(
				"SELECT email, password FROM Register r WHERE r.email = emailid and r.password = password",
				Register.class);
		List<Register> list = query.getResultList();
		if (list != null && list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}


	@Override
	public List<Register> findByEmail(String email) {
		TypedQuery<Register> query = em.createQuery("Register.findByEmail", Register.class);
		query.setParameter("pEmail", email);
		return query.getResultList();
//		if (result != null && result.size() == 1) {
//			return null;
//		} else {
//
//			return result.get(0);
//		}
	}

}
