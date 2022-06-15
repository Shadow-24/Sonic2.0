package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Instrumento;

public interface IInstrumentoService {
	public void insert(Instrumento instrumento);

	List<Instrumento> list();

	public void delete(int idInstrumento);

	Optional<Instrumento> listId(int idInstrumento);

	public void update(Instrumento form_page);

}
