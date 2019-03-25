package services;

import java.util.Vector;

import beans.Pos_Factura;
import interfaces.IPos_FacturaDao;
import interfaces.IPos_FacturaService;
import util.TransactionManager;

public class PosFacturaService implements IPos_FacturaService {

	@Override
	public Pos_Factura buscarPosFactura(int idFactura, int posFactura) {
		Pos_Factura cabFactura = null;
		
		TransactionManager manager = new TransactionManager ();
		IPos_FacturaDao PosFacturaDao = manager.getPosFacturaDao();
		cabFactura = PosFacturaDao.findbyId(idFactura, posFactura);
		manager.cerrarCocexion();
		return cabFactura;
	}

	@Override
	public void borrarPosFactura(int idFactura) {

		TransactionManager manager = new TransactionManager ();
		IPos_FacturaDao PosFacturaDao = manager.getPosFacturaDao();
		PosFacturaDao.delete(idFactura);
		manager.cerrarCocexion();
	}

	@Override
	public void altaPosFactura(Pos_Factura posFactura) {
	
		TransactionManager manager = new TransactionManager ();
		IPos_FacturaDao PosFacturaDao = manager.getPosFacturaDao();
		PosFacturaDao.add(posFactura);
		manager.cerrarCocexion();

	}

	@Override
	public void modificarCabFactura(Pos_Factura posFactura) {
		
		TransactionManager manager = new TransactionManager ();
		IPos_FacturaDao PosFacturaDao = manager.getPosFacturaDao();
		PosFacturaDao.save(posFactura);
		manager.cerrarCocexion();
	}

	@Override
	public Vector<Pos_Factura> buscarFactura(int numFactura) {
		
		TransactionManager manager = new TransactionManager ();
		IPos_FacturaDao PosFacturaDao = manager.getPosFacturaDao();
		Vector<Pos_Factura> prodructosFactura = PosFacturaDao.buscarFactura(numFactura);
		manager.cerrarCocexion();
		return prodructosFactura;
	}



}
