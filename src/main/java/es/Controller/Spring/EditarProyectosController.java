package es.Controller.Spring;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.modelo.Proyecto;
import es.modelo.Usuario;
import es.negocio.IGestionProyectos;

@Controller
@RequestMapping("/editProyecto")
public class EditarProyectosController extends LogeadoController {
	@Autowired
	private IGestionProyectos itfzgp;

	@RequestMapping(method = RequestMethod.GET)
	public String PrepararFormulario(HttpSession sesion, Model modelo,
			@RequestParam(value = "id", required = true) Integer id) {
		if (sesion.getAttribute("spring_user") == null) {
			return "redirect:/";
		}
	
		modelo.addAttribute("proyecto", itfzgp.consultarId(id));
		return "formEditarProyecto";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String ProcesarFormulario(HttpSession sesion,@Valid Proyecto proyecto,
			BindingResult resultado, Model modelo,
			@RequestParam(value = "id", required = true) Integer id) {


		Usuario userSesion = (Usuario) sesion.getAttribute("spring_user");
		if (userSesion == null) {
			return "redirect:/";
		} else {
			proyecto.setUsuario(userSesion);
		}

		if (proyecto.getFecha() == null) {
			resultado.rejectValue("fecha", null, "Fecha obligatória");
		}
		
	
//		Proyecto proyectoEnBD = itfzgp.obtenerProyectoByCode(proyecto.getCodigo());		
//		boolean codigoRepetido = proyectoEnBD!= null && proyectoEnBD.getProyectoId() !=id;
				
//		if (resultado.hasErrors()|| codigoRepetido) {
		
		if (resultado.hasErrors()){
			modelo.addAttribute("proyecto", proyecto);
//			resultado.rejectValue("codigo",null,"ya existe un proyecto con el mismo código");
			return "formEditarProyecto";
		} else {
			itfzgp.editarProyectos(id,proyecto);
			return "redirect:listaProyecto?code=1";
		}

	}
}
