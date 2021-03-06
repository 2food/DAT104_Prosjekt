package no.hib.dat104.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "sporris_database", name = "s_user")
public class User implements Serializable{
	private static final long serialVersionUID = 4838363778999817912L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int uid;
	private String user_name;
	private String user_password;
	
	@OneToMany(mappedBy = "sporris_user", cascade = CascadeType.ALL)
	private List<Sporris> sporrises;
	
	public User () {
		
	}
	/**
	 * constructor
	 * @param user_name
	 * @param user_password
	 * @author Torstein
	 */
	public User(String user_name, String user_password) {
		this.user_name = user_name;
		this.user_password = user_password;
		sporrises = new ArrayList<Sporris>();
	}
	/**
	 * add sporris to the user
	 * @param sporris
	 */
	public void addSporris(Sporris sporris) {
		if (sporrises == null) {
			sporrises = new ArrayList<Sporris>();
		}
		sporris.setSporris_user(this);
		sporrises.add(sporris);
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUser_name() {
		return user_name;
	}
	/**
	 * returns a users sporris by id
	 * @param sid
	 * @return sporris
	 * @author Torstein
	 */
	public Sporris getSporris(int sid) {
		Sporris s = null;
		for (Sporris i : sporrises) {
			if (i.getSid() == sid) {
				s = i;
				break;
			}
		}
		return s;
	}
	public List<Sporris> getSporrises() {
		return sporrises;
	}
	public void setSporrises(List<Sporris> sporrises) {
		this.sporrises = sporrises;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

}
