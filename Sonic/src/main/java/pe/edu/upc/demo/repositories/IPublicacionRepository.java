package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Publicacion;

@Repository
public interface IPublicacionRepository extends JpaRepository<Publicacion, Integer> {

	@Query(value = "select p.CPublicacion , count(c.CComentario) from publicación p join comentario c "
			+ "on p.CPublicacion = c.CPublicacion group by p.CPublicacion", nativeQuery = true)
	public List<String[]> comentariosxPublicacion();

}
