/**
 * File name:RamifiacionPoda.java
 * Package name: clases
 * Proyect name: cc_travelling_salesman
 */
package clases;

public class RamifiacionPoda {
	/**
	 * Atributos
	 */
	private int cotaActual;
	/**
	 * Constructor: RamifiacionPoda
	 */
	public RamifiacionPoda(int cotaInicial) {
		cotaActual = cotaInicial;
	}
	
	
	/**
	 * @return the cotaActual
	 */
	public int getCotaActual() {
		return cotaActual;
	}
	/**
	 * @param cotaActual the cotaActual to set
	 */
	public void setCotaActual(int cotaActual) {
		this.cotaActual = cotaActual;
	}

}
