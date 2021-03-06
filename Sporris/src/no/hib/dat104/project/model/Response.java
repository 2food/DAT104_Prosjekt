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
@Table(schema = "sporris_database", name = "response")
public class Response {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int response_id;
	private String response_text;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "response_result", referencedColumnName = "rid")
	private Result response_result;

	public Response() {
		
	}
	
	public Response(String responseText, Result result) {
		response_text = responseText;
		response_result = result;
	}

	public int getResponse_id() {
		return response_id;
	}

	public void setResponse_id(int response_id) {
		this.response_id = response_id;
	}

	public String getResponse_text() {
		return response_text;
	}

	public void setResponse_text(String response_text) {
		this.response_text = response_text;
	}

	public Result getResponse_result() {
		return response_result;
	}

	public void setResponse_result(Result response_result) {
		this.response_result = response_result;
	}

}
