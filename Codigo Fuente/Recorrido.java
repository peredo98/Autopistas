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

  public String getId() {
		return id;
	}

	public void setId(String nombre) {
		this.id = id;
	}

  public String getHora(){
    return hora;
  }

  public void setHora(String hora){
    this.hora = hora;
  }

  public String getFecha(){
		return fecha;
	}

	public void setFecha(String fecha){
		this.fecha = fecha;
	}

  public String getLugar(){
		return lugar;
	}

	public void setLugar(String lugar){
		this.lugar = lugar;
	}




}
