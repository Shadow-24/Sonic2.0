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

import pe.edu.upc.demo.entities.TipoInstrumento;
import pe.edu.upc.demo.serviceinterfaces.ITipoInstrumentoService;

@Controller
@RequestMapping("/ttipoinstrumentos")
public class TipoInstrumentoController {
	@Autowired
	private ITipoInstrumentoService tiService;

	@GetMapping("/new")
	public String newTipoInstrumento(Model model) {
		model.addAttribute("ti", new TipoInstrumento());
		return "/tipo_instrumento/frmRegistro";
	}

	@PostMapping("/save")
	public String saveTipoInstrumento(@Valid TipoInstrumento ti, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "/tipo_instrumento/frmRegistro";
		} else {
			tiService.insert(ti);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/ttipoinstrumentos/new";
		}
	}

	@GetMapping("/list")
	public String listTipoInstrumento(Model model) {
		try {
			model.addAttribute("listaTipoInstrumento", tiService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/tipo_instrumento/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteTipoInstrumento(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tiService.delete(id);
				model.put("listaTipoInstrumento", tiService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "/tipo_instrumento/frmLista";
	}

	// va a llevar el objeto y lo va a mostrar en el formulario
	@RequestMapping("/goupdate/{id}")
	public String goUpdateTipoInstrumento(@PathVariable int id, Model model) {

		Optional<TipoInstrumento> objPer = tiService.listId(id);
		model.addAttribute("tin", objPer.get());
		return "/tipo_instrumento/frmActualiza";
	}

	// guardar los cambios
	@PostMapping("/update")
	public String updateTipoInstrumento(TipoInstrumento ti) {
		tiService.update(ti);
		return "redirect:/ttipoinstrumentos/list";
	}

}
