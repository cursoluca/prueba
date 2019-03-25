package beans;

import excepciones.ExcepcionDomain;
import util.Validator;

public class Usuario {

	private String id_Usuario;
	private String email;
	private String password;
	
	public Usuario(String id_Usuario, String email, String password) {
		this.id_Usuario = id_Usuario;
		this.setEmail(email);
		this.password = password;
	}

	public Usuario(String id_Usuario) {
		this.id_Usuario = id_Usuario;
	}
	
	public Usuario() {
		
	}
	
	

	public String getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(String id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email)   {
		if (Validator.validarCorreo(email)) {
			this.email = email;
		} else {
			throw new ExcepcionDomain ("Correo introducido incorrectamente");
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id_Usuario=" + id_Usuario + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
	
	
}
