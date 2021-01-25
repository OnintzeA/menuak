package modelo.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.*;
import modelo.bean.*;
public class LibroModelo extends Conector {

	public ArrayList<Libro> selectAll(){
	ArrayList<Libro> listaLibros = new ArrayList<Libro>();
	
	
	
	try {
		Statement st = this.conexion.createStatement();
		ResultSet rs = st.executeQuery("select * from libros");
		
		//imprimir en pantalla el resultado de la consulta
		while (rs.next()) {
			
			Libro l1=new Libro();
			
				l1.setId(rs.getInt("id"));
				l1.setTitulo(rs.getString("titulo"));
				l1.setAutor(rs.getString("autor"));
				l1.setNumPaginas(rs.getInt("num_pag"));
				
			listaLibros.add(l1);
			
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		
		}
	return listaLibros;
	}//cierre select all

//metodos
/*2*/public ArrayList<Libro> SelectTitulo(String eligeL) {
	
	ArrayList<Libro> selectTitulo = new ArrayList<Libro>();
	
	try {
		Statement st = this.conexion.createStatement();
		ResultSet rs = st.executeQuery("select * from libros where titulo like '%" + eligeL + "%'");
		
		//imprimir en pantalla el resultado de la consulta
		while (rs.next()) {
			
			Libro l1=new Libro();
			
				l1.setId(rs.getInt("id"));
				l1.setTitulo(rs.getString("titulo"));
				l1.setAutor(rs.getString("autor"));
				l1.setNumPaginas(rs.getInt("num_pag"));
				
				selectTitulo.add(l1);
			
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		
		}
	return selectTitulo;
	}//cierre select all

/*3*/public void SelectallTitulo() {
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Dime un Titulo completo: ");
	String eligeLi = scan.nextLine().toUpperCase();	
	
	try {
		Statement st = this.conexion.createStatement();
		ResultSet rs = st.executeQuery("select * from libros where titulo like '" + eligeLi + "' ");
		
		Libro libro=new Libro();
		//imprimir en pantalla el resultado de la consulta
		if (rs.next()) {
			
				libro.setId(rs.getInt("id"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				libro.setNumPaginas(rs.getInt("num_pag"));
				
				System.out.println(libro.toString());
			
		}
		else {System.out.println("El libro seleccionado no existe!");}
		
		}catch (SQLException e) {
			e.printStackTrace();
		
		}
	}// cierre 3
/*4*/public void updateLibropag(int nuevoPag, String titulo){
	PreparedStatement pst;
	try {
		pst = this.conexion.prepareStatement("update libros set num_pag=? where titulo=?");
		pst.setInt(1, nuevoPag);
		pst.setString(2, titulo);
		pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}// cierre 4
/*5*/public void BorrarId(int id) {
	PreparedStatement pst;
	try {
		pst = this.conexion.prepareStatement("delete from libros where id=?");
		pst.setInt(1, id);
		pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}// cierre 5
}
