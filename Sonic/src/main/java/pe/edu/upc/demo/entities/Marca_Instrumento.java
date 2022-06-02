package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Marca_Instrumento")
public class Marca_Instrumento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMarca_Instrumento;

	@Column (name="Marca_Instrumento", length=20,nullable=false)
	private String Marca_Instrumento;
	
	public Marca_Instrumento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Marca_Instrumento(int idMarca_Instrumento, String marca_Instrumento) {
		super();
		this.idMarca_Instrumento = idMarca_Instrumento;
		Marca_Instrumento = marca_Instrumento;
	}

	public int getIdMarca_Instrumento() {
		return idMarca_Instrumento;
	}

	public void setIdMarca_Instrumento(int idMarca_Instrumento) {
		this.idMarca_Instrumento = idMarca_Instrumento;
	}

	public String getMarca_Instrumento() {
		return Marca_Instrumento;
	}

	public void setMarca_Instrumento(String marca_Instrumento) {
		Marca_Instrumento = marca_Instrumento;
	}
	
}
