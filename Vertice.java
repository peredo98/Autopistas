import java.util.LinkedList;

public class Vertice{

	private String nombre;
	private boolean entrada;
	private boolean salida;
	private int x, y;
	private LinkedList<Arista> aristas;
	//private Registro registro;


	public Vertice(String nombre, boolean entrada, boolean salida, int x, int y) {
		this.nombre = nombre;
		this.entrada = entrada;
		this.salida = salida;
		this.x = x;
		this.y = y;
		aristas = new LinkedList<Arista>();
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

	public void addEdge(Vertice n, double peso){
		aristas.add(new Arista(n, peso));
	}

	public void removeEdge(Arista a){
		aristas.remove(a);
	}

	public Arista getEdge(int i){
		return aristas.get(i);
	}

	public Arista searchEdge(Vertice v){
		for (Arista a : aristas) {
			if(v == a.getDestino()){
				return a;
			}
		}
		return null;
	}

	public int getEdgeSize(){
		return aristas.size();
	}

}
