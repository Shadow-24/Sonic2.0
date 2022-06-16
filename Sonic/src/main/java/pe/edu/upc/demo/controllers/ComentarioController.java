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

import pe.edu.upc.demo.entities.Comentario;
import pe.edu.upc.demo.serviceinterfaces.IComentarioService;
import pe.edu.upc.demo.serviceinterfaces.IPublicacionService;
import pe.edu.upc.demo.serviceinterfaces.IUsuarioService;

@Controller
@RequestMapping("ccomentarios")
public class ComentarioController {

	@Autowired
	private IComentarioService comentaService;

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private IPublicacionService publiService;

	@GetMapping("/new")
	public String newComentario(Model model) {

		model.addAttribute("co", new Comentario());
		model.addAttribute("listaUsuarios", usuarioService.list());
		model.addAttribute("listaPublicaciones", publiService.list());
		return "/comentario/frmRegistro";
	}

	@PostMapping("/save")
	public String saveComentario(@Valid Comentario comentario, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			return "comentario/frmRegistro";
		} else {
			comentaService.insert(comentario);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/ccomentarios/new";
		}
	}

	@GetMapping("list")
	public String listComentario(Model model) {

		try {
			model.addAttribute("listaComentarios", comentaService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/comentario/frmLista";
	}

	@GetMapping("/delete")
	public String deleteComentario(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {
				comentaService.delete(id);
				model.put("listaComentarios", comentaService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}

		return "comentario/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateComentario(@PathVariable int id, Model model) {

		Optional<Comentario> objComenta = comentaService.listId(id);
		model.addAttribute("coment", objComenta.get());

		return "comentario/frmActualiza";
	}

	@PostMapping("/update")
	public String updateComentario(Comentario comentario) {
		comentaService.update(comentario);
		return "redirect:/ccomentarios/list";
	}
}
