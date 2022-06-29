package pe.edu.upc.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CReserva;

	@ManyToOne
	@JoinColumn(name = "CEstudio")
	private Estudio estudio;

	@ManyToOne
	@JoinColumn(name = "CMusico")
	private Musico musico;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "Fecha", nullable = false)
	private Date Fecha;

	@Column(name = "QCant_Horas", nullable = false)
	private int QCant_Horas;

	@Column(name = "QCant_Personas", nullable = false)
	private int QCant_Personas;

	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reserva(int cReserva, Estudio estudio, Musico musico, Date fecha, int qCant_Horas, int qCant_Personas) {
		super();
		CReserva = cReserva;
		this.estudio = estudio;
		this.musico = musico;
		Fecha = fecha;
		QCant_Horas = qCant_Horas;
		QCant_Personas = qCant_Personas;
	}

	public int getCReserva() {
		return CReserva;
	}

	public void setCReserva(int cReserva) {
		CReserva = cReserva;
	}

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}

	public Musico getMusico() {
		return musico;
	}

	public void setMusico(Musico musico) {
		this.musico = musico;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public int getQCant_Horas() {
		return QCant_Horas;
	}

	public void setQCant_Horas(int qCant_Horas) {
		QCant_Horas = qCant_Horas;
	}

	public int getQCant_Personas() {
		return QCant_Personas;
	}

	public void setQCant_Personas(int qCant_Personas) {
		QCant_Personas = qCant_Personas;
	}
}
