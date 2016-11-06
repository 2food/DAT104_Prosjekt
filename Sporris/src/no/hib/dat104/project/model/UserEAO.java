package no.hib.dat104.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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

	public List<Sporris> allSporris() {
		TypedQuery<Sporris> query = em.createQuery("SELECT s FROM Sporris s", Sporris.class);
		List<Sporris> q = query.getResultList();
		return q;
	}

	/**
	 * findUser workaround for fetch bugs
	 * @param uid
	 * @return user by uid
	 * @author Torstein
	 */
	public User findUserCascade(Integer uid) {
		User user = em.find(User.class, uid);
		user.setSporrises(allSporrisByUser(user));
		return user;
	}

	/**
	 * findSporris workaround for fetch bugs
	 * @param uid
	 * @return user by uid
	 * @author Torstein
	 */
	public Sporris findSporrisCascade(Integer uid) {
		Sporris sporris = em.find(Sporris.class, uid);
		sporris.setQuestions(allQuestionsBySporris(sporris));
		return sporris;
	}
	
	/**
	 * get all sporrises of user
	 * @param user
	 * @return List<Sporris>
	 * @author Torstein
	 */
	public List<Sporris> allSporrisByUser(User user) {
		TypedQuery<Sporris> query = em.createQuery("SELECT s FROM Sporris s", Sporris.class);
		List<Sporris> q = query.getResultList();
		List<Sporris> sl = new ArrayList<Sporris>();;
		for (Sporris s : q) {
			if (s.getSporris_user().equals(user)) {
				s.setQuestions(allQuestionsBySporris(s));
				sl.add(s);
			}
		}
		return sl;
	}


	/**
	 * get all questions of sporris
	 * @param sporris
	 * @return List<Question>
	 * @author Torstein
	 */
	public List<Question> allQuestionsBySporris(Sporris sporris) {
		TypedQuery<Question> query = em.createQuery("SELECT q FROM Question q", Question.class);
		List<Question> q = query.getResultList();
		List<Question> ql = new ArrayList<Question>();
		for (Question qu : q) {
			if (qu.getQuestion_sporris().equals(sporris)) {
				qu.setAlternatives(allAlternativesByQuestion(qu));
				ql.add(qu);
			}
		}		
		return ql;
	}


	/**
	 * get all alternatives of question
	 * @param question
	 * @return List<Alternative>
	 * @author Torstein
	 */
	public List<Alternative> allAlternativesByQuestion(Question question) {
		TypedQuery<Alternative> query = em.createQuery("SELECT a FROM Alternative a", Alternative.class);
		List<Alternative> q = query.getResultList();
		List<Alternative> al = new ArrayList<Alternative>();;
		for (Alternative a : q) {
			if (a.getAlternative_question().equals(question)) {
				al.add(a);
			}
		}
		return al;
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
				user = u;
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
	
	public void addQuestion(Question q) {
		em.persist(q);
	}
	
	public void updateQuestion(Question q) {
		em.merge(q);
	}
	
	public void addAlternative(Alternative a) {
		em.persist(a);
	}
	
	public void updateAlternative(Alternative a) {
		em.merge(a);
	}
	

}
