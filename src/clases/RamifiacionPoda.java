/**
 * File name:RamifiacionPoda.java
 * Package name: clases
 * Proyect name: cc_travelling_salesman
 */
package clases;

import java.util.ArrayList;

public class RamifiacionPoda {
	/**
	 * Atributos
	 */
	private CotaSuperior cotaSuperior;
	private int verticePartida;

	private ArrayList<Integer> tourActual;
	private double valorObjetivoActual;

	/**
	 * Constructor: RamifiacionPoda
	 */
	public RamifiacionPoda(String nombreFichero, int verticeInicial) {
		setCotaSuperior(new CotaSuperior(nombreFichero));
		cotaSuperior.getInfoProblema().getDistancias().mostrarMatriz();
		cotaSuperior.calcularCota(verticeInicial);
		setVerticePartida(verticeInicial);
		ejecutarRP();
	}

	/**
	 * ejecutarRP
	 */
	public void ejecutarRP() {
		tourActual = new ArrayList<>();
		tourActual.add(verticePartida);
		valorObjetivoActual = 0;
		rP(verticePartida, tourActual);
		System.out.println(cotaSuperior.getMejorValorObjetivo());
		cotaSuperior.getMejorTour().mostrarTour();
	}
	/**
	 * getMatrizDistancias
	 */
	public ArrayList<ArrayList<Double>> getMatrizDistancias() {
		return cotaSuperior.getInfoProblema().getDistancias().getMatrizDistancias();
	}
	/**
	 * rP
	 */
	public void rP(int desde, ArrayList<Integer> tour) {
		// we've found a new solution
		if (tour.size() == getMatrizDistancias().size()) {
			tour.add(verticePartida);
			// update the route's cost
			valorObjetivoActual += getMatrizDistancias().get(desde).get(verticePartida);
			if (valorObjetivoActual < cotaSuperior.getMejorValorObjetivo()) {
				cotaSuperior.setMejorValorObjetivo(valorObjetivoActual);
				cotaSuperior.getMejorTour().setTour((ArrayList) tour.clone());
			}
			// update the route's cost (back to the previous value)
			valorObjetivoActual -= getMatrizDistancias().get(desde).get(verticePartida);
		} else {
			for (int to = 0; to < getMatrizDistancias().size(); to++) {
				if (!tour.contains(to)) {
					// update the route's cost
					valorObjetivoActual += getMatrizDistancias().get(desde).get(to);
					if (valorObjetivoActual < cotaSuperior.getMejorValorObjetivo()) {
						ArrayList<Integer> increasedRoute = (ArrayList<Integer>) tour.clone();
						increasedRoute.add(to);
						rP(to, increasedRoute);
					}
					// update the route's cost (back to the previous value)
					valorObjetivoActual -= getMatrizDistancias().get(desde).get(to);
				}
			}
		}
	}
	/**
	 * @return the cotaSuperior
	 */
	public CotaSuperior getCotaSuperior() {
		return cotaSuperior;
	}
	/**
	 * @param cotaSuperior
	 *            the cotaSuperior to set
	 */
	public void setCotaSuperior(CotaSuperior cotaSuperior) {
		this.cotaSuperior = cotaSuperior;
	}

	/**
	 * @return the verticePartida
	 */
	public int getVerticePartida() {
		return verticePartida;
	}

	/**
	 * @param verticePartida
	 *            the verticePartida to set
	 */
	public void setVerticePartida(int verticePartida) {
		this.verticePartida = verticePartida;
	}

	/**
	 * @return the tourActual
	 */
	public ArrayList<Integer> getTourActual() {
		return tourActual;
	}

	/**
	 * @param tourActual
	 *            the tourActual to set
	 */
	public void setTourActual(ArrayList<Integer> tourActual) {
		this.tourActual = tourActual;
	}

	/**
	 * @return the valorObjetivoActual
	 */
	public double getValorObjetivoActual() {
		return valorObjetivoActual;
	}

	/**
	 * @param valorObjetivoActual
	 *            the valorObjetivoActual to set
	 */
	public void setValorObjetivoActual(double valorObjetivoActual) {
		this.valorObjetivoActual = valorObjetivoActual;
	}
}
