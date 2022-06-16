package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Dueño")
public class Dueño {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CDueño;
	
	@Column(name = "NUserName", length = 50, nullable = false)
	private String NUserName;

	@Column(name = "NNombre", length = 50, nullable = false)
	private String NNombre;

	@Column(name = "NApellido", length = 50, nullable = false)
	private String NApellido;

	@Column(name = "NumCelular", length = 9, nullable = false)
	private String NumCelular;

	@Column(name = "TCorreo", length = 50, nullable = false)
	private String TCorreo;

	@Column(name = "NPassword", length = 50, nullable = false)
	private String NPassword;
	
	

	public Dueño() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Dueño(int cDueño, String nUserName, String nNombre, String nApellido, String numCelular, String tCorreo,
			String nPassword) {
		super();
		CDueño = cDueño;
		NUserName = nUserName;
		NNombre = nNombre;
		NApellido = nApellido;
		NumCelular = numCelular;
		TCorreo = tCorreo;
		NPassword = nPassword;
	}



	public int getCDueño() {
		return CDueño;
	}



	public void setCDueño(int cDueño) {
		CDueño = cDueño;
	}



	public String getNUserName() {
		return NUserName;
	}



	public void setNUserName(String nUserName) {
		NUserName = nUserName;
	}



	public String getNNombre() {
		return NNombre;
	}



	public void setNNombre(String nNombre) {
		NNombre = nNombre;
	}



	public String getNApellido() {
		return NApellido;
	}



	public void setNApellido(String nApellido) {
		NApellido = nApellido;
	}



	public String getNumCelular() {
		return NumCelular;
	}



	public void setNumCelular(String numCelular) {
		NumCelular = numCelular;
	}



	public String getTCorreo() {
		return TCorreo;
	}



	public void setTCorreo(String tCorreo) {
		TCorreo = tCorreo;
	}



	public String getNPassword() {
		return NPassword;
	}



	public void setNPassword(String nPassword) {
		NPassword = nPassword;
	}

	
	
}
