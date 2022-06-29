package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Tipo_Usuario;

public interface ITipoUsuarioService {

	public void insert(Tipo_Usuario tuser);

	public List<Tipo_Usuario> list();

	public void delete(int idTipoUsuario);

	Optional<Tipo_Usuario> listId(int idTipoUsuario);

	public void update(Tipo_Usuario tuser);
}
