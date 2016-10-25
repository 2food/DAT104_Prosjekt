package no.hib.dat104.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class UserEAO {

	@PersistenceContext(name = "s_test")
	private EntityManager em;


	
	public void addUser(User d) {
		em.persist(d);
	}

	public List<User> allUsers() {
		TypedQuery<User> query = em.createQuery("SELECT s FROM User s", User.class);
		List<User> q = query.getResultList();
		return q;
	}
	
	public User findUser(int uid) {
		return em.find(User.class, uid);
	}
	
	public void updateUser(User s) {
		em.merge(s);
	}
	
	public void removeUser(int uid) {
		em.remove(em.find(User.class, uid));
	}
	

}
