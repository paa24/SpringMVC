package es.Controller.Spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.dto.DtoLogin;
import es.modelo.Usuario;
import es.negocio.IGestionProyectos;

@Controller
@RequestMapping("/login")
public class loginController {

	@Autowired
	private IGestionProyectos itfzgp;

	@RequestMapping(method = RequestMethod.POST)
	public String procesarUsuario(HttpSession sesion, Model modelo,
			@ModelAttribute(value = "usuario") DtoLogin usuarioLogin) {
		Usuario user = itfzgp.loadUserByUsername(usuarioLogin.getUsuario());

		if (user != null
				&& user.getPassword().equals(usuarioLogin.getPassword())) {
			sesion.setAttribute("spring_user", user);
			return "gestionUsuario";
		} else {
			modelo.addAttribute("error", "Usuario Incorrecto");
			return "index";
		}

	}

}
