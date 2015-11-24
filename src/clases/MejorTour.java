/**
 * File name:InfoProblema.java
 * Package name: clases
 * Proyect name: cc_travelling_salesman
 */
package clases;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MejorTour {
	/**
	 * Atributos
	 */
	private LinkedHashMap<Integer, Integer> tour;
	
	/**
	 * Constructor: MejorTour
	 */
	public MejorTour(){
		setTour(new LinkedHashMap<Integer, Integer>());
	}

	/**
	 * mostrarTour
	 */
	public void mostrarTour(){
		Iterator it = tour.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.print(e.getKey() + "->");
		}
	}
	
	/**
	 * @return the tour
	 */
	public LinkedHashMap<Integer, Integer> getTour() {
		return tour;
	}

	/**
	 * @param tour the tour to set
	 */
	public void setTour(LinkedHashMap<Integer, Integer> tour) {
		this.tour = tour;
	}
}
