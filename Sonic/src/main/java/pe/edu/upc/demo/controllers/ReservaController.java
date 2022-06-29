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

import pe.edu.upc.demo.entities.Reserva;
import pe.edu.upc.demo.serviceinterfaces.IReservaService;
import pe.edu.upc.demo.serviceinterfaces.IUsuarioService;

@Controller
@RequestMapping("/rreservas")
public class ReservaController {

	@Autowired
	private IReservaService reservaService;

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/new")
	public String newReserva(Model model) {
		model.addAttribute("re", new Reserva());
		model.addAttribute("listaUsuarios", usuarioService.list());
		return "/reserva/frmRegistro";
	}

	@PostMapping("/save")
	public String saveReserva(@Valid Reserva reserva, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			return "reserva/frmRegistro";
		} else {
			reservaService.insert(reserva);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/rreservas/new";
		}
	}

	@GetMapping("/list")
	public String listReserva(Model model) {

		try {
			model.addAttribute("listaReservas", reservaService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "reserva/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteReserva(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {
				reservaService.delete(id);
				model.put("listaReservas", reservaService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}

		return "reserva/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateReserva(@PathVariable int id, Model model) {

		Optional<Reserva> objReserva = reservaService.listId(id);
		model.addAttribute("reser", objReserva.get());

		return "reserva/frmActualiza";
	}

	@PostMapping("/update")
	public String updateReserva(Reserva reserva) {

		reservaService.update(reserva);
		return "redirect:/rreservas/list";
	}
}
