package no.hib.dat104.project.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "sporris_database", name = "result")
public class Result {
	
	@Id
	private int rid;
	private String result_name;
	@ManyToOne
	@JoinColumn(name="result_sporris", referencedColumnName="sid")
	private int result_sporris;
	
	@OneToMany(mappedBy = "response_result")
	private List<Response> responses;
	
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
	public int getResult_sporris() {
		return result_sporris;
	}
	public void setResult_sporris(int result_sporris) {
		this.result_sporris = result_sporris;
	}
	
	

}
