package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.TipoInstrumento;

public interface ITipoInstrumentoService {
	public void insert(TipoInstrumento tipoinstrumento);

	public List<TipoInstrumento> list();

	public void delete(int idTipoInstrumento);

	Optional<TipoInstrumento> listId(int idTipoInstrumento);

	public void update(TipoInstrumento tipoinstrumento);
}
