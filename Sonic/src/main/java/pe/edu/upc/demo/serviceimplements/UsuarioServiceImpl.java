package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.repositories.IUsuarioRepository;
import pe.edu.upc.demo.serviceinterfaces.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	private IUsuarioRepository uRepository;

	@Override
	public void insert(Usuario usuario) {
		uRepository.save(usuario);
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
