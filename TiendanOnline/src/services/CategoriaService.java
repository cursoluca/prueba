package services;


import java.util.Vector;

import beans.Categoria;

import interfaces.ICategoriaDao;
import interfaces.ICategoriaService;
import util.TransactionManager;

public class CategoriaService implements ICategoriaService {

	
	@Override
	public Vector<Categoria> listarCategorias() {
		TransactionManager manager = new TransactionManager ();
		ICategoriaDao categoriaDao = manager.getCategoriaDao();
		Vector<Categoria> categorias = categoriaDao.list();
		manager.cerrarCocexion();
		return categorias;
	}

	@Override
	public Categoria buscarCategoria(int idCategoria) {
		Categoria categoria = null;
		
		TransactionManager manager = new TransactionManager ();
		ICategoriaDao categoriaDao = manager.getCategoriaDao();
		categoria = categoriaDao.findbyId(idCategoria);
		manager.cerrarCocexion();
		return categoria;
	}

	@Override
	public void borrarCategoria(int idCategoria) {
		TransactionManager manager = new TransactionManager ();
		ICategoriaDao categoriaDao = manager.getCategoriaDao();
		categoriaDao.delete(idCategoria);
		manager.cerrarCocexion();
		
	}

	@Override
	public void altaCategoria(Categoria categoria) {
		TransactionManager manager = new TransactionManager ();
		ICategoriaDao categoriaDao = manager.getCategoriaDao();
		categoriaDao.add(categoria);
		manager.cerrarCocexion();
	}

	@Override
	public void modificarCategoria(Categoria categoria) {
		TransactionManager manager = new TransactionManager ();
		ICategoriaDao categoriaDao = manager.getCategoriaDao();
		categoriaDao.save(categoria);
		manager.cerrarCocexion();
		
	}

}
