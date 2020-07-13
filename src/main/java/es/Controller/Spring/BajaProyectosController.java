package es.Controller.Spring;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.negocio.IGestionProyectos;

@Controller
@RequestMapping("/bajaProyecto")
public class BajaProyectosController extends LogeadoController {
	@Autowired
	private IGestionProyectos itfzgp;

	@RequestMapping(method = RequestMethod.GET)
	public String PrepararFormulario(
			@RequestParam(value = "id", required = true) Integer id,
			HttpSession sesion, Model modelo) {
		if (sesion.getAttribute("spring_user") == null) {
			return "redirect:/";
		}

		itfzgp.bajaProyecto(id);
		return "redirect:listaProyecto?code=2";
	}
}
