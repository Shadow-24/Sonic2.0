package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Dueño;

public interface IDueñoService {
	public void insert(Dueño d);
	
	public List<Dueño> list();
	
	public void delete(int CDueño);
	
	Optional<Dueño> listId(int CDueño);
	
	public void update(Dueño dueño);
}
