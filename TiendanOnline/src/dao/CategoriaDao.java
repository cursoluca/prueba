package dao;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import beans.Categoria;
import interfaces.ICategoriaDao;

public class CategoriaDao implements ICategoriaDao {

	private Connection con;
	public Statement sentencia;
	public ResultSet resultado;
	public PreparedStatement plantillaSQL;
	
	public CategoriaDao(Connection con) {
		this.con = con;
	}

	@Override
	public Categoria findbyId(int idCategoria) {
		Categoria categoria = null;
		
		try {
			plantillaSQL = con.prepareStatement("Select * from categorias where idcategoria = ?");
			plantillaSQL.setInt(1, idCategoria);
			resultado = plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				categoria = new Categoria ();
				categoria.setIdCategoria(resultado.getInt("idcategoria"));
				categoria.setDescripcion(resultado.getString("descripcion"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return categoria;
	}

	@Override
	public void add(Categoria categoria) {
		try {
			plantillaSQL = con.prepareStatement("insert into categorias values (?,?)");
			plantillaSQL.setInt(1,categoria.getIdCategoria());
			plantillaSQL.setString(2,categoria.getDescripcion());
			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());
		} catch (Exception e) {
			System.out.println(e);
		}


	}

	@Override
	public void save(Categoria categoria) {
		
		try {
			plantillaSQL = con.prepareStatement("update categorias set descripcion = ? where idcategoria = ?");
			plantillaSQL.setString(1, categoria.getDescripcion());
			plantillaSQL.setInt(2, categoria.getIdCategoria());
			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public Vector<Categoria> list() {
		
		Vector<Categoria> lista = new Vector<Categoria>();
		try {
			plantillaSQL = con.prepareStatement("select * from categorias");
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Categoria aux = new Categoria ();
				aux.setIdCategoria(resultado.getInt("idcategoria"));
				aux.setDescripcion(resultado.getString("descripcion"));
				lista.add(aux);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return lista;
	}

	@Override
	public void delete(int idCategoria) {
		try {
			plantillaSQL = con.prepareStatement("delete from categorias where idcategoria = ?");
			plantillaSQL.setInt(1, idCategoria);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
