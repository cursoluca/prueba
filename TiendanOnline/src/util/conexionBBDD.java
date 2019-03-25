package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexionBBDD {
	public static Connection con;

	public static Connection conexionBBDD () {
		
		try {
			// 1. cargar el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. establecer la conexión
			String url = "jdbc:mysql://localhost:3306/curso?user=root&password=root&useSSL=false&serverTimezone=UTC";
			con = DriverManager.getConnection(url);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return con;
		
	}
	
	public static void desconexionBBDD () {
		try {
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
