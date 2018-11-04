public class Auto{

  private String id;
  private Nodo entrada;
  private Nodo salida;
  //private String fecha;
  //private String horaEntrada;
  //private String horaSalida;
  private Recorrido recorrido = new Recorrido();

  public Auto(String id, Nodo entrada, Nodo salida/* String fecha, String horaEntrada,String horaSalida*/){
    this.id = id;
    this.entrada = entrada;
    this.salida = salida;
    this.horaEntrada = horaEntrada;

  }

  public String getId() {
		return id;
	}

	public void setId(String nombre) {
		this.id = id;
	}

	public Nodo getEntrada () {
		return entrada;
	}

	public void setEntrada(Nodo entrada) {
		this.entrada = entrada;
	}

	public Nodo getSalida() {
		return salida;
	}

	public void setSalida(Nodo salida) {
		this.salida=salida;
	}

}
