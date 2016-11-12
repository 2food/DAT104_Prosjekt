package no.hib.dat104.project.model;

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
@Table(schema = "sporris_database", name = "result")
public class Result {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int rid;
	private String result_name;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="result_sporris", referencedColumnName="sid")
	private Sporris result_sporris;
	
	@OneToMany(mappedBy = "response_result", cascade = CascadeType.ALL)
	private List<Response> responses;
	
	public Result() {
		
	}
	
	public Result(Sporris s) {
		result_sporris = s;
		responses = new ArrayList<Response>();
		result_name = "Aktiv";		
	}
	
	public void addResponse(Response r) {
		r.setResponse_result(this);
		responses.add(r);
	}
	
	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getResult_name() {
		return result_name;
	}
	public void setResult_name(String result_name) {
		this.result_name = result_name;
	}
	public Sporris getResult_sporris() {
		return result_sporris;
	}
	public void setResult_sporris(Sporris result_sporris) {
		this.result_sporris = result_sporris;
	}
	
	

}
