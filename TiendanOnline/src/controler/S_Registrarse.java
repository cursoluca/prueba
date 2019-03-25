package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Usuario;
import excepciones.ExcepcionDomain;
import interfaces.IUsuariosService;
import services.UsuarioService;

/**
 * Servlet implementation class S_Registrarse
 */
@WebServlet("/S_Registrarse")
public class S_Registrarse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_Registrarse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String mensaje = "";
		boolean error = false;
		
		//meto en variables todos los datos que se reciben en desde la página registro.jsp
		String siguientePagina;
		String idUsuario =request.getParameter("idusuario");
		String password = (String)request.getParameter("password");
		String email = (String)request.getParameter("email");
		String passwordRepetida =  (String)request.getParameter("password1");
		
		//Miro si los tres datos estan rellenos y no estan vacios
		if (idUsuario.equals("")) {
			mensaje+= "\n" +"Id de usuario vacio" + "\n";
			error = true;
		}
		
		if (password.equals("")) {
			mensaje+= "\n" + "contraseña vacia" + "\n";
			error = true;
		}
		
		if (email.equals("")) {
			mensaje+= "\n" + "email vacio" + "\n";
			error = true;
		}
		
		//creo dos usuario un auxiliar a null y un usuario normal para despues verificar los datos
		Usuario aux= null;
		Usuario usuario = new Usuario();
		IUsuariosService usuarioService = new UsuarioService ();
		
		//devulvo los datos que hemos recibido para que luego salgan en pantalla
		request.setAttribute("usuario", idUsuario);
		request.setAttribute("password", password);
		request.setAttribute("email", email);
		
		/*
		 * Si no hemos encontrado ningun error (no hay campos vacios) entramos en el if y validamos los datos 
		 */
		if (!error) {
			try {
				usuario = new Usuario (idUsuario,email,password);
				aux = usuarioService.buscarUsuario(usuario.getId_Usuario());
			}catch (ExcepcionDomain e){
				mensaje = "correo introducido incorrectamente";
				siguientePagina = "registro.jsp";
				request.setAttribute("mensaje", mensaje);
				RequestDispatcher rd = request.getRequestDispatcher(siguientePagina);
				rd.forward(request, response);
			}
		}
		
		//si encontramos un error aqui nos manda a la página 
		if(error) {
			siguientePagina = "registro.jsp";
			request.setAttribute("mensaje", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher(siguientePagina);
			rd.forward(request, response);
		}
		
		
		// si el usuario aux es null y  no hay errores miro si las dos contraseñas son iguales si no es null es que el usuario ya existe
		if (aux == null && !error) {
			if (password.equals(passwordRepetida)) {
				mensaje+= "Usuario insertado correctamente";
				siguientePagina = "index.jsp";
				usuarioService.altaUsuario(usuario);
				request.setAttribute("mensaje", mensaje);
				RequestDispatcher rd = request.getRequestDispatcher(siguientePagina);
				rd.forward(request, response);
			} else {
				mensaje+= "La contraseña no es la misma";
				siguientePagina = "registro.jsp";
				request.setAttribute("mensaje", mensaje);
				RequestDispatcher rd = request.getRequestDispatcher(siguientePagina);
				rd.forward(request, response);
			}
			
		}else {
			mensaje+= "Id de usuario ya existente";
			siguientePagina = "registro.jsp";
			request.setAttribute("mensaje", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher(siguientePagina);
			rd.forward(request, response);
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
