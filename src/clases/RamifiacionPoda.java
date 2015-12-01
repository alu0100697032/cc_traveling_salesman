/**
 * File name:RamifiacionPoda.java
 * Package name: clases
 * Proyect name: cc_travelling_salesman
 */
package clases;

import java.util.ArrayList;
import java.util.Stack;

public class RamifiacionPoda {
	/**
	 * Atributos
	 */
	private CotaSuperior cotaSuperior;
	private int verticePartida;

	private Stack<ArrayList<Integer>> listaTrayectorias;

	/**
	 * Constructor: RamifiacionPoda
	 */
	public RamifiacionPoda(String nombreFichero, int verticeInicial) {
		setCotaSuperior(new CotaSuperior(nombreFichero));
		setVerticePartida(verticeInicial);
		listaTrayectorias = new Stack<ArrayList<Integer>>();
		ArrayList<Integer> trayectoriaInicial = new ArrayList<Integer>();
		trayectoriaInicial.add(verticePartida);
		listaTrayectorias.push(trayectoriaInicial);
	}
	
	public void algoritmoRamificacionPoda(){
		while (!listaTrayectorias.empty()) {
			//ramificar(listaTrayectorias.pop());
			//podar();
		}
	}
	public double calcularRestoTrayectoria(ArrayList<Integer> trayectoria){
		ArrayList<Integer> copiaTrayectoria = (ArrayList<Integer>)trayectoria.clone();
		
		return calcularValorObjetivoRecorridoActual(copiaTrayectoria);
	}
	/**
	 * getMatrizDistancias
	 */
	public ArrayList<ArrayList<Double>> getMatrizDistancias() {
		return cotaSuperior.getInfoProblema().getDistancias()
				.getMatrizDistancias();
	}
	/**
	 * calcularValorObjetivoRecorridoActual
	 */
	public double calcularValorObjetivoRecorridoActual(ArrayList<Integer> recorridoActual) {
		double valorObjetivo = 0.0;
		int anterior = 0;
		int primero = 0;
		for (int i = 0; i < recorridoActual.size(); i++) {
			if (primero == 0) {
				primero++;
				anterior = recorridoActual.get(i);
				continue;
			}
			valorObjetivo += getMatrizDistancias().get(anterior).get(
					recorridoActual.get(i));
			anterior = recorridoActual.get(i);
		}
		valorObjetivo += getMatrizDistancias().get(getMatrizDistancias().size()-1).get(verticePartida);
		return valorObjetivo;
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
	 * @return the listaTrayectorias
	 */
	public Stack<ArrayList<Integer>> getListaTrayectorias() {
		return listaTrayectorias;
	}

	/**
	 * @param listaTrayectorias
	 *            the listaTrayectorias to set
	 */
	public void setListaTrayectorias(
			Stack<ArrayList<Integer>> listaTrayectorias) {
		this.listaTrayectorias = listaTrayectorias;
	}
}
