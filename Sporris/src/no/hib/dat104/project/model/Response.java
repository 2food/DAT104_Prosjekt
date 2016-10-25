package no.hib.dat104.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "sporris_database", name = "response")
public class Response {

	@Id
	private int response_id;
	private String response_text;
	@ManyToOne
	@JoinColumn(name = "response_result", referencedColumnName = "rid")
	private Result response_result;

	public int getResponse_id() {
		return response_id;
	}

	public void setResponse_id(int response_id) {
		this.response_id = response_id;
	}

	public String getResponse_text() {
		return response_text;
	}

	public void setRespnse_text(String response_text) {
		this.response_text = response_text;
	}

	public Result getResponse_result() {
		return response_result;
	}

	public void setResponse_result(Result response_result) {
		this.response_result = response_result;
	}

}
