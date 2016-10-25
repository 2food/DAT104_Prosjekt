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
	private int respnonse_id;
	private String respnse_text;
	@ManyToOne
	@JoinColumn(name = "response_result", referencedColumnName = "rid")
	private int response_result;

	public int getRespnonse_id() {
		return respnonse_id;
	}

	public void setRespnonse_id(int respnonse_id) {
		this.respnonse_id = respnonse_id;
	}

	public String getRespnse_text() {
		return respnse_text;
	}

	public void setRespnse_text(String respnse_text) {
		this.respnse_text = respnse_text;
	}

	public int getResponse_result() {
		return response_result;
	}

	public void setResponse_result(int response_result) {
		this.response_result = response_result;
	}

}
