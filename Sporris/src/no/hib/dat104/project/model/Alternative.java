package no.hib.dat104.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "sporris_database", name = "alternative")
public class Alternative {

	@Id
	private int aid;
	private String alternative_text;
	@ManyToOne
	@JoinColumn(name = "alternative_question", referencedColumnName = "qid")
	private int alternative_question;

	public int getAid() {
		return aid;
	}
 
	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAlternative_text() {
		return alternative_text;
	}

	public void setAlternative_text(String alternative_text) {
		this.alternative_text = alternative_text;
	}

	public int getAlternative_question() {
		return alternative_question;
	}

	public void setAlternative_question(int alternative_question) {
		this.alternative_question = alternative_question;

	}
}