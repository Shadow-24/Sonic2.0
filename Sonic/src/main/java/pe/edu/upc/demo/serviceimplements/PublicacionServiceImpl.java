package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Publicacion;
import pe.edu.upc.demo.repositories.IPublicacionRepository;
import pe.edu.upc.demo.serviceinterfaces.IPublicacionService;

@Service
public class PublicacionServiceImpl implements IPublicacionService {

	@Autowired
	private IPublicacionRepository publirepository;

	@Override
	public void insert(Publicacion publi) {
		publirepository.save(publi);
	}

	@Override
	public List<Publicacion> list() {
		return publirepository.findAll();
	}

	@Override
	public void delete(int CPublicacion) {
		publirepository.deleteById(CPublicacion);
	}

	@Override
	public Optional<Publicacion> listId(int CPublicacion) {
		return publirepository.findById(CPublicacion);
	}

	@Override
	public void update(Publicacion publi) {
		publirepository.save(publi);

	}

	@Override
	public List<String[]> publicacionesxUsuario() {
		return publirepository.publicacionesxUsuario();
	}

}
