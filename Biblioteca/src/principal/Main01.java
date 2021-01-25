package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.*;
import modelo.bean.*;
import modelo.dao.*;



public class Main01 {
	// TODO rellenar constantes
	private static final String HOST = "";
	private static final String BBDD = "";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";

	// TODO poner las opciones del menu
	private static final int SALIR = 0;
	private static final int LISTAR_LIBROS = 1;
	// .............................
	// ....................

	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);	
		
		
		//TODO realizar la conexi√≥n a la base de datos
		Connection conexion = null;
		/*
		 * 
		 * ...............
		 */
		
		
		Scanner scan = new Scanner(System.in);
		
		
		
		//para meter los libros ac·	
		ArrayList<Libro> TodoLibros = new ArrayList<Libro>();
		
		LibroModelo lm = new LibroModelo();
		TodoLibros = lm.selectAll();
		
	
		
	//menu	
		int opcion;
		int opc;
		do {
			System.out.println("1. Libros \n2. Socios\n3. nada");
				opc = Integer.parseInt(sc.nextLine());
				switch(opc) {
				case 1:
					
					
					
	//////LIBROS/////				
					do {
						menuLibros();
						
						opcion = Integer.parseInt(scan.nextLine());
						switch (opcion) {
						
						case 1:
							for (int i = 0; i < TodoLibros.size(); i++) {
								System.out.println(TodoLibros.get(i).toString());
							}
							break;
						case 2: 
							System.out.println("Dime un Titulo: ");
							String eligeL = scan.nextLine().toUpperCase();	
							TodoLibros = lm.SelectTitulo(eligeL);
							
							for (int i = 0; i < TodoLibros.size(); i++) {	
								System.out.println(TodoLibros.get(i).toString());
							}				
							break;
						case 3: 
							lm.SelectallTitulo();
							
							break;
						case 4: 
							update();
							break;
						case 5:
							borrar();
							break;
							
						default:
							System.out.println("Opcion incorrecta");
							break;
						}

					} while (opcion != 0);
					
					
					
					
					
					break;
				case 2:
					
					
					
					
	//////SOCIOS/////	
					do {
						menuSocios();
						
						opcion = Integer.parseInt(scan.nextLine());
						switch (opcion) {
						
						case 2:
							break;
						case 3: 
									
							break;
						case 4: 
													
							break;
						case 5: 
							break;
						case 6:
							break;
							
						default:
							System.out.println("Opcion incorrecta");
							break;
						}

					} while (opcion != 1);
					
					
					
					
					
					
					break;
				}
		}
		while(opc!=3);
		
	}

/*case 4*/public static void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Dime a que titulo le cambiamos el numero de paginas");
			String titulo = sc.nextLine();
		System.out.println("Numero de paginas: ");
			int nuevoPag = Integer.parseInt(sc.nextLine());
		
		LibroModelo lm = new LibroModelo();
		lm.updateLibropag(nuevoPag, titulo);
}
/*case 5*/public static void borrar() {
	Scanner sc = new Scanner(System.in);

	System.out.println("Dime una ID para borrar el libro seleccionado");
	int id = Integer.parseInt(sc.nextLine()) ;
	
	LibroModelo lm = new LibroModelo();
	lm.BorrarId(id);
}
/*MENU libros*/private static void menuLibros() {
		System.out.println("\n\n\n\n0. SALIR \n"
				+ "1. LISTAR LIBROS-> va a listar todos los libros \n"
				+ "2. BUSCAR LIBROS-> Se va a pedir un trozo del tÌtulo del libro y se visualizar·n los libros que tienen ese trozo en el tÌtulo. \n"
				+ "3. VER LIBRO-> Pedir un tÌtulo y si exoste visualizar la informacion correspondiente en pantalla \n"
				+ "4. EDITAR LIBRO-> Pedir un tÌtulo y el n˙mero de hojas. Se va a actualizar el n˙mero de hojas de ese libro con el nuevo valor introducido \n"
				+ "5. ELIMINAR LIBRO-> Pedir el id de un libro y borrar ese libro de la base de datos \n\n\n\n");
	

	}

/*MENU socios*/private static void menuSocios() {
	System.out.println("\n\n\n\n 1. SALIR \n"
			+ "2. LISTAR SOCIOS-> Visualizar· todos los socios \n"
			+ "3. BUSCAR SOCIOS-> Pedir un trozo de nombre y visuaIizar los socios que tienen ese trozo en el nombre. \n"
			+ "4. VER SOCIOS-> Pedir el DNI y si existe visualizar la informaciÛn correspondiente en la pantalla. \n"
			+ "5. EDITAR SOCIOS-> Pedir el DNI de un socio y dar la opciÛn de cambiar la direcciÛn, el pueblo y la provincia de ese socio. \n"
			+ "6. ELIMINAR SOCIOS-> Pedir el DNI de un socio y borrar ese socio de la base de datos. \n\n\n\n");


}

}