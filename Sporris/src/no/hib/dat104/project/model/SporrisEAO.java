package no.hib.dat104.project.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class SporrisEAO {

	
	@PersistenceContext(name = "s_test")
	private EntityManager em;


	
	public void addSporris(Sporris d) {
		em.persist(d);
	}

	public List<Sporris> allSporris() {
		TypedQuery<Sporris> query = em.createQuery("SELECT s FROM User s", Sporris.class);
		List<Sporris> q = query.getResultList();
		return q;
	}
	
	/**
	 * 
	 * @return new free id
	 */
	public int getNewId () {
		return (Integer)em.createQuery("select max(s.sid) from Sporris s").getSingleResult() + 1;
	}
	
	/*
	 * Skal det være sid eller uid? Hvis det er feil så er det fordi det skal stå uid. 
	 */
	public Sporris findSporris(int sid) {
		return em.find(Sporris.class, sid);
	}
	
	public void updateUser(Sporris s) {
		em.merge(s);
	}
	
	/*
	 * Samme potensielt idissue her. sid vs uid
	 */
	public void removeUser(int sid) {
		em.remove(em.find(User.class, sid));
	}
	
}