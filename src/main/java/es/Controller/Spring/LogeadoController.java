package es.Controller.Spring;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import es.modelo.Usuario;

@Controller
public class LogeadoController {

	@ModelAttribute(value="spring_user")
	public Usuario PrepararFormulario(HttpSession sesion) {
		Object obj = sesion.getAttribute("spring_user");
		if(obj instanceof Usuario){
			return (Usuario)obj;
		}else{
			return null;
		}
		
	}

}
