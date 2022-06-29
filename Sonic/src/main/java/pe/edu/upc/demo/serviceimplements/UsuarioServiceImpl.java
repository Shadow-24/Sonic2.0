package pe.edu.upc.demo.serviceimplements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Role;
import pe.edu.upc.demo.entities.Tipo_Usuario;
import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.repositories.IRoleRepository;
import pe.edu.upc.demo.repositories.ITipoUsuarioRepository;
import pe.edu.upc.demo.repositories.IUsuarioRepository;
import pe.edu.upc.demo.serviceinterfaces.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	private IUsuarioRepository uRepository;

	@Autowired
	private IRoleRepository rolerepository;

	@Autowired
	private ITipoUsuarioRepository tuserRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void insert(Usuario usuario) {

		Usuario objUsuario = usuario;
		objUsuario.setNPassword(passwordEncoder.encode(objUsuario.getNPassword()));

		Role role = new Role();
		Tipo_Usuario tuser = tuserRepository.findById(objUsuario.getTipo_user().getIdTipo_Usuario()).get();
		role.setRole("ROLE_" + tuser.getNameTipo_Usuario());
		role = rolerepository.save(role);

		objUsuario.setRoles(new ArrayList<Role>());
		objUsuario.getRoles().add(role);
		objUsuario = uRepository.save(objUsuario);
	}

	@Override
	public List<Usuario> list() {
		return uRepository.findAll();
	}

	@Override
	public void delete(int cusuario) {
		uRepository.deleteById(cusuario);
	}

	@Override
	public Optional<Usuario> listId(int cusuario) {
		return uRepository.findById(cusuario);
	}

	@Override
	public void update(Usuario usuario) {
		uRepository.save(usuario);
	}

}
