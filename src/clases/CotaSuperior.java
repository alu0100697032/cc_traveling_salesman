package clases;

public class CotaSuperior {

	/*
	 * Atributos
	 */
	private InfoProblema infoProblema;
	private MejorTour mejorTour;
	private double mejorValorObtenido;
	/*
	 * Constructor
	 */
	public CotaSuperior(){
		infoProblema = new InfoProblema();
		mejorTour = new MejorTour();
	}
	/*
	 * Metodo de carga
	 */
	public void cargarEntrada(){
		
	}
	/*
	 * Metodo de computacion de la cota superior
	 */
	public void computacionCotaSuperior(){
		
	}
	/*
	 * Obtener valor de la cota superior
	 */
	public double obtenerValorCotaSuperior(){
		return 0;
	}
	/**
	 * @return the infoProblema
	 */
	public InfoProblema getInfoProblema() {
		return infoProblema;
	}

	/**
	 * @param infoProblema the infoProblema to set
	 */
	public void setInfoProblema(InfoProblema infoProblema) {
		this.infoProblema = infoProblema;
	}
	/**
	 * @return the mejorValorObtenido
	 */
	public double getMejorValorObtenido() {
		return mejorValorObtenido;
	}
	/**
	 * @param mejorValorObtenido the mejorValorObtenido to set
	 */
	public void setMejorValorObtenido(double mejorValorObtenido) {
		this.mejorValorObtenido = mejorValorObtenido;
	}
	/**
	 * @return the mejorTour
	 */
	public MejorTour getMejorTour() {
		return mejorTour;
	}
	/**
	 * @param mejorTour the mejorTour to set
	 */
	public void setMejorTour(MejorTour mejorTour) {
		this.mejorTour = mejorTour;
	}
}
