package clases;

import java.util.ArrayList;

public class Distancias {

	private ArrayList<ArrayList<Double>> matrizDistancias;
	
	public Distancias(){
		setMatrizDistancias(new ArrayList<ArrayList<Double>>());
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
