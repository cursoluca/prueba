package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import beans.Cab_Factura;
import beans.Pos_Factura;
import interfaces.IPos_FacturaDao;

public class PosFacturaDao implements IPos_FacturaDao {

	private Connection con;
	public Statement sentencia;
	public ResultSet resultado;
	public PreparedStatement plantillaSQL;
	
	public PosFacturaDao(Connection con) {
		this.con = con;
	}
	
	@Override
	public Pos_Factura findbyId(int idFactura, int posFactura) {
		Pos_Factura posFactura1 = new Pos_Factura ();
		
		try {
			plantillaSQL = con.prepareStatement("Select * from pos_facturas where id_factura = ? and pos_facturas = ?");
			plantillaSQL.setInt(1, idFactura);
			plantillaSQL.setInt(2, posFactura);
			resultado = plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				posFactura1 = new Pos_Factura ();
				posFactura1.setIdFactura(resultado.getInt("id_factura"));
				posFactura1.setPosFactura(resultado.getInt("pos_facturas"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return posFactura1;
	}

	@Override
	public void add(Pos_Factura posFactura) {
		try {
			plantillaSQL = con.prepareStatement("insert into pos_facturas values (?,?,?,?)");
			plantillaSQL.setInt(1,posFactura.getIdFactura());
			plantillaSQL.setInt(2,posFactura.getPosFactura());
			plantillaSQL.setInt(3,posFactura.getIdProducto());
			plantillaSQL.setInt(4,posFactura.getCantidad());
			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void save(Pos_Factura posFactura) {
		
		try {
			plantillaSQL = con.prepareStatement("update pos_facturas set cantidad = ? where if_factura = ?");
			plantillaSQL.setInt(1, posFactura.getCantidad());
			plantillaSQL.setInt(2, posFactura.getIdFactura());
			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public Vector<Pos_Factura> list() {
		Vector<Pos_Factura> lista = new Vector<Pos_Factura>();
		
		try {
			plantillaSQL = con.prepareStatement("select * from pos_facturas");
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Pos_Factura aux = new Pos_Factura ();
				aux.setIdFactura(resultado.getInt("id_factura"));
				aux.setPosFactura(resultado.getInt("pos_factura"));
				aux.setIdProducto(resultado.getInt("id_producto"));
				aux.setCantidad(resultado.getInt("cantidad"));
				lista.add(aux);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return lista;
	}

	@Override
	public void delete(int posFactura) {
		try {
			plantillaSQL = con.prepareStatement("delete from pos_facturas where id_factura = ?");
			plantillaSQL.setInt(1, posFactura);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public Vector<Pos_Factura> buscarFactura(int numFactura) {
		Vector<Pos_Factura> lista = new Vector<Pos_Factura>();
		
		try {
			plantillaSQL = con.prepareStatement("select * from pos_facturas where id_factura = ?");
			plantillaSQL.setInt(1, numFactura);
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Pos_Factura aux = new Pos_Factura ();
				aux.setIdFactura(resultado.getInt("id_factura"));
				aux.setPosFactura(resultado.getInt("pos_facturas"));
				aux.setIdProducto(resultado.getInt("id_poducto"));
				aux.setCantidad(resultado.getInt("cantidad"));
				lista.add(aux);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return lista;
	}

}
