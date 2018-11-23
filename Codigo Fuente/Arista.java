public class Arista{
	private Vertice destino;
	private double peso;

	public Arista(Vertice destino, double peso){
		this.destino = destino;
		this.peso = peso;
	}

	public void setDestino(Vertice destino){
		this.destino = destino;
	}

	public void setPeso(){
		this.peso = peso;
	}

	public Vertice getDestino(){
		return destino;
	}

	public double getPeso(){
		return peso;
	}
}