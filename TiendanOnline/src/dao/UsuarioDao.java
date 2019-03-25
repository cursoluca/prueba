package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import beans.Usuario;
import interfaces.IUsuarioDao;

public class UsuarioDao implements IUsuarioDao {

	private Connection con;
	public Statement sentencia;
	public ResultSet resultado;
	public PreparedStatement plantillaSQL;
	
	
	
	public UsuarioDao(Connection con) {
		this.con = con;
	}

	@Override
	public Usuario findbyId(String id_Usuario) {
		Usuario usuario = null;
		
		try {
			plantillaSQL = con.prepareStatement("select * from usuarios where id_usuario = ?");
			plantillaSQL.setString(1, id_Usuario);
			resultado = plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			
			if (resultado.next()) {
				usuario = new Usuario();
				usuario.setEmail(resultado.getString("email"));
				usuario.setId_Usuario(resultado.getString("id_usuario"));
				usuario.setPassword(resultado.getString("password"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return usuario;
	}

	@Override
	public void add(Usuario usuario) {
		try {
			plantillaSQL = con.prepareStatement("insert into usuarios values (?,?,?)");
			plantillaSQL.setString(1,usuario.getId_Usuario());
			plantillaSQL.setString(2,usuario.getEmail());
			plantillaSQL.setString(3,usuario.getPassword());
			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());
		} catch (Exception e) {
			System.out.println(e);
		}


	}

	@Override
	public void save(Usuario usuario) {

		try {
			plantillaSQL = con.prepareStatement("update usuarios set email= ? , password = ?"
					+ "where id_usuario = ?");
			plantillaSQL.setString(1, usuario.getEmail());
			plantillaSQL.setString(2, usuario.getPassword());
			plantillaSQL.setString(3, usuario.getId_Usuario());
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Vector<Usuario> list() {

		Vector<Usuario> lista = new Vector<Usuario>();
		try {
			plantillaSQL = con.prepareStatement("select * from usuarios");
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Usuario aux = new Usuario ();
				aux.setId_Usuario(resultado.getString("id_usuario"));
				aux.setEmail(resultado.getString("email"));
				aux.setPassword(resultado.getString("password"));
				lista.add(aux);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return lista;
	}

	@Override
	public void delete(String id_usuario) {
		
		try {
			plantillaSQL = con.prepareStatement("delete from usuarios where id_usuario = ?");
			plantillaSQL.setString(1, id_usuario);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public Vector<Usuario> list(String descripcionProducto) {
		
		Vector<Usuario> lista = new Vector<Usuario>();
		try {
			plantillaSQL = con.prepareStatement("select u.id_usuario " +
					"from productos p  inner join pos_facturas pf " +
					"on p.id_productos = pf.id_poducto " +
					"inner join cab_facturas cf " +
					"on pf.id_factura = cf.id_factura " +
					"inner join usuarios u " +
					"on u.id_usuario = cf.id_usuario where p.descripcion = ?");
			plantillaSQL.setString(1, descripcionProducto);
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Usuario aux = new Usuario ();
				aux.setId_Usuario(resultado.getString(1));
				lista.add(aux);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return lista;
	}

	@Override
	public Vector<Usuario> UsuarioCompranMoviles() {
		Vector<Usuario> lista = new Vector<Usuario>();
		try {
			plantillaSQL = con.prepareStatement("select distinct u.id_usuario\r\n" + 
					"from productos p " + 
					"inner join pos_facturas pf " + 
					"on p.id_productos = pf.id_poducto " + 
					"inner join cab_facturas cf " + 
					"on pf.id_factura = cf.id_factura " + 
					"inner join usuarios u " + 
					"on u.id_usuario = cf.id_usuario " + 
					"inner join categorias c " + 
					"on c.idCategoria = p.id_categoria " + 
					"where c.descripcion = 'moviles';");
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Usuario aux = new Usuario ();
				aux.setId_Usuario(resultado.getString(1));
				lista.add(aux);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return lista;
	}

}
