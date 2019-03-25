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

import beans.Categoria;
import beans.Producto;
import interfaces.ICategoriaService;
import interfaces.IProductoService;
import services.CategoriaService;
import services.ProductoService;

/**
 * Servlet implementation class S_categoria
 */
@WebServlet("/S_categoria")
public class S_categoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_categoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String siguientePagina;
		
		String descripcion =(String)request.getParameter("descripcion");
		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("producto", descripcion);
		siguientePagina = "productos.jsp";
		IProductoService productoService = new ProductoService ();
		Vector<Producto> productos = productoService.listadoProductoDescripcion(descripcion);
		session.setAttribute("productos", productos);
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
