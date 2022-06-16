package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Musico;

public interface IMusicoService {

	public void insert(Musico musico);

	List<Musico> list();

	public void delete(int CMusico);

	Optional<Musico> listId(int CMusico);

	public void update(Musico musico);
}
