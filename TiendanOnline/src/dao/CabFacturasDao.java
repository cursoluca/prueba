package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import beans.Cab_Factura;
import interfaces.ICab_FacturaDao;

public class CabFacturasDao implements ICab_FacturaDao {

	private Connection con;
	public Statement sentencia;
	public ResultSet resultado;
	public PreparedStatement plantillaSQL;
	
	
	public CabFacturasDao(Connection con) {
		this.con = con;
	}
	
	@Override
	public Cab_Factura findbyId(int id_Factura) {
		Cab_Factura cabeceraFactura = null;
		
		try {
			plantillaSQL = con.prepareStatement("Select * from cab_facturas where id_factura = ?");
			plantillaSQL.setInt(1, id_Factura);
			resultado = plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				cabeceraFactura = new Cab_Factura ();
				cabeceraFactura.setIdFactura(resultado.getInt("id_factura"));
				cabeceraFactura.setIdUsuario(resultado.getString("id_usuario"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return cabeceraFactura;
		
	}

	@Override
	public void add(Cab_Factura cabeceraFactura) {
		try {
			plantillaSQL = con.prepareStatement("insert into cab_facturas values (?,?)");
			plantillaSQL.setInt(1,cabeceraFactura.getIdFactura());
			plantillaSQL.setString(2,cabeceraFactura.getIdUsuario());
			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void save(Cab_Factura cabeceraFactura) {
		
		try {
			plantillaSQL = con.prepareStatement("update cab_facturas set id_factura = ? where id_usuario = ?");
			plantillaSQL.setInt(1,cabeceraFactura.getIdFactura());
			plantillaSQL.setString(2, cabeceraFactura.getIdUsuario());
			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());
		} catch (Exception e) {
			System.out.println(e);
		}

	}


	@Override
	public Vector<Cab_Factura> list() {
		
		Vector<Cab_Factura> lista = new Vector<Cab_Factura>();
		
		try {
			plantillaSQL = con.prepareStatement("select * from cab_facturas");
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Cab_Factura aux = new Cab_Factura ();
				aux.setIdFactura(resultado.getInt("id_factura"));
				aux.setIdUsuario(resultado.getString("id_usuario"));
				lista.add(aux);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return lista;
	}

	@Override
	public void delete(int cabeceraFactura) {
		try {
			plantillaSQL = con.prepareStatement("delete from cab_facturas where id_factura = ?");
			plantillaSQL.setInt(1, cabeceraFactura);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public int ultimaFactura() {
		int ultimaFactura = 0;
		
		try {
			plantillaSQL = con.prepareStatement("SELECT max(id_factura) FROM curso.cab_facturas;");
			System.out.println(plantillaSQL.toString());
			resultado=plantillaSQL.executeQuery();
			while(resultado.next()) {
				ultimaFactura = resultado.getInt("max(id_factura)");
			}
			
		} catch (Exception e) {
			
		}
	
		return ultimaFactura;
	}
	
	@Override
	public Vector<Cab_Factura> listarPorUsuario(String usuario) {
		
		Vector<Cab_Factura> lista = new Vector<Cab_Factura>();
		
		try {
			plantillaSQL = con.prepareStatement("select * from cab_facturas where id_usuario = ?");
			plantillaSQL.setString(1, usuario);
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Cab_Factura aux = new Cab_Factura ();
				aux.setIdFactura(resultado.getInt("id_factura"));
				aux.setIdUsuario(resultado.getString("id_usuario"));
				lista.add(aux);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return lista;
	}


}
