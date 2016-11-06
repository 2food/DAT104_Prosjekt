package no.hib.dat104.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class SporrisEAO {

	
	@PersistenceContext(name = "s_test")
	private EntityManager em;


	
	public void addSporris(Sporris s) {
		em.persist(s);
	}

	public List<Sporris> allSporris() {
		TypedQuery<Sporris> query = em.createQuery("SELECT s FROM Sporris s", Sporris.class);
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
	
	
	public Sporris findSporris(int sid) {
		return em.find(Sporris.class, sid);
	}
	
	public void updateSporris(Sporris s) {
		em.merge(s);
	}
	
	
	/*
	 * Aktiverer en spørris
	 * @Param spørrisId
	 */
	public void activateSporris(int sid){
		findSporris(sid).setActive(true);
		updateSporris(findSporris(sid));
	}
	
	
	public void removeSporris(int sid) {
		em.remove(em.find(User.class, sid));
	}
	/*
	 * metode som s�ker etter en sporris med tag som parameter og returnerer sporris med riktig tag eller null
	 * @param sporristag
	 * @return sporris
	 */
	public Sporris findSporrisByTag(String tag){
		List<Sporris> allSporrisis = allSporris();
		Sporris returnSporris = new Sporris();
		for(Sporris sporris : allSporrisis){
			if(!tag.equals(sporris.getSporris_tag())){
				return null;
			}else{
				returnSporris = sporris;
			}
		}
		return returnSporris;
			
	}
	
}