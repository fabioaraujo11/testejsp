package br.com.resource.webapp.testejsp.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.resource.webapp.testejsp.models.Usuario;
import br.com.resource.webapp.testejsp.repository.UsuarioRepository;

@Controller
public class IndexController {

	@Autowired
	private UsuarioRepository ur;

	@RequestMapping("/")
	public ModelAndView index(Principal principal) {
		ModelAndView mv = new ModelAndView("eventos");
		Usuario user = ur.findByusername(principal.getName());
		mv.addObject("user", user.getNomeCompleto());
		return mv;
	}

}
