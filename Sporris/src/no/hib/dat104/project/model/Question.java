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
@Table(schema = "sporris_database", name = "question")
public class Question implements Comparable<Question>, Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int qid;
	private String question_text;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="question_sporris", referencedColumnName = "sid")
	private Sporris question_sporris;
	private boolean allow_multiple;
	private boolean allow_text;
	
	private int list_index;
	
	@OneToMany(mappedBy = "alternative_question", cascade = CascadeType.ALL)
	private List<Alternative> alternatives;
	
	public Question() {
		
	}
	
	/**
	 * constructor
	 * @param questionText
	 * @param allowText
	 * @param allowMultiple
	 * @param sporris
	 */
	public Question(String questionText, boolean allowText, boolean allowMultiple, Sporris sporris) {
		question_text = questionText;
		allow_text = allowText;
		allow_multiple = allowMultiple;
		question_sporris = sporris;
		alternatives = new ArrayList<Alternative>();
		list_index = sporris.nextListIndex();
	}
	
	/**
	 * add Alternative a to the question
	 * @param a
	 */
	public void addAlternative(Alternative a) {
		if (alternatives == null) {
			alternatives = new ArrayList<Alternative>();
		}
		alternatives.add(a);
	}
	
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
	public Sporris getQuestion_sporris() {
		return question_sporris;
	}
	public void setQuestion_sporris(Sporris question_sporris) {
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
	public List<Alternative> getAlternatives() {
		return alternatives;
	}
	public void setAlternatives(List<Alternative> alternatives) {
		this.alternatives = alternatives;
	}
	
	public int getList_index() {
		return list_index;
	}

	public void setList_index(int list_index) {
		this.list_index = list_index;
	}

	/**
	 * checks if content equals
	 * @param q
	 * @return
	 */
	public boolean contentEquals(Question q) {
		boolean eq = true;
		if (!question_text.equals(q.getQuestion_text())) {
			eq = false;
		} else if (alternatives.size() != q.getAlternatives().size()) {
			eq = false;
		} else if (allow_text != q.isAllow_text()) {
			eq = false;
		} else if (allow_multiple != q.isAllow_multiple()) {
			eq = false;
		} else {
			for (int i = 0; i < alternatives.size(); i++) {
				if (!alternatives.get(i).contentEquals(q.getAlternatives().get(i))) {
					eq = false;
					break;
				}
			}
		}
		return eq;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		boolean eq = true;
//		if (!(obj instanceof Question)) eq = false;
//		else {
//			Question q = (Question) obj;
//			if (qid != q.getQid()) eq = false;
//		}
//		return eq;
//	}

	@Override
	public String toString() {
		String s = question_text;
		if (allow_text) s += "_text";
		if (allow_multiple) s += "_multiple";	
		for (Alternative a : alternatives) {
			s += "_" + a.getAlternative_text();
		}		
		return s;
	}
	
	@Override
	public int compareTo(Question q) {
		return list_index - q.getList_index();
	}
	

}
