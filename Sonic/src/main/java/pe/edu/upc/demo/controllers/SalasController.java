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

import pe.edu.upc.demo.entities.Salas;
import pe.edu.upc.demo.serviceinterfaces.IEstudioService;
import pe.edu.upc.demo.serviceinterfaces.ISalasService;

@Controller
@RequestMapping("/ssalas")
public class SalasController {
	@Autowired
	private ISalasService sService;

	@Autowired
	private IEstudioService eService;

	@GetMapping("/new")
	public String newSalas(Model model) {
		model.addAttribute("s", new Salas());
		model.addAttribute("listaEstudios", eService.list());
		return "/salas/frmRegistro";
	}

	@PostMapping("/save")
	public String saveSalas(@Valid Salas objSalas, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "/salas/frmRegistro";
		} else {
			sService.insert(objSalas);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/ssalas/list";
		}
	}

	@GetMapping("/list")
	public String listSalas(Model model) {
		try {
			model.addAttribute("listaSalas", sService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/salas/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteSalas(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				sService.delete(id);
				model.put("listaSalas", sService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "/salas/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateSalas(@PathVariable int id, Model model) {
		Optional<Salas> objPer = sService.listId(id);
		model.addAttribute("sa", objPer.get());
		model.addAttribute("listaEstudios", eService.list());
		return "/salas/frmActualiza";
	}

	@PostMapping("/update")
	public String updateSalas(Salas es) {
		sService.update(es);
		return "redirect:/ssalas/list";
	}
}
