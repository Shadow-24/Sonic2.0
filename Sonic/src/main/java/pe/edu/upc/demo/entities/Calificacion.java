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
@Table(name = "Calificacion")
public class Calificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CCalificacion;

	@ManyToOne
	@JoinColumn(name = "CEstudio")
	private Estudio estudio;

	@Column(name = "QEstrellas")
	private int QEstrellas;

	public Calificacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calificacion(int cCalificacion, Estudio estudio, int qEstrellas) {
		super();
		CCalificacion = cCalificacion;
		this.estudio = estudio;
		QEstrellas = qEstrellas;
	}

	public int getCCalificacion() {
		return CCalificacion;
	}

	public void setCCalificacion(int cCalificacion) {
		CCalificacion = cCalificacion;
	}

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}

	public int getQEstrellas() {
		return QEstrellas;
	}

	public void setQEstrellas(int qEstrellas) {
		QEstrellas = qEstrellas;
	}

}
