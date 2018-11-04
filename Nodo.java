public class Nodo {

	private String nombre;
	private boolean entrada;
	private boolean salida;
	//private Registro registro;


	public Nodo(String nombre, boolean entrada, boolean salida) {
		this.nombre = nombre;
		this.entrada = entrada;
		this.salida = salida;
	}

	public String getNombre () {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getEntrada () {
		return entrada;
	}

	public void setEntrada(boolean entrada) {
		this.entrada = entrada;
	}

	public boolean getSalida() {
		return salida;
	}

	public void setSalida(boolean salida) {
		this.salida=salida;
	}



}
