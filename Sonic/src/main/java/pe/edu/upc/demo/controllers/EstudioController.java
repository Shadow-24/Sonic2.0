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

import pe.edu.upc.demo.entities.Estudio;
import pe.edu.upc.demo.serviceinterfaces.IDistritoService;
import pe.edu.upc.demo.serviceinterfaces.IDuenioService;
import pe.edu.upc.demo.serviceinterfaces.IEstudioService;

@Controller
@RequestMapping("/eestudios")
public class EstudioController {
	@Autowired
	private IEstudioService estService;

	@Autowired
	private IDistritoService dService;

	@Autowired
	private IDuenioService dueService;

	@GetMapping("/new")
	public String newEstudio(Model model) {
		model.addAttribute("es", new Estudio());
		model.addAttribute("listaDistritos", dService.list());
		model.addAttribute("listaDuenios", dueService.list());
		return "/estudio/frmRegistro";
	}

	@PostMapping("/save")
	public String saveEstudio(@Valid Estudio objEstudio, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "/estudio/frmRegistro";
		} else {
			estService.insert(objEstudio);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/eestudios/list";
		}
	}

	@GetMapping("/list")
	public String listEstudio(Model model) {
		try {
			model.addAttribute("listaEstudios", estService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/estudio/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteEstudio(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				estService.delete(id);
				model.put("listaEstudios", estService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "/estudio/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateEstudio(@PathVariable int id, Model model) {
		Optional<Estudio> objPer = estService.listId(id);
		model.addAttribute("est", objPer.get());
		model.addAttribute("listaDistritos", dService.list());
		model.addAttribute("listaDuenios", dueService.list());
		return "/estudio/frmActualiza";
	}

	@PostMapping("/update")
	public String updateEstudio(Estudio es) {
		estService.update(es);
		return "redirect:/eestudios/list";
	}
}
