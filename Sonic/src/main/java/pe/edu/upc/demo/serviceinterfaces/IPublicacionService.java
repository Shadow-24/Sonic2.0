package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Publicacion;

public interface IPublicacionService {

	public void insert(Publicacion publi);

	List<Publicacion> list();

	public void delete(int CPublicacion);

	Optional<Publicacion> listId(int CPublicacion);

	public void update(Publicacion publi);

	public List<String[]> publicacionesxUsuario();
}
