import java.util.LinkedList;

public class GrafoAutopista{

	private LinkedList<Vertice> vertices;

	public GrafoAutopista(){
		vertices = new LinkedList<Vertice>();
		buildAutopista();
	}

	private void buildAutopista(){

		Vertice v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21;

		v1 = new Vertice("Cuernavaca", true, true, 405, 545);
		v2 = new Vertice("Xochimilco", true, true, 475, 510);
		v3 = new Vertice("Tlalpan", false, true, 440, 492);
		v4 = new Vertice("Azteca", true, true, 404, 474);
		v5 = new Vertice("Insurgentes Sur", false, true, 365, 453);
		v6 = new Vertice("Cuicuilco", true, false, 327, 433);
		v7 = new Vertice("Cerro Zacatepetl", true, true, 295, 417);
		v8 = new Vertice("Picacho Ajusco", true, true, 316, 384);
		v9 = new Vertice("Conexion Autopista Urbana PTE", false, false, 332, 355);
		v10 = new Vertice("Distribuidor Vial", false, true, 301, 332);
		v11 = new Vertice("Luis Cabrera", true, true, 263, 302);
		v12 = new Vertice("Las Torres", true, true, 226, 270);
		v13 = new Vertice("Las Aguilas", true, true, 188, 240);
		v14 = new Vertice("Poetas", true, true, 155, 213);
		v15 = new Vertice("BLVD de la Luz", true, true, 336, 324);
		v16 = new Vertice("San Jeronimo", true, true, 338, 286);
		v17 = new Vertice("San Antonio", true, true, 342, 245);
		v18 = new Vertice("Alencastre", true, true, 345, 199);
		v19 = new Vertice("Chapultepec Reforma", true, true, 348, 154);
		v20 = new Vertice("Conscripto", true, true, 352, 105);
		v21 = new Vertice("CDI", true, true, 335, 60);

		v1.addEdge(v3, 347);

		v2.addEdge(v3, 27);

		v3.addEdge(v1, 347);
		v3.addEdge(v2, 27);
		v3.addEdge(v4, 86);

		v4.addEdge(v3, 86);
		v4.addEdge(v5, 94);

		v5.addEdge(v4, 94);
		v5.addEdge(v6, 63);

		v6.addEdge(v5, 63);
		v6.addEdge(v7, 81);

		v7.addEdge(v6, 81);
		v7.addEdge(v8, 86);

		v8.addEdge(v7, 86);
		v8.addEdge(v9, 72);

		v9.addEdge(v8, 72);
		v9.addEdge(v10,23);
		v9.addEdge(v15,40);

		v10.addEdge(v9, 23);
		v10.addEdge(v11,59);

		v11.addEdge(v10,59);
		v11.addEdge(v12,113);

		v12.addEdge(v11,113);
		v12.addEdge(v13,63);

		v13.addEdge(v12,63);
		v13.addEdge(v14,72);

		v14.addEdge(v13,72);
		
		v15.addEdge(v9,40);
		v15.addEdge(v16,34);

		v16.addEdge(v15,34);
		v16.addEdge(v17,266);

		v17.addEdge(v16,266);
		v17.addEdge(v18,225);

		v18.addEdge(v17,225);
		v18.addEdge(v19,63);

		v19.addEdge(v18,63);
		v19.addEdge(v20,117);

		v20.addEdge(v19,117);
		v20.addEdge(v21,45);

		v21.addEdge(v20,45);

		addVertex(v1);
		addVertex(v2);
		addVertex(v3);
		addVertex(v4);
		addVertex(v5);
		addVertex(v6);
		addVertex(v7);
		addVertex(v8);
		addVertex(v9);
		addVertex(v10);
		addVertex(v11);
		addVertex(v12);
		addVertex(v13);
		addVertex(v14);
		addVertex(v15);
		addVertex(v16);
		addVertex(v17);
		addVertex(v18);
		addVertex(v19);
		addVertex(v20);
		addVertex(v21);
	}

	public void addVertex(Vertice v){
		vertices.add(v);
	}

	public void removeVertex(Vertice v){
		vertices.remove(v);
	}

	public Vertice getVertex(int i){
		return vertices.get(i);
	}

	public int getSize(){
		return vertices.size();
	}

	public double [][] getMatrizDeAdyacencia(){
		double [][] matriz = new double [getSize()][getSize()];
		for(int i = 0; i < getSize(); i++){
			for(int j = 0; j < getVertex(i).getEdgeSize(); j++){
				for(int k = 0; k < getSize(); k++){
					if(getVertex(i).getEdge(j).getDestino() == getVertex(k)){
						matriz [i][k] = getVertex(i).getEdge(j).getPeso();
					}
					else if(matriz[i][k] == 0){
						matriz[i][k] = Double.MAX_VALUE;
					}
				}
			}
		}
		return matriz;
	}

	/*public void printMatrix(double [][] matrix){
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + "   ");
		    }
		    System.out.println();
		}
	}*/

	public LinkedList<Vertice> dijkstra(Vertice origen, Vertice destino) {
		LinkedList<Vertice> camino = new LinkedList<Vertice>();
		double distancia = Double.MAX_VALUE;
		Vertice nodo = origen;
		boolean fin = true;
		camino.add(nodo);
		/*while(fin) {
			if(this.floydC[nodo][destino]<distancia) {
			    /*El metodo siguiente(nodo, destino), nos devuelve
			    el siguiente nodo a visitar
				nodo = this.siguiente(nodo, destino);
				camino.add(nodo);
			}
			  
			if(nodo == destino) {
				fin=false;
			}
		}*/
		return camino;
	}
}