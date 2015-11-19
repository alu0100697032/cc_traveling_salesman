package clases;

import java.util.ArrayList;

public class CotaSuperior {

	/*
	 * Atributos
	 */
	private InfoProblema infoProblema;
	private MejorTour mejorTour;
	private double mejorValorObjetivo; // valor del punto final al inicial

	/*
	 * Constructor
	 */
	public CotaSuperior(String nombreFichero) {
		infoProblema = new InfoProblema(nombreFichero);
		mejorTour = new MejorTour();
		mejorValorObjetivo = 0;
	}

	public void calcularCota() {
		int indiceVerticeActual = 0;
		double minimoCosteNoVisitado = 100000000;
		ArrayList<Boolean> visitados = new ArrayList<Boolean>();
		for (int i = 0; i < infoProblema.getDistancias().getMatrizDistancias()
				.size(); i++) {
			visitados.add(false);
		}
		for (int i = 0; i < infoProblema.getDistancias().getMatrizDistancias()
				.size(); i++) {
			minimoCosteNoVisitado = 100000000;
			for (int j = 0; j < infoProblema.getDistancias()
					.getMatrizDistancias().get(i).size(); j++) {
				if (infoProblema.getDistancias().getMatrizDistancias().get(i)
						.get(j) < minimoCosteNoVisitado
						&& visitados.get(indiceVerticeActual) == false) {
					minimoCosteNoVisitado = infoProblema.getDistancias().getMatrizDistancias().get(i)
							.get(j);
					indiceVerticeActual = j;
				}
				mejorTour.getTour().add(indiceVerticeActual);
				mejorValorObjetivo = mejorValorObjetivo + minimoCosteNoVisitado;
			}
		}
		System.out.println("Valor objetivo: " + mejorValorObjetivo);
		System.out.println("Tour");
		mejorTour.mostrarTour();
	}

	/*
	 * Metodo de carga
	 */
	public void cargarEntrada() {

	}

	/*
	 * Metodo de computacion de la cota superior
	 */
	public void computacionCotaSuperior() {

	}

	/*
	 * Obtener valor de la cota superior
	 */
	public double obtenerValorCotaSuperior() {
		return 0;
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
