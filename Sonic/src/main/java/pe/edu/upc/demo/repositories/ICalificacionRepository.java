package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Calificacion;

@Repository
public interface ICalificacionRepository extends JpaRepository<Calificacion, Integer> {
	@Query(value = "select e.nestudio, avg(c.qestrellas) as Promedio from usuario u join calificacion c on u.cusuario = c.cusuario join estudio e on c.cestudio = e.cestudio "
			+ "group by e.nestudio " + "order by 2 desc", nativeQuery = true)
	public List<String[]> PromedioCalificacion();
}
