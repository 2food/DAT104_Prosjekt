package no.hib.dat104.project.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "sporris_database", name = "user")
public class User {
	
	@Id
	private int uid;
	private String user_name;
	private String user_password;
	
	@OneToMany(mappedBy = "s_user")
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
