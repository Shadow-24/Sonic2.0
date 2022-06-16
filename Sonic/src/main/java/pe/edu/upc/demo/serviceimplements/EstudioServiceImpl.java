package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Estudio;
import pe.edu.upc.demo.repositories.IEstudioRepository;
import pe.edu.upc.demo.serviceinterfaces.IEstudioService;

@Service
public class EstudioServiceImpl implements IEstudioService {
	@Autowired
	private IEstudioRepository estudioRepository;

	@Override
	public void insert(Estudio estudio) {
		estudioRepository.save(estudio);
	}

	@Override
	public List<Estudio> list() {
		return estudioRepository.findAll();
	}

	@Override
	public void delete(int CEstudio) {
		estudioRepository.deleteById(CEstudio);
	}

	@Override
	public Optional<Estudio> listId(int CEstudio) {
		return estudioRepository.findById(CEstudio);
	}

	@Override
	public void update(Estudio estudio) {
		estudioRepository.save(estudio);
	}

}
