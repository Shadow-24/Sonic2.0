package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Marca_Instrumento;

@Repository
public interface IMarca_InstrumentoRepository extends JpaRepository<Marca_Instrumento, Integer> {

	// reporte
	@Query(value = "Select m.marca_instrumento, count(i.id_instrumento) from marca_instrumento m join instrumento i "
			+ "on m.id_marca_instrumento = i.id_marca_instrumento group by m.marca_instrumento", nativeQuery=true)
	public List<String[]> instrumentoMarca();

}
