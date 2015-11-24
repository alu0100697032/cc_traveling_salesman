/**
 * File name:InfoProblema.java
 * Package name: clases
 * Proyect name: cc_travelling_salesman
 */
package clases;

import java.util.ArrayList;
import java.util.HashMap;

public class MejorTour {
	/**
	 * Atributos
	 */
	private HashMap<Integer, Integer> tour;
	
	/**
	 * Constructor: MejorTour
	 */
	public MejorTour(){
		setTour(new HashMap<Integer, Integer>());
	}

	/**
	 * mostrarTour
	 */
	public void mostrarTour(){
		for(int i = 0; i < tour.size(); i++) {
			if(i == tour.size()-1)
				System.out.print(tour.get(i));
			else
				System.out.print(tour.get(i)+"->");
		}
	}
	
	/**
	 * @return the tour
	 */
	public HashMap<Integer, Integer> getTour() {
		return tour;
	}

	/**
	 * @param tour the tour to set
	 */
	public void setTour(HashMap<Integer, Integer> tour) {
		this.tour = tour;
	}
}
