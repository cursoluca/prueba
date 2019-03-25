package beans;

public class Cab_Factura {

	private int idFactura;
	private String idUsuario;
	
	public Cab_Factura( String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Cab_Factura() {
		
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Cab_Facturas [idFactura=" + idFactura + ", idUsuario=" + idUsuario + "]";
	}
	
	
	
	
	
}
