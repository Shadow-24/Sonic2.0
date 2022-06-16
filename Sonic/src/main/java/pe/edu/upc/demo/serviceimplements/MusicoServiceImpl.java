package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Musico;
import pe.edu.upc.demo.repositories.IMusicoRepository;
import pe.edu.upc.demo.serviceinterfaces.IMusicoService;

@Service
public class MusicoServiceImpl implements IMusicoService {

	@Autowired
	private IMusicoRepository musicorepository;

	@Override
	public void insert(Musico musico) {
		musicorepository.save(musico);

	}

	@Override
	public List<Musico> list() {
		return musicorepository.findAll();
	}

	@Override
	public void delete(int CMusico) {

		musicorepository.deleteById(CMusico);
	}

	@Override
	public Optional<Musico> listId(int CMusico) {

		return musicorepository.findById(CMusico);
	}

	@Override
	public void update(Musico musico) {

		musicorepository.save(musico);

	}

}
