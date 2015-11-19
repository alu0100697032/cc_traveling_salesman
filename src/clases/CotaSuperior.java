/**
 * File name:InfoProblema.java
 * Package name: clases
 * Proyect name: cc_travelling_salesman
 */
package clases;

import java.util.ArrayList;
import global.VariablesGlobales;

public class CotaSuperior {
	/**
	 * Atributos
	 */
	private InfoProblema infoProblema;
	private MejorTour mejorTour;
	private double mejorValorObjetivo; // valor de la cota

	/**
	 * Constructor: CotaSuperior
	 */
	public CotaSuperior(String nombreFichero) {
		infoProblema = new InfoProblema(nombreFichero);
		mejorTour = new MejorTour();
		mejorValorObjetivo = 0;
	}
	/**
	 * calcularCota
	 */
	public void calcularCota() {
		//Comenzamos en el vertice 0, vertice que estamos evaluando
		int indiceVerticeActual = 0;
		// Para guardar la posicion del vertice siguiente que mejora la distancia minima actual
		int indiceAuxiliar = indiceVerticeActual;
		// Al final indicara la distancia de coste minimo al siguiente vertice del vertice evaluado 
		double minimoCosteNoVisitado = VariablesGlobales.MAXDISTANCE;
		// Lista que indica si el nodo ha sido visitado o no
		ArrayList<Boolean> visitados = new ArrayList<Boolean>();
		// Ningun vertice inicialmente esta visitado...
		for (int i = 0; i < infoProblema.getDistancias().getMatrizDistancias()
				.size(); i++) {
			visitados.add(false);
		}
		//Menos el actual
		visitados.set(indiceVerticeActual, true);
		//Lo metemos en el recorrido del tour
		mejorTour.getTour().add(indiceVerticeActual);
		//Recorremos los vertices y vamos comprobando cual es el mas proximo a este 
		for (int i = 0; i < infoProblema.getDistancias().getMatrizDistancias()
				.size()-1; i++) {
			minimoCosteNoVisitado = VariablesGlobales.MAXDISTANCE;
			for (int j = 0; j < infoProblema.getDistancias()
					.getMatrizDistancias().get(i).size(); j++) {
				// Si mejora guardamos la distancia y el indice del vertice
				if (infoProblema.getDistancias().getMatrizDistancias().get(indiceVerticeActual)
						.get(j) < minimoCosteNoVisitado
						&& visitados.get(j) == false) {
					minimoCosteNoVisitado = infoProblema.getDistancias().getMatrizDistancias().get(i)
							.get(j);
					indiceAuxiliar = j;
				}
			}
			// Al final tendremos el indice del vertice y la distancia minima correspondiente, actualizamos valores
			indiceVerticeActual = indiceAuxiliar;
			mejorTour.getTour().add(indiceVerticeActual);
			mejorValorObjetivo = mejorValorObjetivo + minimoCosteNoVisitado;
			visitados.set(indiceVerticeActual, true);
		}
		// Mostramos valores objetivos y el recorrido del tour
		System.out.println("Valor objetivo: " + mejorValorObjetivo);
		System.out.println("Tour");
		mejorTour.mostrarTour();
	}

	/**
	 * @return the infoProblema
	 */
	public InfoProblema getInfoProblema() {
		return infoProblema;
	}

	/**
	 * @param infoProblema
	 *            the infoProblema to set
	 */
	public void setInfoProblema(InfoProblema infoProblema) {
		this.infoProblema = infoProblema;
	}

	/**
	 * @return the mejorValorObtenido
	 */
	public double getMejorValorObtenido() {
		return mejorValorObjetivo;
	}

	/**
	 * @param mejorValorObtenido
	 *            the mejorValorObtenido to set
	 */
	public void setMejorValorObtenido(double mejorValorObtenido) {
		this.mejorValorObjetivo = mejorValorObtenido;
	}

	/**
	 * @return the mejorTour
	 */
	public MejorTour getMejorTour() {
		return mejorTour;
	}

	/**
	 * @param mejorTour
	 *            the mejorTour to set
	 */
	public void setMejorTour(MejorTour mejorTour) {
		this.mejorTour = mejorTour;
	}
}
