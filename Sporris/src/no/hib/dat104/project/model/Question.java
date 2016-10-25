package no.hib.dat104.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "sporris_database", name = "question")
public class Question {

	@Id
	private int qid;
	private String question_text;
	@ManyToOne()
	@JoinColumn(name="question_sporris", referencedColumnName = "sid")
	private int question_sporris;
	private boolean allow_multiple;
	private boolean allow_text;
	
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestion_text() {
		return question_text;
	}
	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
	}
	public int getQuestion_sporris() {
		return question_sporris;
	}
	public void setQuestion_sporris(int question_sporris) {
		this.question_sporris = question_sporris;
	}
	public boolean isAllow_multiple() {
		return allow_multiple;
	}
	public void setAllow_multiple(boolean allow_multiple) {
		this.allow_multiple = allow_multiple;
	}
	public boolean isAllow_text() {
		return allow_text;
	}
	public void setAllow_text(boolean allow_text) {
		this.allow_text = allow_text;
	}
	
	
	

}
