package no.hib.dat104.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(schema = "sporris_database", name = "sporris")
public class Sporris implements Serializable{
	private static final long serialVersionUID = 5356895219389998211L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int sid;
	private String sporris_name;
	private String sporris_tag;
	private boolean active;
	
	@ManyToOne
    @JoinColumn(name="sporris_user", referencedColumnName = "uid")
    private User sporris_user;

	@OneToMany(mappedBy = "question_sporris", cascade = CascadeType.ALL)
	private List<Question> questions;
	
	@OneToMany(mappedBy = "result_sporris", cascade = CascadeType.ALL)
	private List<Result> results;
	
	public Sporris() {
		
	}
	
	/**
	 * sets all NOT NULL values to some defaults
	 */
	public Sporris(User owner) {
		sporris_name = "Ny Sp�rris";
		sporris_tag = "qwe123";
		sporris_user = owner;
		active = true;
		questions = new ArrayList<Question>();
		results = new ArrayList<Result>();
		
	}
	
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
	public User getSporris_user() {
		return sporris_user;
	}
	public void setSporris_user(User sporris_user) {
		this.sporris_user = sporris_user;
	}
	
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	
	
	public boolean contains(Question q) {
		boolean c = false;
		for (Question q1 : questions) {
			if (q1.contentEquals(q)) {
				c = true;
				break;
			}
		}
		return c;
	}
	
}