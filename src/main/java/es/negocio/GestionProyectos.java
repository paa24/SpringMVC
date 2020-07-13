package es.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.modelo.Proyecto;
import es.modelo.Usuario;
import es.persistencia.IProyectosDAO;
@Component
public class GestionProyectos implements IGestionProyectos {
@Autowired
	private IProyectosDAO dao;
	@Override
	public boolean AltaProyectos(Proyecto proyecto) {
		return dao.AltaProyectos(proyecto);
		
	}
	@Override
	public List<Proyecto> ListaProyectos() {
		return dao.ListaProyectos();
	}
	@Override
	public boolean bajaProyecto(int id) {
		
		return dao.bajaProyecto(id);
	}
	public List<Proyecto> consultarProyecto(String codigo){
		
		return dao.consultarProyecto(codigo);
	}
	
	public Usuario loadUserByUsername(String usuario){
		return dao.loadUserByUsername(usuario);
	}
	public Proyecto consultarId(Integer id){
		return dao.consultarId(id);
	}
	
	public void editarProyectos(Integer id,Proyecto proyecto){
		 dao.editarProyectos(id,proyecto);
	}
	
	public Proyecto obtenerProyectoByCode(String codigo){
		return dao.obtenerProyectoByCode(codigo);
	}
}
