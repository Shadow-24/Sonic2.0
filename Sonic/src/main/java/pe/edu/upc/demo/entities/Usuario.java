package pe.edu.upc.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Usuario", uniqueConstraints = @UniqueConstraint(columnNames = "NUserName"))
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CUsuario;

	@Column(name = "NUserName", nullable = false, unique = true)
	private String NUserName;

	@Column(name = "NNombre", length = 50, nullable = false)
	private String NNombre;

	@Column(name = "NApellido", length = 50, nullable = false)
	private String NApellido;

	@Column(name = "NumCelular", length = 9, nullable = false)
	private String NumCelular;

	@ManyToOne
	@JoinColumn(name = "idTipo_Usuario")
	private Tipo_Usuario tipo_user;

	@Column(name = "TCorreo", nullable = false)
	private String TCorreo;

	@Column(name = "NPassword", nullable = false)
	private String NPassword;

	@ManyToOne
	@JoinColumn(name = "CDistrito")
	private Distrito distrito;

	@Column(name = "TDireccion", length = 60, nullable = false)
	private String TDireccion;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Role> roles;

	public Usuario() {
		super();

		roles = new ArrayList<Role>();
	}

	public Tipo_Usuario getTipo_user() {
		return tipo_user;
	}

	public void setTipo_user(Tipo_Usuario tipo_user) {
		this.tipo_user = tipo_user;
	}

	public int getCUsuario() {
		return CUsuario;
	}

	public void setCUsuario(int cUsuario) {
		CUsuario = cUsuario;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
