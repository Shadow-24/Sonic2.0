package pe.edu.upc.demo.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.Musico;
import pe.edu.upc.demo.serviceinterfaces.IMusicoService;
import pe.edu.upc.demo.serviceinterfaces.IUsuarioService;

@Controller
@RequestMapping("/mmusicos")
public class MusicoController {

	@Autowired
	private IMusicoService musicoService;

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/new")
	public String newMusico(Model model) {

		model.addAttribute("mu", new Musico());
		model.addAttribute("listaUsuarios", usuarioService.list());
		return "/musico/frmRegistro";
	}

	@PostMapping("/save")
	public String saveMusico(@Valid Musico musico, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			return "musico/frmRegistro";
		} else {
			musicoService.insert(musico);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/mmusicos/new";
		}
	}

	@GetMapping("/list")
	public String listMusico(Model model) {

		try {
			model.addAttribute("listaMusicos", musicoService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/musico/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteMusico(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {
				musicoService.delete(id);
				model.put("listaMusicos", musicoService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}

		return "musico/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateMusico(@PathVariable int id, Model model) {

		Optional<Musico> objMusico = musicoService.listId(id);
		model.addAttribute("music", objMusico.get());

		return "musico/frmActualiza";
	}

	@PostMapping("/update")
	public String updateMusico(Musico musico) {

		musicoService.update(musico);
		return "redirect:/mmusicos/list";
	}

}
