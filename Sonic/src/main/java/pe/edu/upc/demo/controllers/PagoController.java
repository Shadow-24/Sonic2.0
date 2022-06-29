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

import pe.edu.upc.demo.entities.Pago;
import pe.edu.upc.demo.serviceinterfaces.IForma_PagoService;
import pe.edu.upc.demo.serviceinterfaces.IPagoService;
import pe.edu.upc.demo.serviceinterfaces.IReservaService;

@Controller
@RequestMapping("/ppagos")
public class PagoController {

	@Autowired
	private IPagoService pagoService;

	@Autowired
	private IReservaService reService;

	@Autowired
	private IForma_PagoService fpService;

	@GetMapping("/new")
	public String newPago(Model model) {
		model.addAttribute("p", new Pago());
		model.addAttribute("listaForma_pagos", fpService.list());
		model.addAttribute("listaReservas", reService.list());
		return "/Pago/frmRegistro";
	}

	@PostMapping("/save")
	public String savePago(@Valid Pago objEstudio, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "/Pago/frmRegistro";
		} else {
			pagoService.insert(objEstudio);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/ppagos/list";
		}
	}

	@GetMapping("/list")
	public String listPago(Model model) {
		try {
			model.addAttribute("listaPagos", pagoService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/Pago/frmLista";
	}

	@RequestMapping("/delete")
	public String deletePago(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				pagoService.delete(id);
				model.put("listaPagos", pagoService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "/Pago/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdatePago(@PathVariable int id, Model model) {
		Optional<Pago> objPer = pagoService.listId(id);
		model.addAttribute("pa", objPer.get());
		model.addAttribute("listaForma_pagos", fpService.list());
		model.addAttribute("listaReservas", reService.list());
		return "/Pago/frmActualiza";
	}

	@PostMapping("/update")
	public String updatePago(Pago es) {
		pagoService.update(es);
		return "redirect:/ppagos/list";
	}
}
