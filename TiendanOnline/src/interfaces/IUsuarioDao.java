package interfaces;

import java.util.Vector;

import beans.Usuario;
import util.TransactionManager;

public interface IUsuarioDao {

	public Usuario findbyId (String id_Usuario);
	public void add (Usuario usuario);
	public void save (Usuario usuario);
	public Vector<Usuario> list ();
	public void delete (String id_Usuario);
	public Vector<Usuario> list (String descripcionProducto);
	public Vector<Usuario> UsuarioCompranMoviles ();
	
	
}
