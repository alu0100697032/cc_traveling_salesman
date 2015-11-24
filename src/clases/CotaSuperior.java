/**
 * File name:InfoProblema.java
 * Package name: clases
 * Proyect name: cc_travelling_salesman
 */
package clases;

import java.util.LinkedHashMap;

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
		//Lo metemos en el recorrido del tour
		mejorTour.getTour().put(indiceVerticeActual, indiceVerticeActual);
		//Recorremos los vertices y vamos comprobando cual es el mas proximo a este 
		for (int i = 0; i < infoProblema.getDistancias().getMatrizDistancias()
				.size()-1; i++) {
			minimoCosteNoVisitado = VariablesGlobales.MAXDISTANCE;
			for (int j = 0; j < infoProblema.getDistancias()
					.getMatrizDistancias().get(i).size(); j++) {
				// Si mejora guardamos la distancia y el indice del vertice
				if (infoProblema.getDistancias().getMatrizDistancias().get(indiceVerticeActual)
						.get(j) < minimoCosteNoVisitado
						&& !mejorTour.getTour().containsKey(j)) {
					minimoCosteNoVisitado = infoProblema.getDistancias().getMatrizDistancias().get(indiceVerticeActual)
							.get(j);
					indiceAuxiliar = j;
				}
			}
			// Al final tendremos el indice del vertice y la distancia minima correspondiente, actualizamos valores
			indiceVerticeActual = indiceAuxiliar;
			mejorTour.getTour().put(indiceVerticeActual, indiceVerticeActual);
			mejorValorObjetivo = mejorValorObjetivo + minimoCosteNoVisitado;
		}
		// Mostramos valores objetivos y el recorrido del tour
		System.out.println("Valor objetivo: " + mejorValorObjetivo);
		System.out.println("Tour");
		mejorTour.mostrarTour();
	}
	
	public void calcularCotaB() {
		int indiceVerticeActual = 0;
		LinkedHashMap<Integer, Integer> recorrido = new LinkedHashMap<Integer, Integer>();
		recorrido.put(indiceVerticeActual, indiceVerticeActual);
		System.out.println(calcularValorObjetivo(recorrido, 0));
	}

	public double calcularValorObjetivo(LinkedHashMap<Integer, Integer> recorridoActual, double valorObjetivoActual) {
		double minimoCosteNoVisitado;
		int indiceVerticeActual = recorridoActual.get(recorridoActual.size()-1);
		int indiceAuxiliar = 0;
		LinkedHashMap<Integer, Integer> recorrido =  (LinkedHashMap<Integer, Integer>) recorridoActual.clone();
		for (int i = 0; i < infoProblema.getDistancias().getMatrizDistancias()
				.size()-recorridoActual.size(); i++) {
			minimoCosteNoVisitado = VariablesGlobales.MAXDISTANCE;
			for (int j = 0; j < infoProblema.getDistancias()
					.getMatrizDistancias().get(i).size(); j++) {
				// Si mejora guardamos la distancia y el indice del vertice
				if (infoProblema.getDistancias().getMatrizDistancias().get(indiceVerticeActual)
						.get(j) < minimoCosteNoVisitado
						&& !recorrido.containsKey(j)) {
					minimoCosteNoVisitado = infoProblema.getDistancias().getMatrizDistancias().get(indiceVerticeActual)
							.get(j);
					indiceAuxiliar = j;
				}
			}
			// Al final tendremos el indice del vertice y la distancia minima correspondiente, actualizamos valores
			indiceVerticeActual = indiceAuxiliar;
			recorrido.put(indiceVerticeActual, indiceVerticeActual);
			valorObjetivoActual = valorObjetivoActual + minimoCosteNoVisitado;
		}
		System.out.println();
		return valorObjetivoActual;
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
