public class Registro{

  private String idAuto;
  private String fecha;
  private String hora;
  private String nombreNodo;

  public Registro(String idAuto, String fecha, String hora){
    this.idAuto = idAuto;
    this.fecha = fecha;
    this.hora = hora;
  }

  public String getIdAuto(){
    return idAuto;
  }

  public String getFecha(){
    return fecha;
  }


  public String getHora(){
    return hora;
  }

  public void setIdAuto(){
    this.idAuto = idAuto;
  }

  public void setFecha(){
    this.fecha = fecha;

  }

  public void setHora(){
    this.hora = hora;
  }

}
