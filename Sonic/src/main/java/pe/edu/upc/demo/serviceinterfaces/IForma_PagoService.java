package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Forma_Pago;

public interface IForma_PagoService {

	public void insert(Forma_Pago forma);

	List<Forma_Pago> list();

	public void delete(int idForma_Pago);

	Optional<Forma_Pago> listId(int idForma_Pago);

	public void update(Forma_Pago form_page);
}
