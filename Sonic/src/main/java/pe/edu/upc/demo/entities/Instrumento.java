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
@Table(name = "Instrumento")
public class Instrumento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idInstrumento;

	@Column(name = "NInstrumento", length = 20, nullable = false)
	private String NInstrumento;

	@ManyToOne
	@JoinColumn(name = "idMarca_Instrumento")
	private Marca_Instrumento marca_Instrumento;

	@ManyToOne
	@JoinColumn(name = "idTipoInstrumento")
	private TipoInstrumento tipoInstrumento;

	public Instrumento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Instrumento(int idInstrumento, String instrumento, Marca_Instrumento marca_Instrumento,
			TipoInstrumento tipoInstrumento) {
		super();
		this.idInstrumento = idInstrumento;
		this.NInstrumento = instrumento;
		this.marca_Instrumento = marca_Instrumento;
		this.tipoInstrumento = tipoInstrumento;
	}

	public int getIdInstrumento() {
		return idInstrumento;
	}

	public void setIdInstrumento(int idInstrumento) {
		this.idInstrumento = idInstrumento;
	}

	public String getNInstrumento() {
		return NInstrumento;
	}

	public void setNInstrumento(String nInstrumento) {
		NInstrumento = nInstrumento;
	}

	public Marca_Instrumento getMarca_Instrumento() {
		return marca_Instrumento;
	}

	public void setMarca_Instrumento(Marca_Instrumento marca_Instrumento) {
		this.marca_Instrumento = marca_Instrumento;
	}

	public TipoInstrumento getTipoInstrumento() {
		return tipoInstrumento;
	}

	public void setTipoInstrumento(TipoInstrumento tipoInstrumento) {
		this.tipoInstrumento = tipoInstrumento;
	}
	
	
}
