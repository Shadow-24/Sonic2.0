package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoInstrumento")
public class TipoInstrumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoInstrumento;

	@Column(name = "NTipoInstrumento", length = 50, nullable = false)
	private String NTipoInstrumento;

	public TipoInstrumento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoInstrumento(int idTipoInstrumento, String nTipoInstrumento) {
		super();
		this.idTipoInstrumento = idTipoInstrumento;
		NTipoInstrumento = nTipoInstrumento;
	}

	public int getIdTipoInstrumento() {
		return idTipoInstrumento;
	}

	public void setIdTipoInstrumento(int idTipoInstrumento) {
		this.idTipoInstrumento = idTipoInstrumento;
	}

	public String getNTipoInstrumento() {
		return NTipoInstrumento;
	}

	public void setNTipoInstrumento(String nTipoInstrumento) {
		NTipoInstrumento = nTipoInstrumento;
	}
}
