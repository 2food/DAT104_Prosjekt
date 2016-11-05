package no.hib.dat104.project.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import no.hib.dat104.project.model.User;

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
	
	public User findUser(Integer uid) {
		return em.find(User.class, uid);
	}
	
	/*
	 * Finner User ved username som parameter.
	 * @param String
	 * @return User
	 * @author Tormod
	 */
	public User findUser(String username) {
		User user = null;
		List<User> list = allUsers();
		for (User u : list) {
			if (u.getUser_name().equals(username)) {
				user = findUser(u.getUid());
			}
		}
		return user;
	}
	
	public void updateUser(User s) {
		em.merge(s);
	}
	
	public void removeUser(int uid) {
		em.remove(em.find(User.class, uid));
	}
	
	public boolean isOpen(){
		return em.isOpen();
	}
	
	public EntityTransaction getTransaction() {
		return em.getTransaction();
	}
	

}
