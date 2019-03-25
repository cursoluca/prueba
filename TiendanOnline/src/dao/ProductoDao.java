package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import beans.Producto;
import interfaces.IProductoDao;

public class ProductoDao implements IProductoDao {

	private Connection con;
	public Statement sentencia;
	public ResultSet resultado;
	public PreparedStatement plantillaSQL;
	
	
	public ProductoDao(Connection con) {
		this.con = con;
	}

	@Override
	public Producto findbyId(int id_producto) {
			Producto producto = null;
		try {
			plantillaSQL = con.prepareStatement("Select * from productos where id_productos = ?");
			plantillaSQL.setInt(1, id_producto);
			resultado = plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				producto = new Producto ();
				producto.setId_producto(resultado.getInt("id_productos"));
				producto.setId_categoria(resultado.getInt("id_categoria"));
				producto.setDescripcion(resultado.getString("descripcion"));
				producto.setPrecio(resultado.getInt("precio"));
				producto.setStock(resultado.getInt("stock"));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return producto;
	
	}

	@Override
	public void add(Producto producto) {
		
		try {
			plantillaSQL = con.prepareStatement("insert into productos values (?,?,?,?,?)");
			plantillaSQL.setInt(1,producto.getId_producto());
			plantillaSQL.setInt(2,producto.getId_categoria());
			plantillaSQL.setString(3, producto.getDescripcion());
			plantillaSQL.setInt(4, producto.getPrecio());
			plantillaSQL.setInt(5, producto.getStock());
			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void save(Producto producto) {
		
		try {
			plantillaSQL = con.prepareStatement("update productos set id_categoria = ?, descripcion = ? , precio = ?"
					+ " , stock = ? where id_productos = ?");
			plantillaSQL.setInt(1,producto.getId_categoria());
			plantillaSQL.setString(2, producto.getDescripcion());
			plantillaSQL.setInt(3, producto.getPrecio());
			plantillaSQL.setInt(4, producto.getStock());
			plantillaSQL.setInt(5,producto.getId_producto());
			plantillaSQL.execute();
			
			System.out.println(plantillaSQL.toString());
		} catch (Exception e) {
			System.out.println(e);
			
		}


	}

	@Override
	public Vector<Producto> list() {

		Vector<Producto> lista = new Vector<Producto>();
		try {
			plantillaSQL = con.prepareStatement("select * from productos");
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Producto producto = new Producto ();
				producto.setId_producto(resultado.getInt("id_producto"));
				producto.setId_categoria(resultado.getInt("id_categoria"));
				producto.setDescripcion(resultado.getString("descripcion"));
				producto.setPrecio(resultado.getInt("precio"));
				producto.setStock(resultado.getInt("stock"));
				lista.add(producto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return lista;
	}

	@Override
	public void delete(int id_producto) {

		try {
			plantillaSQL = con.prepareStatement("delete from productos where id_productos = ?");
			plantillaSQL.setInt(1, id_producto);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public Vector<Producto> list(String descripcionCategoria) {
		
		Vector<Producto> lista = new Vector<Producto>();
		try {
			plantillaSQL = con.prepareStatement("select p.descripcion , p.precio , p.stock , p.id_productos\r\n " + 
					"from productos p " + 
					"inner join categorias c on c.idCategoria = p.id_categoria where c.descripcion = ? ;");
			plantillaSQL.setString(1, descripcionCategoria);
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Producto producto = new Producto ();
				producto.setDescripcion(resultado.getString(1));
				producto.setPrecio(resultado.getInt(2));
				producto.setStock(resultado.getInt(3));
				producto.setId_producto(resultado.getInt(4));
				lista.add(producto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return lista;
	}
	
	

}
