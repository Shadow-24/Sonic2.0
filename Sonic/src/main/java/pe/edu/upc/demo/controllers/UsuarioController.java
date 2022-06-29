package pe.edu.upc.demo.controllers;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.serviceinterfaces.IDistritoService;
import pe.edu.upc.demo.serviceinterfaces.IUsuarioService;

@Controller
@RequestMapping("/uusuarios")
public class UsuarioController {
	@Autowired
	private IDistritoService dService;

	@Autowired
	private IUsuarioService uService;

	@RequestMapping("/new")
	public String newUsuario(Model model) {
		model.addAttribute("u", new Usuario());
		model.addAttribute("listaDistritos", dService.list());
		return "usuario/frmRegistro";
	}

	@RequestMapping("/save")
	public String saveUsuario(@ModelAttribute Usuario objUsuario, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			return "usuario/frmRegistro";
		} else {
			uService.insert(objUsuario);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/login";
		}
	}

	@GetMapping("/list")
	public String listUsuario(Model model) {
		try {
			model.addAttribute("listaUsuarios", uService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/usuario/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteUsuario(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				uService.delete(id);
				model.put("listaUsuarios", uService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("error", e.getMessage());
		}
		return "/usuario/frmLista";
	}

	// va a llevar el objeto y lo va a mostrar en el formulario
	@RequestMapping("/goupdate/{id}")
	public String goUpdateUsuario(@PathVariable int id, Model model) {

		Optional<Usuario> objPer = uService.listId(id);
		model.addAttribute("usu", objPer.get());
		model.addAttribute("listaDistritos", dService.list());
		return "/usuario/frmActualiza";
	}

	// guardar los cambios
	@PostMapping("/update")
	public String updateUsuario(Usuario us) {
		uService.update(us);
		return "redirect:/uusuarios/list";
	}
}
