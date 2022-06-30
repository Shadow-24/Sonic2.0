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

import pe.edu.upc.demo.entities.Forma_Pago;
import pe.edu.upc.demo.serviceinterfaces.IForma_PagoService;

@Controller
@RequestMapping("/fforma_pagos")
public class Forma_PagoController {

	@Autowired
	private IForma_PagoService forma_pagoService;

	@GetMapping("/new")
	public String newForma_Pago(Model model) {

		model.addAttribute("f", new Forma_Pago());
		return "forma_pago/frmRegistro";
	}

	@PostMapping("/save")
	public String saveForma_Pago(@Valid Forma_Pago formpage, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			return "forma_pago/frmRegistro";
		} else {
			forma_pagoService.insert(formpage);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/fforma_pagos/new";
		}
	}

	@GetMapping("/list")
	public String listForma_Pago(Model model) {

		try {
			model.addAttribute("listaForma_pagos", forma_pagoService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "forma_pago/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteForma_Pago(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {
				forma_pagoService.delete(id);
				model.put("listaForma_pagos", forma_pagoService.list());

			}

		} catch (Exception e) {
			model.put("error", e.getMessage());
		}

		return "forma_pago/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateForma_Pago(@PathVariable int id, Model model) {

		Optional<Forma_Pago> objForm = forma_pagoService.listId(id);
		model.addAttribute("fo", objForm.get());

		return "forma_pago/frmActualiza";
	}

	@PostMapping("/update")
	public String updateForma_Pago(Forma_Pago form_page) {

		forma_pagoService.update(form_page);
		return "redirect:/fforma_pagos/list";
	}
	
	@RequestMapping("/report10")
	public String instrumentoMarca(Map<String,Object> model) {
		
		model.put("listaPagoForma", forma_pagoService.pagoForma());
		return "forma_pago/report10";
	}
}
