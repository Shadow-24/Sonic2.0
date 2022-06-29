package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Duenio;

public interface IDuenioService {

	public void insert(Duenio duenio);

	List<Duenio> list();

	public void delete(int CDuenio);

	Optional<Duenio> listId(int CDuenio);

	public void update(Duenio duenio);
}
