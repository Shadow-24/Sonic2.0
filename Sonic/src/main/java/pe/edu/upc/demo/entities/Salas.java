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
@Table(name = "Salas")
public class Salas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CSalas;

	@Column(name = "NSalas", nullable = false)
	private String NSalas;

	@ManyToOne
	@JoinColumn(name = "CEstudio")
	private Estudio estudio;

	public Salas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Salas(int cSalas, String nSalas, Estudio estudio) {
		super();
		CSalas = cSalas;
		NSalas = nSalas;
		this.estudio = estudio;
	}

	public int getCSalas() {
		return CSalas;
	}

	public void setCSalas(int cSalas) {
		CSalas = cSalas;
	}

	public String getNSalas() {
		return NSalas;
	}

	public void setNSalas(String nSalas) {
		NSalas = nSalas;
	}

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}

}
