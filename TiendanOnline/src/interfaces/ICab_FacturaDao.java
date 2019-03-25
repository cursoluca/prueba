package interfaces;

import java.util.Vector;

import beans.Cab_Factura;


public interface ICab_FacturaDao {

	public Cab_Factura findbyId (int id_Factura);
	public void add (Cab_Factura cabeceraFactura);
	public void save (Cab_Factura cabeceraFactura);
	public Vector<Cab_Factura> list ();
	public void delete (int idCabeceraFactura);
	public int ultimaFactura ();
	public Vector<Cab_Factura> listarPorUsuario(String Usuario);
	
}
