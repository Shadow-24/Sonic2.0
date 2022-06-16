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

import pe.edu.upc.demo.entities.Instrumento;
import pe.edu.upc.demo.serviceinterfaces.IInstrumentoService;
import pe.edu.upc.demo.serviceinterfaces.IMarca_InstrumentoService;
import pe.edu.upc.demo.serviceinterfaces.ITipoInstrumentoService;

@Controller
@RequestMapping("/iinstrumentos")
public class InstrumentoController {
	@Autowired
	private IInstrumentoService instrumentoService;
	@Autowired
	private IMarca_InstrumentoService marca_instrumentoService; 
	@Autowired
	private ITipoInstrumentoService tiService;
	
	@GetMapping("/new")
	public String newInstrumento(Model model) {
		model.addAttribute("i", new Instrumento());
		model.addAttribute("listaMarca_instrumentos",marca_instrumentoService.list());
		model.addAttribute("listaTipoInstrumento",tiService.list());
		return "instrumento/frmRegistro";
	}

	@PostMapping("/save")
	public String saveInstrumento(@Valid Instrumento formpage, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			return "instrumento/frmRegistro";
		} else {
			instrumentoService.insert(formpage);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/iinstrumentos/new";
		}
	}
	
	@GetMapping("/list")
	public String listInstrumento(Model model) {

		try {
			model.addAttribute("listaInstrumentos", instrumentoService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/instrumento/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteInstrumento(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {
				instrumentoService.delete(id);
				model.put("listaInstrumentos", instrumentoService.list());

			}

		} catch (Exception e) {
			model.put("error", e.getMessage());
		}

		return "redirect:/iinstrumentos/new";
	}
	
	@RequestMapping("/goupdate/{id}")
	public String goUpdateInstrumento(@PathVariable int id, Model model) {

		Optional<Instrumento> objForm = instrumentoService.listId(id);
		model.addAttribute("in", objForm.get());
		model.addAttribute("listaMarca_instrumentos",marca_instrumentoService.list());
		model.addAttribute("listaTipoInstrumento",tiService.list());
		return "instrumento/frmActualiza";
	}

	@PostMapping("/update")
	public String updateInstrumento(Instrumento form_page) {

		instrumentoService.update(form_page);
		return "redirect:/iinstrumentos/list";
	}
}
