package es.persistencia;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import es.modelo.Proyecto;
import es.modelo.Usuario;

@Component
public class ProyectosDAO implements IProyectosDAO, UserDetailsService {
	@Autowired
	private SessionFactory sf;

	public ProyectosDAO() {
		// TODO Auto-generated constructor stub
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean AltaProyectos(Proyecto proyecto) {
		try {
			sf.getCurrentSession().save(proyecto);
			return true;

		} catch (Exception e) {
			return false;
		}
		// TODO Auto-generated method stub
		// sf.getCurrentSession().save(proyecto);
		// return false;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<Proyecto> ListaProyectos() {
		return sf.getCurrentSession().createQuery("from Proyecto").list();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean bajaProyecto(int id) {

		Query query = sf.getCurrentSession().createQuery(
				"from Proyecto p where p.id=:id");
		query.setParameter("id", id);
		Proyecto proyecto = (Proyecto) query.uniqueResult();

		sf.getCurrentSession().delete(proyecto);

		return true;

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<Proyecto> consultarProyecto(String codigo) {

		Query query = sf.getCurrentSession().createQuery(
				"from Proyecto p where p.codigo like :codigo");
		query.setParameter("codigo", "%" + codigo + "%");
		List<Proyecto> proyecto = (List) query.list();
		return proyecto;

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Proyecto obtenerProyectoByCode(String codigo) {

		Query query = sf.getCurrentSession().createQuery(
				"from Proyecto p where p.codigo = :codigo");
		query.setParameter("codigo", codigo);
		return (Proyecto) query.uniqueResult();

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Proyecto consultarId(Integer id) {

		Query query = sf.getCurrentSession().createQuery(
				"from Proyecto p where p.id=:id");
		query.setParameter("id", id);
		Proyecto proyecto = (Proyecto) query.uniqueResult();

		Hibernate.initialize(proyecto.getTareas());

		return proyecto;

	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Usuario loadUserByUsername(String nombre)
			throws UsernameNotFoundException {
		return (Usuario) sf.getCurrentSession()
				.createQuery("from Usuario where usuario='" + nombre + "'")
				.uniqueResult();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void editarProyectos(Integer id, Proyecto proyecto) {
		Proyecto proyecEditado = consultarId(id);

		proyecEditado.setFecha(proyecto.getFecha());
		proyecEditado.setUsuario(proyecto.getUsuario());
		proyecEditado.setTareas(proyecto.getTareas());
		proyecEditado.setDescripcion(proyecto.getDescripcion());
		proyecEditado.setCodigo(proyecto.getCodigo());
		proyecEditado.setCoste(proyecto.getCoste());

		sf.getCurrentSession().update(proyecEditado);
	}

}
