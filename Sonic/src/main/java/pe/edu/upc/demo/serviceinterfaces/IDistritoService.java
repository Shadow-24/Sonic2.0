package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Distrito;

public interface IDistritoService {
	public void insert(Distrito d);
	
	public List<Distrito> list();
	
	public void delete(int CDistrito);
	
	Optional<Distrito> listId(int CDistrito);
	
	public void update(Distrito distrito);
}
