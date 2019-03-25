package beans;

public class Producto {

	protected int id_producto;
	protected int id_categoria;
	protected String descripcion;
	protected int precio;
	protected int stock;
	
	public Producto(int id_producto, int id_categoria, String descripcion, int precio, int stock) {
		this.id_producto = id_producto;
		this.id_categoria = id_categoria;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}

	public Producto() {
		
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Productos [id_producto=" + id_producto + ", id_categoria=" + id_categoria + ", descripcion="
				+ descripcion + ", precio=" + precio + ", stock=" + stock + "]";
	}
	
	
	
	
	
	
}
