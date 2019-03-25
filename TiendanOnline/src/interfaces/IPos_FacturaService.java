package interfaces;

import java.util.Vector;

import beans.Pos_Factura;

public interface IPos_FacturaService {

	public Pos_Factura buscarPosFactura (int idFactura, int posFactura);
	
	public void borrarPosFactura (int idFactura);
	
	public void altaPosFactura (Pos_Factura posFactura);
	
	public void modificarCabFactura (Pos_Factura posFactura);
	
	public Vector<Pos_Factura> buscarFactura (int numFactura); 
}
