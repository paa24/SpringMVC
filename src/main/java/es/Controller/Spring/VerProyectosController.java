package es.Controller.Spring;

import javax.servlet.http.HttpSession;

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
@RequestMapping("/verProyecto")
public class VerProyectosController extends LogeadoController {
	@Autowired
	private IGestionProyectos itfzgp;

	@RequestMapping(method = RequestMethod.GET)
	public String PrepararFormulario(HttpSession sesion, Model modelo,
			@RequestParam(value = "id", required = true) Integer id) {
		if (sesion.getAttribute("spring_user") == null) {
			return "redirect:/";
		}
		
//		modelo.addAttribute("modovista", true);
		modelo.addAttribute("proyecto", itfzgp.consultarId(id));
		return "formBuscarProyecto";
	}

}
