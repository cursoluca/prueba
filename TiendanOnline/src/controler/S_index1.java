package controler;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JCheckBox;

import beans.Categoria;
import beans.Producto;
import beans.Producto_Cantidad;
import beans.Usuario;
import interfaces.ICategoriaService;
import interfaces.IUsuariosService;
import services.CategoriaService;
import services.ProductoService;
import services.UsuarioService;

/**
 * Servlet implementation class S_index
 */
@WebServlet("/S_index1")
public class S_index1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_index1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Vector<Producto_Cantidad> carrito = new Vector<Producto_Cantidad> ();
		
		String siguientePagina;
		String idUsuario =(String)request.getParameter("idusuario");
		String password = (String)request.getParameter("password");
		String mensaje ="";
		HttpSession session = request.getSession(true);
		session.setAttribute("carrito", carrito);
		IUsuariosService usuarioService = new UsuarioService ();
		Usuario aux  = new Usuario (idUsuario);
		aux = usuarioService.buscarUsuario(idUsuario);
		
		request.setAttribute("usuario", idUsuario);
		
		if (aux == null) {
			mensaje = "Usuario y contraseña introducidos incorrectamente";
			siguientePagina = "index.jsp";
			request.setAttribute("mensaje", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher(siguientePagina);
			rd.forward(request, response);
		
		} else {
			if (password.equals(aux.getPassword())) {
				String recordar = request.getParameter("recordar");
				if (recordar == null) {
					recordar = "";
				}
				
				if (recordar.equals("recordar")) {
					Cookie cusuario = new Cookie ("usuario",idUsuario);
					Cookie cpassword = new Cookie ("password",password);
					
					cusuario.setMaxAge(3600);
					cpassword.setMaxAge(3600);
				
					response.addCookie(cusuario);
					response.addCookie(cpassword);
				}
				
				siguientePagina = "categorias.jsp";
				ICategoriaService categoriaService = new CategoriaService ();
				Vector<Categoria> categorias = categoriaService.listarCategorias();
				session.setAttribute("categorias", categorias);
				session.setAttribute("usuario1", idUsuario);
				RequestDispatcher rd = request.getRequestDispatcher(siguientePagina);
				rd.forward(request, response);
			} else {
				mensaje = "Usuario y contraseña introducidos incorrectamente";
				siguientePagina = "index.jsp";
				request.setAttribute("mensaje", mensaje);
				RequestDispatcher rd = request.getRequestDispatcher(siguientePagina);
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
