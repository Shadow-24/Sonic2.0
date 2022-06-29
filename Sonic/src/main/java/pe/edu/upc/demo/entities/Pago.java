package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pago")
public class Pago {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CPago;

	@ManyToOne
	@JoinColumn(name = "CReserva")
	private Reserva reserva;

	@ManyToOne
	@JoinColumn(name = "idForma_Pago")
	private Forma_Pago forma_pago;

	@Column(name = "QMonto", nullable = false)
	private int QMonto;

	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pago(int cPago, Reserva reserva, Forma_Pago forma_pago, int qMonto) {
		super();
		CPago = cPago;
		this.reserva = reserva;
		this.forma_pago = forma_pago;
		QMonto = qMonto;
	}

	public int getCPago() {
		return CPago;
	}

	public void setCPago(int cPago) {
		CPago = cPago;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Forma_Pago getForma_pago() {
		return forma_pago;
	}

	public void setForma_pago(Forma_Pago forma_pago) {
		this.forma_pago = forma_pago;
	}

	public int getQMonto() {
		return QMonto;
	}

	public void setQMonto(int qMonto) {
		QMonto = qMonto;
	}
}
