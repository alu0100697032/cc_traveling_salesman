/**
 * File name:InfoProblema.java
 * Package name: clases
 * Proyect name: cc_travelling_salesman
 */
package clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

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
	public void calcularCota(int nodoInicial) {
		// Comenzamos en el vertice 0, vertice que estamos evaluando
		int indiceVerticeActual = nodoInicial;
		// Para guardar la posicion del vertice siguiente que mejora la
		// distancia minima actual
		int indiceAuxiliar = indiceVerticeActual;
		// Al final indicara la distancia de coste minimo al siguiente vertice
		// del vertice evaluado
		double minimoCosteNoVisitado = VariablesGlobales.MAXDISTANCE;
		// Lo metemos en el recorrido del tour
		mejorTour.getTour().add(indiceVerticeActual);
		// Recorremos los vertices y vamos comprobando cual es el mas proximo a
		// este
		for (int i = 0; i < infoProblema.getDistancias().getMatrizDistancias().size() - 1; i++) {
			minimoCosteNoVisitado = VariablesGlobales.MAXDISTANCE;
			for (int j = 0; j < infoProblema.getDistancias().getMatrizDistancias().get(i).size(); j++) {
				// Si mejora guardamos la distancia y el indice del vertice
				if (infoProblema.getDistancias().getMatrizDistancias().get(indiceVerticeActual)
						.get(j) < minimoCosteNoVisitado && !mejorTour.getTour().contains(j)) {
					minimoCosteNoVisitado = infoProblema.getDistancias().getMatrizDistancias().get(indiceVerticeActual)
							.get(j);
					indiceAuxiliar = j;
				}
			}
			// Al final tendremos el indice del vertice y la distancia minima
			// correspondiente, actualizamos valores
			indiceVerticeActual = indiceAuxiliar;
			mejorTour.getTour().add(indiceVerticeActual);
			mejorValorObjetivo += minimoCosteNoVisitado;
		}
		mejorValorObjetivo += infoProblema.getDistancias().getMatrizDistancias()
				.get(mejorTour.getTour().get(mejorTour.getTour().size() - 1)).get(nodoInicial);
		// Mostramos valores objetivos y el recorrido del tour
		System.out.println("Valor objetivo: " + mejorValorObjetivo);
		System.out.println("Tour");
		mejorTour.mostrarTour();
	}

	/**
	 * calcularValorObjetivo
	 */
	public double calcularValorObjetivo(ArrayList<Integer> recorridoActual) {
		double valorObjetivo = 0.0;
		int anterior = 0;
		int primero = 0;
		for (int i = 0; i < recorridoActual.size(); i++) {
			if (primero == 0) {
				primero++;
				anterior = recorridoActual.get(i);
				continue;
			}
			valorObjetivo += infoProblema.getDistancias().getMatrizDistancias().get(anterior)
					.get(recorridoActual.get(i));
			anterior = recorridoActual.get(i);
		}
		return valorObjetivo;
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
	public double getMejorValorObjetivo() {
		return mejorValorObjetivo;
	}

	/**
	 * @param mejorValorObtenido
	 *            the mejorValorObtenido to set
	 */
	public void setMejorValorObjetivo(double mejorValorObtenido) {
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
