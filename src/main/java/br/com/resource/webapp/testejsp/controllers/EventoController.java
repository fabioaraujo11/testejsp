package br.com.resource.webapp.testejsp.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.resource.webapp.testejsp.models.Convidado;
import br.com.resource.webapp.testejsp.models.Evento;
import br.com.resource.webapp.testejsp.models.Usuario;
import br.com.resource.webapp.testejsp.repository.ConvidadoRepository;
import br.com.resource.webapp.testejsp.repository.EventoRepository;
import br.com.resource.webapp.testejsp.repository.UsuarioRepository;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository er;

	@Autowired
	private ConvidadoRepository cr;

	@Autowired
	private UsuarioRepository ur;

	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/public/img";

	@GetMapping(value = "/cadastrarEvento")
	public ModelAndView form(Principal principal) {

		ModelAndView mv = new ModelAndView("evento/formEvento");
		Usuario user = ur.findByusername(principal.getName());
		mv.addObject("user", user.getNomeCompleto());
		return mv;
	}

	@PostMapping(value = "/cadastrarEvento")
	public String form(@Valid Evento evento, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos corretamente");
			return "redirect:/cadastrarEvento";
		}

		er.save(evento);
		attributes.addFlashAttribute("mensagem", "Gravado com sucesso");
		return "redirect:/cadastrarEvento";
	}

	@GetMapping(value = "/eventos")
	public ModelAndView listaEvento(Principal principal) {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("eventos", eventos);
		Usuario user = ur.findByusername(principal.getName());
		mv.addObject("user", user.getNomeCompleto());
		return mv;
	}

	@GetMapping(value = "/{idEvento}")
	public ModelAndView detalhesEvento(@PathVariable("idEvento") int idEvento, Principal principal) {
		Evento evento = er.findByidEvento(idEvento);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		mv.addObject("evento", evento);
		Usuario user = ur.findByusername(principal.getName());
		mv.addObject("user", user.getNomeCompleto());
		Iterable<Convidado> convidados = cr.findByEvento(evento);
		mv.addObject("convidados", convidados);

		return mv;
	}

	@PostMapping(value = "/{idEvento}")
	public String detalhesEventoPost(@PathVariable("idEvento") int idEvento, @RequestParam("files") MultipartFile img,
			@Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos corretamente");
			return "redirect:/{idEvento}";
		}

		Evento evento = er.findByidEvento(idEvento);

		String formato[] = img.getContentType().split("/");
		Path fileNameAndPath = Paths.get(uploadDirectory, convidado.getRg() + "." + formato[1]);

		try {
			Files.write(fileNameAndPath, img.getBytes());

			convidado.setNameImgPerfil(convidado.getRg() + "." + formato[1]);
			convidado.setPathImgPerfil("/public/img/");

		} catch (IOException e) {
			e.printStackTrace();
		}

		convidado.setEvento(evento);
		cr.save(convidado);
		attributes.addFlashAttribute("mensagem", "Gravado com sucesso");
		return "redirect:/{idEvento}";
	}

	@GetMapping(value = "/deletarEvento/{idEvento}")
	public String deletarEvento(@PathVariable("idEvento") int idEvento) {
		Evento evento = er.findByidEvento(idEvento);

		er.delete(evento);

		return "redirect:/eventos";
	}

	@GetMapping(value = "/deletarConvidado/{rg}")
	public String deletarConvidado(@PathVariable("rg") String rg) {
		Convidado convidado = cr.findByRg(rg);

		Path pathToBeDeleted = Paths.get(uploadDirectory, convidado.getNameImgPerfil());

		try {
			Files.delete(pathToBeDeleted);
		} catch (IOException e) {
			e.printStackTrace();
		}

		cr.delete(convidado);

		Evento evento = convidado.getEvento();
		int idEventoINT = evento.getIdEvento();
		String codigo = "" + idEventoINT;

		return "redirect:/" + codigo;
	}

}
