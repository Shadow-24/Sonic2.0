package pe.edu.upc.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Duenio")
public class Duenio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CDuenio;
	
	@ManyToOne
	@JoinColumn(name = "CUsuario")
	private Usuario usuario;

	public Duenio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Duenio(int cDuenio, Usuario usuario) {
		super();
		CDuenio = cDuenio;
		this.usuario = usuario;
	}

	public int getCDuenio() {
		return CDuenio;
	}

	public void setCDuenio(int cDuenio) {
		CDuenio = cDuenio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
