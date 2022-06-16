package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Reserva;
import pe.edu.upc.demo.repositories.IReservaRepository;
import pe.edu.upc.demo.serviceinterfaces.IReservaService;

@Service
public class ReservaServiceImpl implements IReservaService {

	@Autowired
	private IReservaRepository reservarepository;

	@Override
	public void insert(Reserva reserva) {
		reservarepository.save(reserva);
	}

	@Override
	public List<Reserva> list() {
		return reservarepository.findAll();
	}

	@Override
	public void delete(int CReserva) {
		reservarepository.deleteById(CReserva);
	}

	@Override
	public Optional<Reserva> listId(int CReserva) {
		return reservarepository.findById(CReserva);
	}

	@Override
	public void update(Reserva reserva) {
		reservarepository.save(reserva);
	}

}
