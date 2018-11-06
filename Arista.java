public class Arista{
	private Nodo destino;
	private double peso;

	public Arista(Nodo destino, int peso){
		this.destino = destino;
		this.peso = peso;
	}

	public void setDestino(Nodo destino){
		this.destino = destino;
	}

	public void setPeso(){
		this.peso = peso;
	}

	public Nodo getDestino(){
		return destino;
	}

	public double getPeso(){
		return peso;
	}
}