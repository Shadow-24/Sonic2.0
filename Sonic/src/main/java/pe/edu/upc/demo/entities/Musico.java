package pe.edu.upc.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Musico")
public class Musico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CMusico;

	@ManyToOne
	@JoinColumn(name = "CUsuario")
	private Usuario usuario;

	public Musico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Musico(int cMusico, Usuario usuario) {
		super();
		CMusico = cMusico;
		this.usuario = usuario;
	}

	public int getCMusico() {
		return CMusico;
	}

	public void setCMusico(int cMusico) {
		CMusico = cMusico;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
