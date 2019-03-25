package interfaces;

import java.util.Vector;

import beans.Pos_Factura;

public interface IPos_FacturaDao {

	public Pos_Factura findbyId (int idFactura, int posFactura);
	public void add (Pos_Factura posFactura);
	public void save (Pos_Factura posFactura);
	public Vector<Pos_Factura> list ();
	public void delete (int posFactura);
	public Vector<Pos_Factura> buscarFactura (int numFactura); 
}
