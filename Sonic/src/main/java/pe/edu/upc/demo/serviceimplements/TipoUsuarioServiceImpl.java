package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Tipo_Usuario;
import pe.edu.upc.demo.repositories.ITipoUsuarioRepository;
import pe.edu.upc.demo.serviceinterfaces.ITipoUsuarioService;

@Service
public class TipoUsuarioServiceImpl implements ITipoUsuarioService {

	@Autowired
	private ITipoUsuarioRepository tuserRepository;

	@Override
	public void insert(Tipo_Usuario tuser) {
		tuserRepository.save(tuser);
	}

	@Override
	public List<Tipo_Usuario> list() {

		return tuserRepository.findAll();
	}

	@Override
	public void delete(int idTipoUsuario) {
		tuserRepository.deleteById(idTipoUsuario);

	}

	@Override
	public Optional<Tipo_Usuario> listId(int idTipoUsuario) {
		return tuserRepository.findById(idTipoUsuario);
	}

	@Override
	public void update(Tipo_Usuario tuser) {
		tuserRepository.save(tuser);
	}

}
