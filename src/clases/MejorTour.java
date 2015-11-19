/**
 * File name:InfoProblema.java
 * Package name: clases
 * Proyect name: cc_travelling_salesman
 */
package clases;

import java.util.ArrayList;

public class MejorTour {
	/**
	 * Atributos
	 */
	private ArrayList<Integer> tour;
	
	/**
	 * Constructor: MejorTour
	 */
	public MejorTour(){
		setTour(new ArrayList<Integer>());
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
	public ArrayList<Integer> getTour() {
		return tour;
	}

	/**
	 * @param tour the tour to set
	 */
	public void setTour(ArrayList<Integer> tour) {
		this.tour = tour;
	}
}
