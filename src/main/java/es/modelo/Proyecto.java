package es.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Parent;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BCJ_Proyecto")
public class Proyecto implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="proyecto_id")	
	private Integer proyectoId;
	
	@Size(min=1,max=25,message="debe contener entre 1 y 25 caracteres")
	@Column(name = "codigo",unique=true)
	private String codigo;
	
	@Size(min=1,max=25,message="debe contener entre 1 y 25 caracteres")
	@Column(name = "descripcion")
	private String descripcion;
	
	
	@DateTimeFormat(pattern="dd/MM/yyyy")	
	@NotNull(message="formato incorrecto")
	@Column(name = "fecha")
	private Date fecha;
	
	
	@Column(name = "coste")
	@NotNull(message="No puede ser nulo")
	@Digits(integer=10,fraction=2,message="formato incorrecto")  
	private Double coste;
	
	@ElementCollection
	@CollectionTable(name="BCJ_Tareas", joinColumns=@JoinColumn(name="proyecto_id"))
	@Column(name="nombreTarea")
	private Set<String> tareas;
		
	@ManyToOne(targetEntity=Usuario.class)	
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Proyecto() {
		// TODO Auto-generated constructor stub
	}

	public Proyecto(Integer proyectoId,String codigo, String descripcion, Date fecha,
			Double coste) {
		this.proyectoId=proyectoId;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.coste = coste;
		

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public Integer getProyectoId() {
		return proyectoId;
	}

	public void setProyectoId(Integer proyectoId) {
		this.proyectoId = proyectoId;
	}

	public Set<String> getTareas() {
		return tareas;
	}

	public void setTareas(Set<String> tareas) {
		this.tareas = tareas;
	}

	
	
	

}
