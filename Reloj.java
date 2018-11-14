public class Reloj{
	private int hora;
	private int minuto;
	private int segundo;
	private Fecha fecha;

	public Reloj(){
		hora = 0;
		minuto = 0;
		segundo = 0;

		fecha = new Fecha(1, 1, 18);
	}

	public Reloj(int hora, int minuto, int segundo, Fecha fecha){
		this.fecha = fecha;
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
	}

	public void setHora(int hora){
		if(hora >= 24){
			fecha.setDia(fecha.getDia() + 1);
			hora = 0;
		}
		this.hora = hora;
	}

	public void setMinuto(int minuto){
		if(minuto > 60){
			minuto = 0;
		}
		if(minuto == 60){
			minuto = 0;
			hora++;
		}
		this.minuto = minuto;
	}

	public void setSegundo(int segundo){
		if(segundo >= 60){
			segundo = 0;
			minuto++;
		}
		this.segundo = segundo;
	}

	public int getHora(){
		return hora;
	}

	public int getMinuto(){
		return minuto;
	}

	public int getSegundo(){
		return segundo;
	}

	public Fecha getFecha(){
		return fecha;
	}

	public void setFecha(Fecha fecha){
		this.fecha = fecha;
	}

	public String toString(){
		String hora = "" + this.hora;
		if (this.hora < 10){
			hora = "0" + hora;	
		}
		String minuto = "" + this.minuto;
		if(this.minuto < 10){
			minuto = "0" + minuto;
		}
		
		return hora + " : " + minuto;	
	}

	public static Reloj restar(Reloj hora, Reloj restar){
		int h = hora.getHora() - restar.getHora();
		int m = hora.getMinuto() - restar.getMinuto();
		int s = hora.getSegundo() - restar.getSegundo();
		return new Reloj(h, m, s, hora.getFecha());
	}
}