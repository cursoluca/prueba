package beans;

public class Pos_Factura {

	private int idFactura;
	private int posFactura;
	private int IdProducto;
	private int cantidad;
	
	public Pos_Factura(int idFactura, int posFactura, int idProducto, int cantidad) {
		this.idFactura = idFactura;
		this.posFactura = posFactura;
		this.IdProducto = idProducto;
		this.cantidad = cantidad;
	}

	public Pos_Factura() {
		super();
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getPosFactura() {
		return posFactura;
	}

	public void setPosFactura(int posFactura) {
		this.posFactura = posFactura;
	}

	public int getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Pos_Factura [idFactura=" + idFactura + ", posFactura=" + posFactura + ", IdProducto=" + IdProducto
				+ ", cantidad=" + cantidad + "]";
	}
	
	
	
	
}
