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
@Table(name = "Comentario")
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CComentario;

	@Column(name = "TComentario", length = 300, nullable = false)
	private String TComentario;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "Fecha", nullable = false)
	private Date Fecha;

	@ManyToOne
	@JoinColumn(name = "CUsuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "CPublicacion")
	private Publicacion publicacion;

	public Comentario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comentario(int cComentario, String tComentario, Date fecha, Usuario usuario, Publicacion publicacion) {
		super();
		CComentario = cComentario;
		TComentario = tComentario;
		Fecha = fecha;
		this.usuario = usuario;
		this.publicacion = publicacion;
	}

	public int getCComentario() {
		return CComentario;
	}

	public void setCComentario(int cComentario) {
		CComentario = cComentario;
	}

	public String getTComentario() {
		return TComentario;
	}

	public void setTComentario(String tComentario) {
		TComentario = tComentario;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

}
