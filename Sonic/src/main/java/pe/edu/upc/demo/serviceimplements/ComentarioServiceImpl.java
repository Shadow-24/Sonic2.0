package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Comentario;
import pe.edu.upc.demo.repositories.IComentarioRepository;
import pe.edu.upc.demo.serviceinterfaces.IComentarioService;

@Service
public class ComentarioServiceImpl implements IComentarioService {

	@Autowired
	private IComentarioRepository comentarepository;

	@Override
	public void insert(Comentario comentario) {

		comentarepository.save(comentario);
	}

	@Override
	public List<Comentario> list() {
		return comentarepository.findAll();
	}

	@Override
	public void delete(int CComentario) {
		comentarepository.deleteById(CComentario);
	}

	@Override
	public Optional<Comentario> listId(int CComentario) {
		return comentarepository.findById(CComentario);
	}

	@Override
	public void update(Comentario comentario) {
		comentarepository.save(comentario);
	}

}
