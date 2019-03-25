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
 * Servlet implementation class S_AddCarrito
 */
@WebServlet("/S_AddCarrito")
public class S_AddCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_AddCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		boolean repetido = false;
		String id_producto =(String)request.getParameter("id_producto");
		String siguientePagina = "productos.jsp";

		IProductoService productoService = new ProductoService ();
		Producto producto = productoService.buscarProducto(Integer.parseInt(id_producto));
		
		Producto_Cantidad productoCantidad = new Producto_Cantidad (producto.getId_producto(),producto.getId_categoria(),
				producto.getDescripcion(), producto.getPrecio(), producto.getStock(),producto ,1);
	
		Vector<Producto_Cantidad> carrito =(Vector<Producto_Cantidad>) session.getAttribute("carrito");
		
		
			for (Producto_Cantidad producto_Cantidad : carrito) {
				if (producto_Cantidad.getId_producto() == Integer.parseInt(id_producto) && !repetido) {
					producto_Cantidad.setCantidad(producto_Cantidad.getCantidad()+1);
					repetido = true;
					System.out.println(producto_Cantidad);
				}
			}
		
		
		if (!repetido) {
		carrito.add(productoCantidad);
		}
		
		session.setAttribute("carrito", carrito);
		String mensaje = producto.getDescripcion() + " introdudio al carro correctamente";
		request.setAttribute("mensaje", mensaje);
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
