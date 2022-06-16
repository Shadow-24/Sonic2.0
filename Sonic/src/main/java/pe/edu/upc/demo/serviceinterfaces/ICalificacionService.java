package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Calificacion;

public interface ICalificacionService {
	public void insert(Calificacion calificacion);

	public List<Calificacion> list();

	public void delete(int CCalificacion);

	Optional<Calificacion> listId(int CCalificacion);

	public void update(Calificacion calificacion);
}
