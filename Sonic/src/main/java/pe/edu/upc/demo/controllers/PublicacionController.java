package pe.edu.upc.demo.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.Publicacion;
import pe.edu.upc.demo.serviceinterfaces.IPublicacionService;
import pe.edu.upc.demo.serviceinterfaces.IUsuarioService;

@Controller
@RequestMapping("/ppublicaciones")
@Secured({ "ROLE_MUSICO", "ROLE_DUEÑO" })
public class PublicacionController {

	@Autowired
	private IPublicacionService publiService;

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/new")
	public String newMusico(Model model) {

		model.addAttribute("pu", new Publicacion());
		model.addAttribute("listaUsuarios", usuarioService.list());
		return "/publicacion/frmRegistro";
	}

	@PostMapping("/save")
	public String savePublicacion(@Valid Publicacion publi, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			return "publicacion/frmRegistro";
		} else {
			publiService.insert(publi);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/ppublicaciones/new";
		}
	}

	@GetMapping("/list")
	public String listPublicacion(Model model) {

		try {
			model.addAttribute("listaPublicaciones", publiService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "publicacion/frmLista";
	}

	@RequestMapping("/delete")
	public String deletePublicacion(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0)
				publiService.delete(id);
			model.put("listaPublicaciones", publiService.list());
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}

		return "publicacion/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdatePublicacion(@PathVariable int id, Model model) {
		Optional<Publicacion> objPubli = publiService.listId(id);
		model.addAttribute("publica", objPubli.get());

		return "publicacion/frmActualiza";
	}

	@PostMapping("/list")
	public String updatePublicacion(Publicacion publicacion) {
		publiService.update(publicacion);
		return "redirect:/ppublicaciones/list";
	}
}
