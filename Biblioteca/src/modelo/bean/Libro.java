package modelo.bean;

public class Libro {
	private int id;
	private String titulo;
	private String autor;
	private int numPaginas;
	
//constructores	
	public Libro(int id, String titulo, String autor, int numPaginas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.numPaginas = numPaginas;
	}


	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

//getters & setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public int getNumPaginas() {
		return numPaginas;
	}


	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}


	
	
//metodos
/*1*/@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", numPaginas=" + numPaginas + "]";
	}

}//cierre todo
