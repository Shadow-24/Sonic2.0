package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Pago;

public interface IPagoService {

	public void insert(Pago pago);

	List<Pago> list();

	public void delete(int CPago);

	Optional<Pago> listId(int CPago);

	public void update(Pago pago);
}
