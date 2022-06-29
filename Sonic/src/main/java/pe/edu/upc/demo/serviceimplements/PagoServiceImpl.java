package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Pago;
import pe.edu.upc.demo.repositories.IPagoRepository;
import pe.edu.upc.demo.serviceinterfaces.IPagoService;

@Service
public class PagoServiceImpl implements IPagoService {

	@Autowired
	private IPagoRepository pagoRepository;

	@Override
	public void insert(Pago pago) {
		pagoRepository.save(pago);
	}

	@Override
	public List<Pago> list() {
		return pagoRepository.findAll();
	}

	@Override
	public void delete(int CPago) {
		pagoRepository.deleteById(CPago);
	}

	@Override
	public Optional<Pago> listId(int CPago) {
		return pagoRepository.findById(CPago);
	}

	@Override
	public void update(Pago pago) {
		pagoRepository.save(pago);
	}

}
