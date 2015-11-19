/**
 * File name:InfoProblema.java
 * Package name: clases
 * Proyect name: cc_travelling_salesman
 */
package clases;

import java.util.ArrayList;

import global.VariablesGlobales;

public class Distancias {
	/**
	 * Atributos
	 */
	private ArrayList<ArrayList<Double>> matrizDistancias;
	/**
	 * Constructor: Distancias
	 */
	public Distancias(){
		setMatrizDistancias(new ArrayList<ArrayList<Double>>());
	}
	/**
	 * rellenarMatrizValoresAltos
	 */
	public void rellenarMatrizValoresAltos(int numeroVertices){
		for(int i = 0; i < numeroVertices; i++){
			matrizDistancias.add(new ArrayList<>());
			for(int j = 0; j < numeroVertices; j++){
				matrizDistancias.get(i).add(VariablesGlobales.MAXDISTANCE);
			}	
		}
	}
	/**
	 * @return the matrizDistancias
	 */
	public ArrayList<ArrayList<Double>> getMatrizDistancias() {
		return matrizDistancias;
	}

	/**
	 * @param matrizDistancias the matrizDistancias to set
	 */
	public void setMatrizDistancias(ArrayList<ArrayList<Double>> matrizDistancias) {
		this.matrizDistancias = matrizDistancias;
	}

	
}
