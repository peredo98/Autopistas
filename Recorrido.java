import java.util.LinkedList;

public class Recorrido{

  private LinkedList<Vertice> puntosRecorridos = new LinkedList<Vertice>();
  private String horaEntrada;
  private String horaSalida;

  public Recorrido(Nodo puntoRecorrido, String horaEntrada, String horaSalida){
    puntosRecorridos.add(puntoRecorrido);
    this.horaEntrada = horaEntrada;
    this.horaSalida = horaSalida;
  }

  public void getRecorrido(){
    System.out.println(puntosRecorridos);
  }


}
