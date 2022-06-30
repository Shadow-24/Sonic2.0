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
@Table(name = "Estudio")
public class Estudio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CEstudio;

	@Column(name = "NEstudio", nullable = false)
	private String NEstudio;

	@Column(name = "NumTelefono", nullable = false)
	private int NumTelefono;

	@ManyToOne
	@JoinColumn(name = "CDistrito")
	private Distrito distrito;

	@Column(name = "TDireccion", nullable = false)
	private String TDireccion;

	@ManyToOne
	@JoinColumn(name = "CUsuario")
	private Usuario usuario;

	public Estudio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estudio(int cEstudio, String nEstudio, int numTelefono, Distrito distrito, String tDireccion,
			Usuario usuario) {
		super();
		CEstudio = cEstudio;
		NEstudio = nEstudio;
		NumTelefono = numTelefono;
		this.distrito = distrito;
		TDireccion = tDireccion;
		this.usuario = usuario;
	}

	public int getCEstudio() {
		return CEstudio;
	}

	public void setCEstudio(int cEstudio) {
		CEstudio = cEstudio;
	}

	public String getNEstudio() {
		return NEstudio;
	}

	public void setNEstudio(String nEstudio) {
		NEstudio = nEstudio;
	}

	public int getNumTelefono() {
		return NumTelefono;
	}

	public void setNumTelefono(int numTelefono) {
		NumTelefono = numTelefono;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public String getTDireccion() {
		return TDireccion;
	}

	public void setTDireccion(String tDireccion) {
		TDireccion = tDireccion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
