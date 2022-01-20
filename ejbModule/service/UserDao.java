package service;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.IUserLocal;
import dao.IUserRemote;
import entity.User;

@Stateless(name="user")
@PermitAll
public class UserDao implements IUserLocal,IUserRemote{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(User user) {
		em.persist(user);
	}

	@Override
	public List<User> findAll() {
		return em.createQuery("select u from User u",User.class).getResultList();
	}

	@Override
	public void deleteById(long id) {
		User user=findById(id);
		em.remove(user);
		
	}

	@Override
	public void update(User u) {
		User user=findById(u.getId());
		if(user != null) {
			user.setNom(u.getNom());
			user.setPrenom(u.getPrenom());
			user.setEmail(u.getEmail());
			user.setTelephone(u.getTelephone());
			user.setDateNaissance(u.getDateNaissance());
			em.persist(em.contains(user) ? user : em.merge(user));
		}
	}

	@Override
	public User findById(long id) {
		return em.find(User.class, id);
	}

}
