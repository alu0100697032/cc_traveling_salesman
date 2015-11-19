package clases;

import java.util.ArrayList;

public class MejorTour {

	private ArrayList<Integer> tour;
	
	public MejorTour(){
		setTour(new ArrayList<Integer>());
	}

	public void mostrarTour(){
		for(int i = 0; i < tour.size(); i++)
			System.out.print(tour.get(i)+"->");
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
