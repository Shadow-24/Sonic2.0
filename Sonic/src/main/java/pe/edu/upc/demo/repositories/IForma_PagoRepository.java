package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Forma_Pago;

@Repository
public interface IForma_PagoRepository extends JpaRepository<Forma_Pago, Integer> {

	// report
	@Query(value = "Select f.forma_pago, count(p.cpago) from forma_pago f join pago p "
			+ "on f.id_Forma_Pago = p.id_Forma_Pago group by f.forma_pago", nativeQuery=true)
	
	public List<String[]> pagoForma();
}
