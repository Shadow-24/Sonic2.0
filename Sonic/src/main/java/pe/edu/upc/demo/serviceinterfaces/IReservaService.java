package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Reserva;

public interface IReservaService {

	public void insert(Reserva reserva);

	List<Reserva> list();

	public void delete(int CReserva);

	Optional<Reserva> listId(int CReserva);

	public void update(Reserva reserva);
}
