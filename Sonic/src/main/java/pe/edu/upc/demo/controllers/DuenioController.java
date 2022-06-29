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

import pe.edu.upc.demo.entities.Duenio;
import pe.edu.upc.demo.serviceinterfaces.IDuenioService;
import pe.edu.upc.demo.serviceinterfaces.IUsuarioService;

@Controller
@RequestMapping("/dduenios")
public class DuenioController {
	@Autowired
	private IDuenioService dueService;

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/new")
	public String newDuenio(Model model) {
		model.addAttribute("d", new Duenio());
		model.addAttribute("listaUsuarios", usuarioService.list());
		return "/duenio/frmRegistro";
	}

	@PostMapping("/save")
	public String saveDuenio(@Valid Duenio du, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "/duenio/frmRegistro";
		} else {
			dueService.insert(du);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/dduenios/list";
		}
	}

	@GetMapping("/list")
	public String listDuenio(Model model) {
		try {
			model.addAttribute("listaDuenios", dueService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/duenio/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteDuenio(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				dueService.delete(id);
				model.put("listaDuenios", dueService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "/duenio/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateDuenio(@PathVariable int id, Model model) {
		Optional<Duenio> objDis = dueService.listId(id);
		model.addAttribute("du", objDis.get());
		model.addAttribute("listaUsuarios", usuarioService.list());
		return "duenio/frmActualiza";
	}

	@PostMapping("/update")
	public String updateDuenio(Duenio d) {
		dueService.update(d);
		return "redirect:/dduenios/list";
	}
}