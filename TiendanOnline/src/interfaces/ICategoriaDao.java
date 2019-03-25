package interfaces;


import java.util.Vector;

import beans.Categoria;

public interface ICategoriaDao {


	public Categoria findbyId (int id_Usuario);
	public void add (Categoria categoria);
	public void save (Categoria categoria);
	public Vector<Categoria> list ();
	public void delete (int idCategoria);
}
