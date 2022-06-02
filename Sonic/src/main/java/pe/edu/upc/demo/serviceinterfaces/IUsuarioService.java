package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Usuario;

public interface IUsuarioService {

	public void insert(Usuario usuario);

	public List<Usuario> list();

	public void delete(int cusuario);

	Optional<Usuario> listId(int cusuario);

	public void update(Usuario usuario);
}
