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

	@ManyToOne
	@JoinColumn(name = "CUsuario")
	private Usuario usuario;

	@Column(name = "QEstrellas")
	private float QEstrellas;

	public Calificacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calificacion(int cCalificacion, Estudio estudio, Usuario usuario, float qEstrellas) {
		super();
		CCalificacion = cCalificacion;
		this.estudio = estudio;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public float getQEstrellas() {
		return QEstrellas;
	}

	public void setQEstrellas(float qEstrellas) {
		QEstrellas = qEstrellas;
	}
}
