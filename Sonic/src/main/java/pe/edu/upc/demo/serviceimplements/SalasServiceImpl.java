package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Salas;
import pe.edu.upc.demo.repositories.ISalasRepository;
import pe.edu.upc.demo.serviceinterfaces.ISalasService;

@Service
public class SalasServiceImpl implements ISalasService {
	@Autowired
	private ISalasRepository salasRepository;

	@Override
	public void insert(Salas salas) {
		salasRepository.save(salas);
	}

	@Override
	public List<Salas> list() {
		return salasRepository.findAll();
	}

	@Override
	public void delete(int CSalas) {
		salasRepository.deleteById(CSalas);
	}

	@Override
	public Optional<Salas> listId(int CSalas) {
		return salasRepository.findById(CSalas);
	}

	@Override
	public void update(Salas salas) {
		salasRepository.save(salas);
	}

}
