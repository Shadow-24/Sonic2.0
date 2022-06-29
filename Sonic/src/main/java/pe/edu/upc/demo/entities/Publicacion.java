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
@Table(name = "Publicación")
public class Publicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CPublicacion;

	@Column(name = "DescPublicacion", length = 30, nullable = false)
	private String DescPublicacion;

	@Column(name = "TextPublicacion", length = 300, nullable = false)
	private String TextPublicacion;

	@ManyToOne
	@JoinColumn(name = "CUsuario")
	private Usuario usuario;

	@Column(name = "QReacciones", nullable = false)
	private int QReacciones;

	public Publicacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Publicacion(int cPublicacion, String descPublicacion, String textPublicacion, Usuario usuario,
			int qReacciones) {
		super();
		CPublicacion = cPublicacion;
		DescPublicacion = descPublicacion;
		TextPublicacion = textPublicacion;
		this.usuario = usuario;
		QReacciones = qReacciones;
	}

	public int getCPublicacion() {
		return CPublicacion;
	}

	public void setCPublicacion(int cPublicacion) {
		CPublicacion = cPublicacion;
	}

	public String getDescPublicacion() {
		return DescPublicacion;
	}

	public void setDescPublicacion(String descPublicacion) {
		DescPublicacion = descPublicacion;
	}

	public String getTextPublicacion() {
		return TextPublicacion;
	}

	public void setTextPublicacion(String textPublicacion) {
		TextPublicacion = textPublicacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getQReacciones() {
		return QReacciones;
	}

	public void setQReacciones(int qReacciones) {
		QReacciones = qReacciones;
	}

}
