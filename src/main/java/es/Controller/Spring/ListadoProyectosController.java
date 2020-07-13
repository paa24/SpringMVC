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
@RequestMapping("/listaProyecto")
public class ListadoProyectosController extends LogeadoController {
	@Autowired
	private IGestionProyectos itfzgp;

	@RequestMapping(method = RequestMethod.GET)
	public String PrepararFormulario(HttpSession sesion, Model modelo,@RequestParam(value="code",required=false)Integer code) {
		if (sesion.getAttribute("spring_user") == null) {
			return "redirect:/";
		}
		
		if(code!= null){
			switch (code) {
			case 1:
				modelo.addAttribute("mensajeok", "Se ha realizado la modificación Correctamente");
				break;
			case 2:
				modelo.addAttribute("mensajeok", "Se ha realizado la baja Correctamente");
				break;
			default:
				break;
			}
		}

		modelo.addAttribute("listProyectos", itfzgp.ListaProyectos());
		return "listaProyecto";
	}
}
