import java.util.LinkedList;

public class Auto{

  private String id;
  private Vertice entrada;
  private Vertice salida;
  private Vertice actual;
  private String horaEntrada;
  private String horaSalida;
  private GrafoAutopista au;
  private LinkedList<Vertice> recorrido;
  private int x, y;
  //private Recorrido recorrido = new Recorrido();

  public Auto(String id, Vertice entrada, Vertice salida, String horaEntrada, GrafoAutopista au){
    this.id = id;
    this.entrada = entrada;
    this.actual = entrada;
    this.salida = salida;
    this.horaEntrada = horaEntrada;
    recorrido = au.dijkstra(entrada, salida);
    this.x = entrada.getX();
    this.y = entrada.getY();
  }

  public String getId() {
		return id;
	}

	public void setId(String nombre) {
		this.id = id;
	}

	public Vertice getEntrada () {
		return entrada;
	}

	public void setEntrada(Vertice entrada) {
		this.entrada = entrada;
	}

	public Vertice getSalida() {
		return salida;
	}

	public void setSalida(Vertice salida) {
		this.salida=salida;
	}

	public Vertice getActual () {
		return actual;
	}

	public void setActual(Vertice actual) {
		this.actual = actual;
	}

	public void setX(int x){
		this.x = x;
	}
	public int getX(){
		return x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getY(){
		return y;
	}

}
