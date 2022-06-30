package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Duenio;
import pe.edu.upc.demo.repositories.IDuenioRepository;
import pe.edu.upc.demo.serviceinterfaces.IDuenioService;

@Service
public class DuenioServiceImpl implements IDuenioService {

	@Autowired
	private IDuenioRepository dueRepository;

	@Override
	public void insert(Duenio duenio) {
		dueRepository.save(duenio);
	}

	@Override
	public List<Duenio> list() {
		return dueRepository.findAll();
	}

	@Override
	public void delete(int CDuenio) {
		dueRepository.deleteById(CDuenio);
	}

	@Override
	public Optional<Duenio> listId(int CDuenio) {
		return dueRepository.findById(CDuenio);
	}

	@Override
	public void update(Duenio dueño) {
		dueRepository.save(dueño);
	}
}
