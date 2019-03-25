package controler;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Pos_Factura;
import beans.Producto;
import beans.Producto_Cantidad;
import interfaces.ICab_FacturaService;
import interfaces.IPos_FacturaService;
import interfaces.IProductoService;
import services.CabFacturaService;
import services.PosFacturaService;
import services.ProductoService;

/**
 * Servlet implementation class S_mostrarFacturaDetallada
 */
@WebServlet("/S_mostrarFacturaDetallada")
public class S_mostrarFacturaDetallada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_mostrarFacturaDetallada() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		IPos_FacturaService posFacturaService = new PosFacturaService ();
		IProductoService productoService = new ProductoService ();
		String numFactura =(String)request.getParameter("id_factura");
		request.setAttribute("idFactura", numFactura);
		
		Vector<Pos_Factura> productosFactura = posFacturaService.buscarFactura(Integer.parseInt(numFactura));
		Vector<Producto_Cantidad> productosFactura1 = new Vector<Producto_Cantidad> ();
	
		for (Pos_Factura pos_Factura : productosFactura) {
			Producto_Cantidad productos = new Producto_Cantidad ();
			Producto producto = new Producto();
			producto = productoService.buscarProducto(pos_Factura.getIdProducto());
			productos.setDescripcion(producto.getDescripcion());
			productos.setPrecio(producto.getPrecio());
			productos.setCantidad(pos_Factura.getCantidad());
			productosFactura1.add(productos);
		}
		
		
		request.setAttribute("productosFactura", productosFactura1);
		
		RequestDispatcher rd = request.getRequestDispatcher("ProductosFactura.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
