package clases;

import java.util.ArrayList;

public class MatrizDistancias {

	private ArrayList<ArrayList<Double>> matrizDistancias;
	
	public MatrizDistancias(){
		matrizDistancias = new ArrayList<ArrayList<Double>>();
	}
	/*
	 * Matriz de distancias
	 */

	public ArrayList<ArrayList<Double>> getMatrizDistancias() {
		return matrizDistancias;
	}

	public void setMatrizDistancias(ArrayList<ArrayList<Double>> matrizDistancias) {
		this.matrizDistancias = matrizDistancias;
	}
}
