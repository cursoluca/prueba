package beans;

public class Producto_Cantidad extends Producto {

	private Producto producto;
	private int cantidad;
	
	public Producto_Cantidad(int id_producto, int id_categoria, String descripcion, int precio, int stock,
			Producto producto, int cantidad) {
		super(id_producto, id_categoria, descripcion, precio, stock);
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public Producto_Cantidad() {
		super();
		;
	}
	

	public Producto_Cantidad(int id_producto, int id_categoria, String descripcion, int precio, int stock) {
		super(id_producto, id_categoria, descripcion, precio, stock);
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "producto_Cantidad [producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	
	
	
	
}
