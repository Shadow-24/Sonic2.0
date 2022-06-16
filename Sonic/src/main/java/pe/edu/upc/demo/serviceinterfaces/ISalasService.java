package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Salas;

public interface ISalasService {
	public void insert(Salas salas);

	public List<Salas> list();

	public void delete(int CSalas);

	Optional<Salas> listId(int CSalas);

	public void update(Salas salas);
}
