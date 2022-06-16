package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Forma_Pago;
import pe.edu.upc.demo.entities.Pago;
import pe.edu.upc.demo.repositories.IForma_PagoRepository;
import pe.edu.upc.demo.repositories.IPagoRepository;
import pe.edu.upc.demo.serviceinterfaces.IForma_PagoService;
import pe.edu.upc.demo.serviceinterfaces.IPagoService;

@Service
public class PagoServiceImpl implements IPagoService {

	@Autowired
	private IPagoRepository pagoRepository;

	@Override
	public void insert(Pago forma) {
		// TODO Auto-generated method stub
		pagoRepository.save(pago)
	}

	@Override
	public List<Pago> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int idPago) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Pago> listId(int idPago) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Pago pago) {
		// TODO Auto-generated method stub
		
	}

	

}
