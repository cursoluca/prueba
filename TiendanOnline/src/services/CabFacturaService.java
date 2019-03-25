package services;

import java.util.Vector;

import beans.Cab_Factura;
import beans.Categoria;
import interfaces.ICab_FacturaDao;
import interfaces.ICab_FacturaService;
import interfaces.ICategoriaDao;
import util.TransactionManager;

public class CabFacturaService implements ICab_FacturaService {




	@Override
	public Cab_Factura buscarCabFactura(int idFactura) {
		Cab_Factura cabFactura = null;
		
		TransactionManager manager = new TransactionManager ();
		ICab_FacturaDao CabFacturaDao = manager.getCabFacturaDao();
		cabFactura = CabFacturaDao.findbyId(idFactura);
		manager.cerrarCocexion();
		return cabFactura;
	}

	@Override
	public void borrarCabFactura(int idFactura) {
		TransactionManager manager = new TransactionManager ();
		ICab_FacturaDao CabFacturaDao = manager.getCabFacturaDao();
		CabFacturaDao.delete(idFactura);
		manager.cerrarCocexion();

	}

	@Override
	public void altaCabFactura(Cab_Factura cabFactura) {
		TransactionManager manager = new TransactionManager ();
		ICab_FacturaDao CabFacturaDao = manager.getCabFacturaDao();
		CabFacturaDao.add(cabFactura);
		manager.cerrarCocexion();
		
	}

	@Override
	public void modificarCabFactura(Cab_Factura cabFactura) {
		TransactionManager manager = new TransactionManager ();
		ICab_FacturaDao CabFacturaDao = manager.getCabFacturaDao();
		CabFacturaDao.save(cabFactura);
		manager.cerrarCocexion();
		
	}

	@Override
	public int ultimaFactura() {
		TransactionManager manager = new TransactionManager ();
		ICab_FacturaDao CabFacturaDao = manager.getCabFacturaDao();
		int factura = CabFacturaDao.ultimaFactura();
		manager.cerrarCocexion();
		return factura;
	}
	
	@Override
	public Vector<Cab_Factura> listarCabFactura() {
		TransactionManager manager = new TransactionManager ();
		ICab_FacturaDao CabFacturaDao = manager.getCabFacturaDao();
		Vector<Cab_Factura> cabFacturas = CabFacturaDao.list();
		manager.cerrarCocexion();
		return cabFacturas;
	}

	@Override
	public Vector<Cab_Factura> listarPorUsuario(String Usuario) {
		TransactionManager manager = new TransactionManager ();
		ICab_FacturaDao CabFacturaDao = manager.getCabFacturaDao();
		Vector<Cab_Factura> cabFacturas = CabFacturaDao.listarPorUsuario(Usuario);
		manager.cerrarCocexion();
		return cabFacturas;
	}


}
