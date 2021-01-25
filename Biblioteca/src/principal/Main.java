package principal;
import java.util.*;
import java.io.*;
import java.sql.*;


public class Main {

	public static void main(String[] args){
	
		try {
		
		//cargar el driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//crear conexion con la bbdd
	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/onintze_prog_biblioteca", "root", "");
		
		//statement para ejecutar query
		Statement st = con.createStatement();
		
		//ejecutar query (rs es de tipo ResultSet)
		ResultSet rs = st.executeQuery("select * from usuarios");
		
		//imprimir en pantalla el resultado de la consulta
		while (rs.next()) {
				System.out.println(rs.getInt("id") + ", "
						+ rs.getString("nombre") + ", "
						+ rs.getString("apellido") + ", "
						+ rs.getString("dni") + ", "
						+ rs.getInt("admin") + ", "
						+ rs.getString("password")
					);
		}
		//ejecutar un insert
		st.execute("INSERT INTO usuarios(nombre, apellido, dni, admin, password) VALUES ('cyberpink', 'marceli', '23423459c', '1', 'a')");
		
		//delete
		st.execute("DELETE FROM usuarios WHERE nombre='enaut'");
		
		//update
		
		st.execute("UPDATE usuarios SET nombre='ELJOLEBOTAS' WHERE nombre='jolebotas'");
		
		
		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		}catch (SQLException e) {
			e.printStackTrace();
		
		}
		
	}//cierre main

}//cierre todo
