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

import pe.edu.upc.demo.entities.Distrito;
import pe.edu.upc.demo.serviceinterfaces.IDistritoService;

@Controller
@RequestMapping("/ddistritos")
public class DistritoController {

	@Autowired
	private IDistritoService distritoService;

	@GetMapping("/new")
	public String newDistrito(Model model) {
		model.addAttribute("d", new Distrito());
		return "distrito/frmRegistro";
	}

	@PostMapping("/save")
	public String saveDistrito(@Valid Distrito di, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "distrito/frmRegistro";
		} else {
			distritoService.insert(di);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/ddistritos/list";
		}
	}

	@GetMapping("/list")
	public String listDistrito(Model model) {
		try {
			model.addAttribute("d", new Distrito());
			model.addAttribute("listaDistritos", distritoService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			// TODO: handle exception
		}
		return "distrito/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteDistrito(Map<String, Object> model, @RequestParam(value="id")Integer id) {
		try {
			if(id != null && id>0) {
				distritoService.delete(id);
				model.put("listaDistritos", distritoService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("error", e.getMessage());
		}
		return "distrito/frmLista";
	}
	
	@RequestMapping("/goupdate/{id}")
	public String goUpdateDistrito(@PathVariable int id, Model model) {
		Optional<Distrito>objDis=distritoService.listId(id);
		model.addAttribute("di", objDis.get());
		return "distrito/frmActualiza";
	}
	
	@PostMapping("/update")
	public String updateDistrito(Distrito d) {
		distritoService.update(d);
		return "redirect:/ddistritos/list";
	}
}