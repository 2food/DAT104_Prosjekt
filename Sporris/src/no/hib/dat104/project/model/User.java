package no.hib.dat104.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "sporris_database", name = "s_user")
public class User {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int uid;
	private String user_name;
	private String user_password;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "sporris_user", cascade = CascadeType.ALL)
	private List<Sporris> sporrises;
	
	
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
