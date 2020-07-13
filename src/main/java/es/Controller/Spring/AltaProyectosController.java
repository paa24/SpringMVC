package es.Controller.Spring;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.modelo.Proyecto;
import es.modelo.Usuario;
import es.negocio.IGestionProyectos;

@Controller
@RequestMapping("/altaProyecto")
public class AltaProyectosController extends LogeadoController {
	@Autowired
	private IGestionProyectos itfzgp;

	@RequestMapping(method = RequestMethod.GET)
	public String PrepararFormulario(HttpSession sesion, Model modelo) {
		
		if (sesion.getAttribute("spring_user") == null) {
			
			
			return "redirect:/";
		}
//		Object obj = sesion.getAttribute("spring_user");
//		modelo.addAttribute("spring_user", obj);
		modelo.addAttribute("proyecto", new Proyecto());
		return "formAltaProyecto";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String ProcesarFormulario(HttpSession sesion,
			@Valid Proyecto proyecto, BindingResult resultado, Model modelo) {

		Usuario userSesion = (Usuario) sesion.getAttribute("spring_user");
		if (userSesion == null) {
			return "redirect:/";
		} else {
			proyecto.setUsuario(userSesion);
		}

		if (proyecto.getFecha() == null) {
			resultado.rejectValue("fecha", null, "Fecha obligatoria");
		}
		
		if (resultado.hasErrors()){
			return "formAltaProyecto";
			
		}
			if (itfzgp.obtenerProyectoByCode(proyecto.getCodigo())!=null) {
			
			modelo.addAttribute("proyecto", proyecto);
			modelo.addAttribute("msgCodigoDuplicado",
					"Ya existe un proyecto con el mismo código");
			return "formAltaProyecto";
		} else {

			itfzgp.AltaProyectos(proyecto);

			modelo.addAttribute("msg", "Se ha realizado el Alta Correctamente");
			modelo.addAttribute("vistaVuelta", "/altaProyecto");			
			return "resultadoAlta";

		}

	}
}
