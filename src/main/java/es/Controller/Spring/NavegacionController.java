package es.Controller.Spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class NavegacionController {
	@RequestMapping( method=RequestMethod.GET, value=("/retornoGestion"))
 public String reenviar(Model modelo){
		
		return "gestionUsuario";
	}
	
}
