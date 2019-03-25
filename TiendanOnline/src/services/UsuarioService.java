package services;

import java.util.Vector;

import beans.Producto;
import beans.Usuario;
import interfaces.IProductoDao;
import interfaces.IUsuarioDao;
import interfaces.IUsuariosService;
import util.TransactionManager;

public class UsuarioService implements IUsuariosService {

	@Override
	public Vector<Usuario> listarUsuarios() {
		TransactionManager manager = new TransactionManager ();
		IUsuarioDao usuarioDao = manager.getUsuarioDao();
		Vector<Usuario> usuarios = usuarioDao.list();
		manager.cerrarCocexion();
		return usuarios;
	}

	@Override
	public Usuario buscarUsuario(String id_usuario) {
		TransactionManager manager = new TransactionManager ();
		IUsuarioDao usuarioDao = manager.getUsuarioDao();
		Usuario usuario = usuarioDao.findbyId(id_usuario);
		manager.cerrarCocexion();
		return usuario;
	}

	@Override
	public void borrarUsuario(String id_usuario) {
		TransactionManager manager = new TransactionManager ();
		IUsuarioDao usuarioDao = manager.getUsuarioDao();
		usuarioDao.delete(id_usuario);
		manager.cerrarCocexion();
		
	}

	@Override
	public void altaUsuario(Usuario usuario) {
		TransactionManager manager = new TransactionManager ();
		IUsuarioDao usuarioDao = manager.getUsuarioDao();
		usuarioDao.add(usuario);
		manager.cerrarCocexion();
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		TransactionManager manager = new TransactionManager ();
		IUsuarioDao usuarioDao = manager.getUsuarioDao();
		usuarioDao.save(usuario);
		manager.cerrarCocexion();
	}
	
	public Vector<Usuario> listadoUsuariosCompraronUnProducto(String descripcion) {
		Vector<Usuario> lista = new Vector<Usuario>();
		TransactionManager manager = new TransactionManager ();
		IUsuarioDao usuarioDao = manager.getUsuarioDao();
		lista = usuarioDao.list(descripcion);
		manager.cerrarCocexion();
		
		return lista;
	}

	@Override
	public Vector<Usuario> UsuariosCompranMoviles() {
		Vector<Usuario> lista = new Vector<Usuario>();
		TransactionManager manager = new TransactionManager ();
		IUsuarioDao usuarioDao = manager.getUsuarioDao();
		lista = usuarioDao.UsuarioCompranMoviles();
		manager.cerrarCocexion();
		
		return lista;
		
	}

}
