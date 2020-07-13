package es.dto;

import java.io.Serializable;
import java.util.Date;

public class DtoBuscarProyecto implements Serializable{
	private Integer proyectoId;
	private String codigo;
	private String descripcion;
	private Date fecha;
	private Double coste;
	public DtoBuscarProyecto() {
		// TODO Auto-generated constructor stub
	}
	
	public DtoBuscarProyecto(String codigo) {
		this.codigo=codigo;
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getProyectoId() {
		return proyectoId;
	}

	public void setProyectoId(Integer proyectoId) {
		this.proyectoId = proyectoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getCoste() {
		return coste;
	}

	public void setCoste(Double coste) {
		this.coste = coste;
	}

	
	
	

}
