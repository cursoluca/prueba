package util;

import java.sql.Connection;

import dao.CabFacturasDao;
import dao.CategoriaDao;
import dao.PosFacturaDao;
import dao.ProductoDao;
import dao.UsuarioDao;
import interfaces.ICab_FacturaDao;
import interfaces.ICategoriaDao;
import interfaces.IPos_FacturaDao;
import interfaces.IProductoDao;
import interfaces.IUsuarioDao;


public class TransactionManager {
	
	private Connection con;

	public TransactionManager() {
		this.con = conexionBBDD.conexionBBDD();
	}
	
	public ICategoriaDao getCategoriaDao () {
		return new CategoriaDao(con);
	}

	public void cerrarCocexion () {
		conexionBBDD.desconexionBBDD();
	}
	
	public IProductoDao getProductoDao () {
		return new ProductoDao(con);
	}
		
	public IUsuarioDao getUsuarioDao () {
		return new UsuarioDao(con);
	}
	
	public ICab_FacturaDao getCabFacturaDao () {
		return new CabFacturasDao(con);
	}
	
	public IPos_FacturaDao getPosFacturaDao () {
		return new PosFacturaDao(con);
	}
}
