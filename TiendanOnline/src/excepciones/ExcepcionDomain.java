package excepciones;

public class ExcepcionDomain extends RuntimeException {

	private String mensaje;

	public ExcepcionDomain(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "ExcepcionDomain [mensaje=" + mensaje + "]";
	}
	
	
	
}
