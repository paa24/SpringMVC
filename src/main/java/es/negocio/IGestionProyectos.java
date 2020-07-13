package es.negocio;

import java.util.List;

import es.modelo.Proyecto;
import es.modelo.Usuario;

public interface IGestionProyectos {
	public boolean AltaProyectos(Proyecto proyecto);

	public List<Proyecto> ListaProyectos();

	public boolean bajaProyecto(int id);

	public List<Proyecto> consultarProyecto(String codigo);

	public Usuario loadUserByUsername(String usuario);

	public Proyecto consultarId(Integer id);

	public void editarProyectos(Integer id, Proyecto proyecto);
	
	public Proyecto obtenerProyectoByCode(String codigo);
}
