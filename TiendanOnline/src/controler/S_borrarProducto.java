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

import beans.Producto;
import beans.Producto_Cantidad;
import interfaces.IProductoService;
import services.ProductoService;

/**
 * Servlet implementation class S_borrarProducto
 */
@WebServlet("/S_borrarProducto")
public class S_borrarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_borrarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		boolean productoRepetido = false;
		String id_producto =(String)request.getParameter("id_producto");
		String siguientePagina = "Carrito.jsp";
		
		IProductoService productoService = new ProductoService ();
		Producto producto = productoService.buscarProducto(Integer.parseInt(id_producto));
		
		Vector<Producto_Cantidad> carrito =(Vector<Producto_Cantidad>) session.getAttribute("carrito");
		Producto_Cantidad productoCarrito = new Producto_Cantidad();
			
		for (Producto_Cantidad producto_Cantidad : carrito) {
			if (producto_Cantidad.getId_producto() == Integer.parseInt(id_producto)) {
				productoCarrito = producto_Cantidad;
			}
			if (producto_Cantidad.getId_producto() == Integer.parseInt(id_producto) && !productoRepetido && producto_Cantidad.getCantidad() > 1) {
				producto_Cantidad.setCantidad(producto_Cantidad.getCantidad()-1);
				productoRepetido = true;
				System.out.println(producto_Cantidad);
			}
		}
		
		if (!productoRepetido) {
			carrito.remove(productoCarrito);
			}
		
		session.setAttribute("carrito", carrito);
		
		RequestDispatcher rd = request.getRequestDispatcher(siguientePagina);
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
