public class Reloj{
	private int hora;
	private int minuto;

	public Reloj(){
		hora = 0;
		minuto = 0;

	}

	public Reloj(int hora, int minuto){
		this.hora = hora;
		this.minuto = minuto;
	}

	public void setHora(int hora){
		if(hora >= 24){
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

	public int getHora(){
		return hora;
	}

	public int getMinuto(){
		return minuto;
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
}