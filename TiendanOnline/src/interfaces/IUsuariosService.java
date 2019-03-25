package interfaces;

import java.util.Vector;

import beans.Usuario;

public interface IUsuariosService {

	public Vector<Usuario> listarUsuarios ();
	
	public Usuario buscarUsuario (String id_usuario);
	
	public void borrarUsuario (String id_usuario);
	
	public void altaUsuario (Usuario usuario);
	
	public void modificarUsuario (Usuario usuario);
	
	public Vector<Usuario> listadoUsuariosCompraronUnProducto(String descripcion);
	
	public Vector<Usuario> UsuariosCompranMoviles ();
	
	
}
