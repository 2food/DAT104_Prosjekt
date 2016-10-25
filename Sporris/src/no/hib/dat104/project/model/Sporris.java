package no.hib.dat104.project.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "sporris_database", name = "sporris")
public class Sporris {
	
	@Id
	private int sid;
	private String sporris_name;
	private String sporris_tag;
	private boolean active;
	
	@ManyToOne
    @JoinColumn(name="sporris_user", referencedColumnName = "uid")
    private User sporris_user;

	@OneToMany(mappedBy = "question_sporris")
	private List<Question> questions;
	
	@OneToMany(mappedBy = "result_sporris")
	private List<Result> results;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSporris_name() {
		return sporris_name;
	}
	public void setSporris_name(String sporris_name) {
		this.sporris_name = sporris_name;
	}
	public String getSporris_tag() {
		return sporris_tag;
	}
	public void setSporris_tag(String sporris_tag) {
		this.sporris_tag = sporris_tag;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}