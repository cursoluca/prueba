package services;


import java.util.Vector;

import beans.Producto;
import interfaces.IProductoDao;
import interfaces.IProductoService;
import util.TransactionManager;

public class ProductoService implements IProductoService {

	@Override
	public Producto buscarProducto(int id_producto) {
		Producto producto = null;
		
		TransactionManager manager = new TransactionManager ();
		IProductoDao productoDao = manager.getProductoDao();
		producto = productoDao.findbyId(id_producto);
		manager.cerrarCocexion();
		return producto;
	}

	@Override
	public void borrarProducto(int id_producto) {
		
		TransactionManager manager = new TransactionManager ();
		IProductoDao productoDao = manager.getProductoDao();
		productoDao.delete(id_producto);
		manager.cerrarCocexion();
	}

	@Override
	public void altaProducto(Producto producto) {

		TransactionManager manager = new TransactionManager ();
		IProductoDao productoDao = manager.getProductoDao();
		productoDao.add(producto);
		manager.cerrarCocexion();
	}

	@Override
	public void modificarProducto(Producto producto) {

		TransactionManager manager = new TransactionManager ();
		IProductoDao productoDao = manager.getProductoDao();
		productoDao.save(producto);
		manager.cerrarCocexion();
	}

	@Override
	public Vector<Producto> listadoProductoDescripcion(String descripcion) {
		Vector<Producto> lista = new Vector<Producto>();
		TransactionManager manager = new TransactionManager ();
		IProductoDao productoDao = manager.getProductoDao();
		lista = productoDao.list(descripcion);
		manager.cerrarCocexion();
		
		return lista;
	}

}
