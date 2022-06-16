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

import pe.edu.upc.demo.entities.Calificacion;
import pe.edu.upc.demo.serviceinterfaces.ICalificacionService;
import pe.edu.upc.demo.serviceinterfaces.IEstudioService;

@Controller
@RequestMapping("/ccalificaciones")
public class CalificacionController {
	@Autowired
	private ICalificacionService cService;

	@Autowired
	private IEstudioService eService;

	@GetMapping("/new")
	public String newCalificacion(Model model) {
		model.addAttribute("c", new Calificacion());
		model.addAttribute("listaEstudios", eService.list());
		return "/calificacion/frmRegistro";
	}

	@PostMapping("/save")
	public String saveCalificacion(@Valid Calificacion objCalificacion, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "/calificacion/frmRegistro";
		} else {
			cService.insert(objCalificacion);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/ccalificaciones/list";
		}
	}

	@GetMapping("/list")
	public String listCalificacion(Model model) {
		try {
			model.addAttribute("listaCalificacion", cService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/calificacion/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteCalificacion(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				cService.delete(id);
				model.put("listaCalificacion", cService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "/calificacion/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateCalificacion(@PathVariable int id, Model model) {
		Optional<Calificacion> objPer = cService.listId(id);
		model.addAttribute("ca", objPer.get());
		model.addAttribute("listaEstudios", eService.list());
		return "/calificacion/frmActualiza";
	}

	@PostMapping("/update")
	public String updateSalas(Calificacion es) {
		cService.update(es);
		return "redirect:/ccalificaciones/list";
	}
}
