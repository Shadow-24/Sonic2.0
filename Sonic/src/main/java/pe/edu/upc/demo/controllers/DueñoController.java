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

import pe.edu.upc.demo.entities.Dueño;
import pe.edu.upc.demo.serviceinterfaces.IDueñoService;

@Controller
@RequestMapping("/ddueños")
public class DueñoController {

	@Autowired
	private IDueñoService dueñoService;

	@GetMapping("/new")
	public String newDueño(Model model) {
		model.addAttribute("d", new Dueño());
		return "dueño/frmRegistro";
	}

	@PostMapping("/save")
	public String saveDueño(@Valid Dueño du, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "dueño/frmRegistro";
		} else {
			dueñoService.insert(du);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/ddueños/list";
		}
	}

	@GetMapping("/list")
	public String listDueño(Model model) {
		try {
			model.addAttribute("d", new Dueño());
			model.addAttribute("listaDueños", dueñoService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			// TODO: handle exception
		}
		return "dueño/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteDueño(Map<String, Object> model, @RequestParam(value="id")Integer id) {
		try {
			if(id != null && id>0) {
				dueñoService.delete(id);
				model.put("listaDueños", dueñoService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("error", e.getMessage());
		}
		return "dueño/frmLista";
	}
	
	@RequestMapping("/goupdate/{id}")
	public String goUpdateDueño(@PathVariable int id, Model model) {
		Optional<Dueño>objDis=dueñoService.listId(id);
		model.addAttribute("du", objDis.get());
		return "dueño/frmActualiza";
	}
	
	@PostMapping("/update")
	public String updateDueño(Dueño d) {
		dueñoService.update(d);
		return "redirect:/ddueños/list";
	}
}