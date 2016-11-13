package no.hib.dat104.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "sporris_database", name = "alternative")
public class Alternative {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int aid;
	private String alternative_text;
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "alternative_question", referencedColumnName = "qid")
	private Question alternative_question;

	public Alternative() {
		
	}
	public Alternative(String alternativeText, Question question) {
		alternative_text = alternativeText;
		alternative_question = question;
	}

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

	public Question getAlternative_question() {
		return alternative_question;
	}

	public void setAlternative_question(Question alternative_question) {
		this.alternative_question = alternative_question;

	}
	
	/**
	 * checks if content equals
	 * @param a
	 * @return
	 */
	public boolean contentEquals(Alternative a) {
		boolean eq;
		eq = alternative_text.equals(a.getAlternative_text());
		return eq;
	}

//	@Override
//	public boolean equals(Object obj) {
//		boolean eq = true;
//		if (!(obj instanceof Alternative)) eq = false;
//		else {
//			Alternative q = (Alternative) obj;
//			if (aid != q.getAid()) eq = false;
//		}
//		return eq;
//	}
}