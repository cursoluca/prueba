package controler;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import beans.Cab_Factura;
import beans.Pos_Factura;
import beans.Producto;
import beans.Producto_Cantidad;
import interfaces.ICab_FacturaService;
import interfaces.IPos_FacturaService;
import interfaces.IProductoService;
import services.CabFacturaService;
import services.PosFacturaService;
import services.ProductoService;

import static j2html.TagCreator.*;

/**
 * Servlet implementation class S_realizarCompra
 */
@WebServlet("/S_realizarCompra")
public class S_realizarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_realizarCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		IProductoService productoService = new ProductoService ();
		IPos_FacturaService posFacturaService = new PosFacturaService ();
		ICab_FacturaService cabFacturaService = new CabFacturaService ();
		Producto producto;
		String usuario;
		String mensaje = "Compra realizada con exito, muchas gracias por su compra";
		
	
		Vector<Producto_Cantidad> carrito =(Vector<Producto_Cantidad>) session.getAttribute("carrito");
		
		usuario = (String)session.getAttribute("usuario1");
		
		Cab_Factura cabFactura = new Cab_Factura (usuario);
		cabFacturaService.altaCabFactura(cabFactura);
		
		int idfactura = cabFacturaService.ultimaFactura();
		int posicionProductoFactura = 1;
		
		if (carrito.size() == 0) {
			String mensaje1 = "El carrito está vacio";
			request.setAttribute("carritovacio", mensaje1);
			RequestDispatcher rd = request.getRequestDispatcher("Carrito.jsp");
			rd.forward(request, response);
		}
		
		
		for (Producto_Cantidad producto_Cantidad : carrito) {
			producto = producto_Cantidad.getProducto();
			producto.setStock(producto.getStock() - producto_Cantidad.getCantidad() );
			productoService.modificarProducto(producto);
			Pos_Factura posfactura = new Pos_Factura(idfactura,posicionProductoFactura,producto_Cantidad.getId_producto(),producto_Cantidad.getCantidad());
			posFacturaService.altaPosFactura(posfactura);
			posicionProductoFactura++;
			}
	
		usuario = (String)session.getAttribute("usuario1");

	

		String html = "";
		double sumaTotalCompra = 0;
		
		html = 
				"	<div class=\"container\" >\r\n" + 
				"	<h1>Resumen de tu compra</h1>\r\n" +  
				"	\r\n" + 
				"	<table border=\"1\"style=\"text-align:center\" >\r\n" + 
				"	<tr>\r\n" + 
				"		<th>Producto</th>\r\n" + 
				"		<th>Precio</th>\r\n" + 
				"		<th>Cantidad</th>\r\n" + 
				"		<td>Total</td>\r\n" + 
				"		\r\n" +		
				"	</tr>\r\n" ;
			
		
		for (Producto_Cantidad producto_Cantidad : carrito) {
			html+=	"	<tr>\r\n" + 
					"		<td>"+producto_Cantidad.getDescripcion()+"</td>\r\n" + 
					"		<td>"+producto_Cantidad.getPrecio()+"</td>\r\n" + 
					"		<td>"+producto_Cantidad.getCantidad()+"</td>\r\n" + 
					"		<td>"+producto_Cantidad.getCantidad() * producto_Cantidad.getPrecio()+"</td>\r\n" + 
					"		\r\n" + 
					"	</tr>\r\n";
			sumaTotalCompra+= producto_Cantidad.getCantidad() * producto_Cantidad.getPrecio();
					
		}
		html+=	"	<tr>\r\n" + 
				"		<td colspan=\"3\">Total de la compra</td>" +
				"		<td>" +sumaTotalCompra +"</td>\r\n" + 
				"		\r\n" + 
				"	</tr>\r\n";
		
		
			

		
		enviarConGMail("cursolucatic2019@gmail.com", "prueba", html);
		
		request.setAttribute("mensajeFinal", mensaje);
		session.invalidate();
		

		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		}
	
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
		
		Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", "cursolucatic2019@gmail.com");
	    props.put("mail.smtp.clave", "lucatic2019");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress("lucatic2019@gmail.com"));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);		
	        
	        
	        message.setText(cuerpo,"ISO-8859-1","html");
	        
	        
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com","cursolucatic2019@gmail.com", "lucatic2019");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	
	}
	
	

}
