package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Comentario;

public interface IComentarioService {

	public void insert(Comentario comentario);

	List<Comentario> list();

	public void delete(int CComentario);

	Optional<Comentario> listId(int CComentario);

	public void update(Comentario comentario);
}
