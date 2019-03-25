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

import beans.Cab_Factura;
import interfaces.ICab_FacturaService;
import services.CabFacturaService;

/**
 * Servlet implementation class S_MostrarFacturas
 */
@WebServlet("/S_MostrarFacturas")
public class S_MostrarFacturas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_MostrarFacturas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		ICab_FacturaService cabFacturaService = new CabFacturaService ();
		
		boolean encontrado = false;
		String usuario = (String)session.getAttribute("usuario1");
		
		Vector<Cab_Factura> cabeceraFactura = cabFacturaService.listarPorUsuario(usuario);
		
		session.setAttribute("cabeceraFactura", cabeceraFactura);
		
		if (cabeceraFactura.size() == 0) {
			String mensaje ="Todavia no tienes ninguna factura en tu cuenta";
			request.setAttribute("facturas", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher("categorias.jsp");
			rd.forward(request, response);
		}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("Facturas.jsp");
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
