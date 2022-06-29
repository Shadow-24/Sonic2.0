package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Marca_Instrumento;

public interface IMarca_InstrumentoService {
	public void insert(Marca_Instrumento marca);

	List<Marca_Instrumento> list();

	public void delete(int idMarca_Instrumento);

	Optional<Marca_Instrumento> listId(int idMarca_Instrumento);

	public void update(Marca_Instrumento form_page);
	
	public List<String[]>instrumentoMarca();
}
