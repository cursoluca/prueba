package interfaces;


import java.util.Vector;

import beans.Producto;

public interface IProductoService {
	
	public Producto buscarProducto (int id_producto);
	
	public void borrarProducto (int id_producto);
	
	public void altaProducto (Producto producto);
	
	public void modificarProducto (Producto producto);
	
	public Vector<Producto> listadoProductoDescripcion (String descripcion);
	
}
