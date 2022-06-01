package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Forma_Pago")
public class Forma_Pago {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idForma_Pago;

	@Column(name = "Forma_Pago", length = 20, nullable = false)
	private String Forma_Pago;

	public Forma_Pago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Forma_Pago(int idForma_Pago, String forma_Pago) {
		super();
		this.idForma_Pago = idForma_Pago;
		Forma_Pago = forma_Pago;
	}

	public int getIdForma_Pago() {
		return idForma_Pago;
	}

	public void setIdForma_Pago(int idForma_Pago) {
		this.idForma_Pago = idForma_Pago;
	}

	public String getForma_Pago() {
		return Forma_Pago;
	}

	public void setForma_Pago(String forma_Pago) {
		Forma_Pago = forma_Pago;
	}

}
