package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Forma_Pago;
import pe.edu.upc.demo.repositories.IForma_PagoRepository;
import pe.edu.upc.demo.serviceinterfaces.IForma_PagoService;

@Service
public class Forma_PagoServiceImpl implements IForma_PagoService {

	@Autowired
	private IForma_PagoRepository forma_pagoRepository;

	@Override
	public void insert(Forma_Pago forma) {
		forma_pagoRepository.save(forma);
	}

	@Override
	public List<Forma_Pago> list() {
		return forma_pagoRepository.findAll();
	}

	@Override
	public void delete(int idForma_Pago) {

		forma_pagoRepository.deleteById(idForma_Pago);
	}

	@Override
	public Optional<Forma_Pago> listId(int idForma_Pago) {

		return forma_pagoRepository.findById(idForma_Pago);
	}

	@Override
	public void update(Forma_Pago form_page) {

		forma_pagoRepository.save(form_page);
	}

}
