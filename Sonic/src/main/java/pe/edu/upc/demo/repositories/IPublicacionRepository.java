package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Publicacion;

@Repository
public interface IPublicacionRepository extends JpaRepository<Publicacion, Integer> {

	@Query(value = "Select p.desc_publicacion, p.text_publicacion from publicación p join usuario u "
			+ "on p.CUsuario=u.CUsuario join role r on u.cusuario=r.user_id where u.cusuario = r.user_id group by p.desc_publicacion, p.text_publicacion", nativeQuery = true)
	public List<String[]> publicacionesxUsuario();

}
