package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pago")
public class Pago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPago;
	
	@Column(name = "CPago", nullable=false)
	private String CPago;
	
	@Column(name="CReserva", nullable=false)
	private String CReserva;
	
	@Column(name="QMonto", nullable=false)
	private int QMonto;
	
	@Column(name="CMetodo", nullable=false)
	private String CMetodo;

	
	
	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Pago(int idPago, String cPago, String cReserva, int qMonto, String cMetodo) {
		super();
		this.idPago = idPago;
		CPago = cPago;
		CReserva = cReserva;
		QMonto = qMonto;
		CMetodo = cMetodo;
	}



	public int getIdPago() {
		return idPago;
	}



	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}



	public String getCPago() {
		return CPago;
	}



	public void setCPago(String cPago) {
		CPago = cPago;
	}



	public String getCReserva() {
		return CReserva;
	}



	public void setCReserva(String cReserva) {
		CReserva = cReserva;
	}



	public int getQMonto() {
		return QMonto;
	}



	public void setQMonto(int qMonto) {
		QMonto = qMonto;
	}



	public String getCMetodo() {
		return CMetodo;
	}



	public void setCMetodo(String cMetodo) {
		CMetodo = cMetodo;
	}
	
	
	
	
	
}
