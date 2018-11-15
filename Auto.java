import java.util.LinkedList;

public class Auto{

  private String id;
  private Vertice entrada;
  private Vertice salida;
  private Vertice actual;
  private Reloj hora;
  private Reloj horaEntrada;
  //private String horaSalida;
  private GrafoAutopista au;
  private LinkedList<Vertice> recorrido;
  private int x, y;
  private boolean istEingefahren;
  //private Recorrido recorrido = new Recorrido();

  public Auto(String id, Vertice entrada, Vertice salida, Reloj hora, GrafoAutopista au){
    this.id = id;
    this.entrada = entrada;
    setActual(entrada);
    this.salida = salida;
    this.hora = hora;
    recorrido = au.dijkstra(entrada, salida);
    this.x = entrada.getX();
    this.y = entrada.getY();
    setHoraEntrada(hora);
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

	public Reloj getHora(){
		return hora;
	}

	public void setHora(Reloj hora){
		this.hora = hora;
	}

	public void move(){
		Reloj movimiento = Reloj.restar(hora, horaEntrada);

		Vertice next = recorrido.get(recorrido.indexOf(actual)+1);
		Arista recorriendo = actual.searchEdge(next);

		double y2 = next.getY();
		double x2 = next.getX();
		double y1 = getActual().getY();
		double x1 = getActual().getX();
		double distanciaX = x2 - x1;
		double distanciaY = y2 - y1;
		
		int segundos = (movimiento.getHora() * 3600) + (movimiento.getMinuto() * 60) + (movimiento.getSegundo());

		if(segundos == 0 && istEingefahren){
			Recorrido r;
			if(entrada == actual){
				r = new Recorrido(this.id, getActual().getNombre() + "(Entrada)", hora.toString(), hora.getFecha().toString());
			}
			else if(salida == actual){
				r = new Recorrido(this.id, getActual().getNombre() + "(Salida)", hora.toString(), hora.getFecha().toString());
			}
			else{
				r = new Recorrido(this.id, getActual().getNombre(), hora.toString(), hora.getFecha().toString());
			}
			Registro.registro.add(r);
			Registro.area.append(r.toString());
		}	

		double velocidadX = distanciaX / (recorriendo.getPeso());
		double velocidadY = distanciaY / (recorriendo.getPeso());

		int posx = (int) Math.round((velocidadX * segundos) + x1);
		int posy = (int) Math.round((velocidadY * segundos) + y1);

		if(y2 > y1 && posy >= y2){
			posy = (int) y2;
		}

		else if(y2 < y1 && posy <= y2){
			posy = (int) y2;
		}


		if(x2 > x1 && posx >= x2){
			posx = (int) x2;
		}

		else if(x2 < x1 && posx <= x2){
			posx = (int) x2;
		}
		
		setX(posx);
		setY(posy);

		if (posx == x2 && posy == y2){
			setActual(next);
			setHoraEntrada(hora);
			istEingefahren = true;
			return;
		}
		istEingefahren = false;
	}

	public void setHoraEntrada(Reloj hora){
		horaEntrada = new Reloj (hora.getHora(), hora.getMinuto(), hora.getSegundo(), hora.getFecha());
	}

}
