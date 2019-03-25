package beans;

public class Categoria {

	private int idCategoria;
	private String descripcion;
	
	public Categoria(int idCategoria, String descripcion) {
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
	}

	public Categoria() {
		
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
	
}
