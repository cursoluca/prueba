package interfaces;

import java.util.Vector;

import beans.Cab_Factura;


public interface ICab_FacturaService {

	public Cab_Factura buscarCabFactura (int idFactura);
	
	public void borrarCabFactura (int idFactura);
	
	public void altaCabFactura (Cab_Factura cabFactura);
	
	public void modificarCabFactura (Cab_Factura cabFactura);
	
	public int ultimaFactura();
	
	public Vector<Cab_Factura> listarCabFactura();
	
	public Vector<Cab_Factura> listarPorUsuario(String Usuario);
}
