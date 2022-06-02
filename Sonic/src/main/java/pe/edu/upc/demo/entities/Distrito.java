package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Distrito")
public class Distrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CDistrito;
	
	@Column(name = "NDistrito", length = 48, nullable = false)
	private String NDistrito;

	public Distrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Distrito(int cDistrito, String nDistrito) {
		super();
		CDistrito = cDistrito;
		NDistrito = nDistrito;
	}

	public int getCDistrito() {
		return CDistrito;
	}

	public void setCDistrito(int cDistrito) {
		CDistrito = cDistrito;
	}

	public String getNDistrito() {
		return NDistrito;
	}

	public void setNDistrito(String nDistrito) {
		NDistrito = nDistrito;
	}
	
	
	
}
