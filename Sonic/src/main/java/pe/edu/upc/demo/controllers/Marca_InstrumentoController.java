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

import pe.edu.upc.demo.entities.Marca_Instrumento;
import pe.edu.upc.demo.serviceinterfaces.IMarca_InstrumentoService;

@Controller
@RequestMapping("/mmarca_instrumentos")
public class Marca_InstrumentoController {

	@Autowired
	private IMarca_InstrumentoService marca_instrumentoService;

	@GetMapping("/new")
	public String newMarca_Instrumento(Model model) {
		model.addAttribute("m", new Marca_Instrumento());
		return "marca_instrumento/frmRegistro";
	}

	@PostMapping("/save")
	public String saveMarca_Instrumento(@Valid Marca_Instrumento formpage, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			return "marca_instrumento/frmRegistro";
		} else {
			marca_instrumentoService.insert(formpage);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/mmarca_instrumentos/new";
		}
	}

	@GetMapping("/list")
	public String listMarca_Instrumento(Model model) {

		try {
			model.addAttribute("listaMarca_instrumentos", marca_instrumentoService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/marca_instrumento/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteMarca_Instrumento(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {
				marca_instrumentoService.delete(id);
				model.put("listaMarca_instrumentos", marca_instrumentoService.list());

			}

		} catch (Exception e) {
			model.put("error", e.getMessage());
		}

		return "redirect:/mmarca_instrumentos/new";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateMarca_Instrumento(@PathVariable int id, Model model) {

		Optional<Marca_Instrumento> objForm = marca_instrumentoService.listId(id);
		model.addAttribute("ma", objForm.get());

		return "marca_instrumento/frmActualiza";
	}

	@PostMapping("/update")
	public String updateMarca_Instrumento(Marca_Instrumento form_page) {

		marca_instrumentoService.update(form_page);
		return "redirect:/mmarca_instrumentos/list";
	}
}
