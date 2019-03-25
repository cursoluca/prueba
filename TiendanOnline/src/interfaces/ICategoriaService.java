package interfaces;


import java.util.Vector;

import beans.Categoria;

public interface ICategoriaService {
	
public Vector<Categoria> listarCategorias ();
	
	public Categoria buscarCategoria (int idCategoria);
	
	public void borrarCategoria (int idCategoria);
	
	public void altaCategoria (Categoria categoria);
	
	public void modificarCategoria (Categoria categoria);

}
