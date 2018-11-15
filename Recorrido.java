import java.util.LinkedList;

public class Recorrido{

  private String id, lugar, fecha, hora;

  public Recorrido(String id , String lugar, String fecha, String hora){
    this.id = id;
    this.lugar = lugar;
    this.fecha = fecha;
    this.hora = hora;
  }

  public String toString(){
    String recorrido = id + "    "+lugar +"    " +fecha+ "    "+hora + "\n";
    return recorrido;
  }



}
