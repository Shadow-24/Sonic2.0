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

import pe.edu.upc.demo.entities.Tipo_Usuario;
import pe.edu.upc.demo.serviceinterfaces.ITipoUsuarioService;

@Controller
@RequestMapping("/ttipousuarios")
public class TipoUsuarioController {

	@Autowired
	private ITipoUsuarioService tuserService;

	@GetMapping("/new")
	public String newTipoUsuario(Model model) {
		model.addAttribute("c", new Tipo_Usuario());
		return "tusuario/frmRegistro";
	}

	@PostMapping("/save")
	public String saveTipoUsuario(@Valid Tipo_Usuario tuser, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "tusuario/frmRegistro";
		} else {
			tuserService.insert(tuser);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/ttipousuarios/new";
		}
	}

	@GetMapping("/list")
	public String listTipoUsuario(Model model) {

		try {
			model.addAttribute("listatipousuarios", tuserService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "tusuario/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteTipoUsuario(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {
				tuserService.delete(id);
				model.put("listatipousuarios", tuserService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "redirect:/ttipousuarios/list";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateTipoUsuario(@PathVariable int id, Model model) {
		Optional<Tipo_Usuario> objtu = tuserService.listId(id);
		model.addAttribute("tu", objtu.get());
		return "tusuario/frmActualiza";
	}

	@PostMapping("/update")
	public String update(Tipo_Usuario tuser) {
		tuserService.update(tuser);
		return "redirect:/ttipousuarios/list";
	}
}
