package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tipo_Usuario")
public class Tipo_Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTipo_Usuario;

	@Column(name = "nameTipo_Usuario", length = 48, nullable = false)
	private String nameTipo_Usuario;

	public Tipo_Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipo_Usuario(int idTipo_Usuario, String nameTipo_Usuario) {
		super();
		this.idTipo_Usuario = idTipo_Usuario;
		this.nameTipo_Usuario = nameTipo_Usuario;
	}

	public int getIdTipo_Usuario() {
		return idTipo_Usuario;
	}

	public void setIdTipo_Usuario(int idTipo_Usuario) {
		this.idTipo_Usuario = idTipo_Usuario;
	}

	public String getNameTipo_Usuario() {
		return nameTipo_Usuario;
	}

	public void setNameTipo_Usuario(String nameTipo_Usuario) {
		this.nameTipo_Usuario = nameTipo_Usuario;
	}

}
