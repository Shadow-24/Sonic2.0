package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Calificacion;
import pe.edu.upc.demo.repositories.ICalificacionRepository;
import pe.edu.upc.demo.serviceinterfaces.ICalificacionService;

@Service
public class CalificacionServiceImpl implements ICalificacionService {
	@Autowired
	private ICalificacionRepository calificacionRepository;

	@Override
	public void insert(Calificacion calificacion) {
		calificacionRepository.save(calificacion);
	}

	@Override
	public List<Calificacion> list() {
		return calificacionRepository.findAll();
	}

	@Override
	public void delete(int CCalificacion) {
		calificacionRepository.deleteById(CCalificacion);
	}

	@Override
	public Optional<Calificacion> listId(int Calificacion) {
		return calificacionRepository.findById(Calificacion);
	}

	@Override
	public void update(Calificacion calificacion) {
		calificacionRepository.save(calificacion);
	}

	@Override
	public List<String[]> PromedioCalificacion() {
		return calificacionRepository.PromedioCalificacion();
	}

}
