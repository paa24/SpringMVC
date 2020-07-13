package es.dto;

import java.io.Serializable;

public class DtoProyecto implements Serializable{
	private Integer id;
	
	public DtoProyecto() {
		// TODO Auto-generated constructor stub
	}
	
	public DtoProyecto(Integer id) {
		this.id=id;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
