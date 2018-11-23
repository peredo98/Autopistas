public class Fecha{
	private int dia;
	private int mes;
	private int ano;

	public Fecha(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public void setDia(int dia){
		if((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && (dia > 31 || dia < 1)){
			dia = 1;
			setMes(getMes() + 1);
		}
		if((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia > 30 || dia < 1)){
			dia = 1;
			setMes(getMes() + 1);
		}
		if(mes == 2 && (dia > 28 || dia < 1)){
			dia = 1;
			setMes(getMes() + 1);
		}
		this.dia = dia;
	}

	public void setMes(int mes){
		if(mes > 12 || mes < 1){
			setAno(getAno() + 1);
			mes = 1;
		}
		this.mes = mes;
	}

	public void setAno(int ano){
		this.ano = ano;
	}

	public int getDia(){
		return dia;
	}

	public int getMes(){
		return mes;
	}

	public int getAno(){
		return ano;
	}

	public String toString(){
		String dia = "" + this.dia;
		if (this.dia < 10){
			dia = "0" + dia;	
		}
		String mes = "" + this.mes;
		if(this.mes < 10){
			mes = "0" + mes;
		}

		String ano = "" + this.ano;
		if(this.ano < 10){
			ano = "0" + ano;
		}
		
		return dia + "/" + mes + "/" + ano;	
	}

	public static int restar(Fecha fecha, Fecha restar){
		int d = fecha.getDia() - restar.getDia();
		int m = fecha.getMes() - restar.getMes();
		int a = fecha.getAno() - restar.getAno();
		return d;
	}

}