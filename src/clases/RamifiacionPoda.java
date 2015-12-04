/**
 * File name:RamifiacionPoda.java
 * Package name: clases
 * Proyect name: cc_travelling_salesman
 */
package clases;

import java.util.ArrayList;
import java.util.Stack;

import global.VariablesGlobales;

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
		//cotaSuperior.getInfoProblema().getDistancias().mostrarMatriz();
		cotaSuperior.calcularCota(verticePartida);
		setVerticePartida(verticeInicial);
		listaTrayectorias = new Stack<ArrayList<Integer>>();
		ArrayList<Integer> trayectoriaInicial = new ArrayList<Integer>();
		trayectoriaInicial.add(verticePartida);
		listaTrayectorias.push(trayectoriaInicial);
		algoritmoRamificacionPoda();
		System.out.println("Valor objetivo: " + cotaSuperior.getMejorValorObjetivo());
		System.out.println("Tour");
		cotaSuperior.getMejorTour().mostrarTour();
	}

	/**
	 * algoritmoRamificacionPoda
	 */
	public void algoritmoRamificacionPoda() {
		while (!listaTrayectorias.empty()) {
			ArrayList<Integer> trayectoria = listaTrayectorias.pop();
			if (trayectoria.size() == getMatrizDistancias().size()) {
				double valorObjetivoTrayectoria = calcularCotaInferior(trayectoria);
				valorObjetivoTrayectoria += getMatrizDistancias().get(trayectoria.get(trayectoria.size()-1)).get(verticePartida);
				//System.out.println(valorObjetivoTrayectoria);
				if (valorObjetivoTrayectoria < cotaSuperior.getMejorValorObjetivo()) {
					System.out.println(valorObjetivoTrayectoria);
					cotaSuperior.setMejorValorObjetivo(valorObjetivoTrayectoria);
					cotaSuperior.getMejorTour().setTour(trayectoria);
				}
			} else {
				if (calcularRestoTrayectoria(trayectoria) < cotaSuperior.getMejorValorObjetivo()) {
					ramificar(trayectoria);
				}
			}
		}
	}
	/**
	 * ramificar
	 */
	public void ramificar(ArrayList<Integer> trayectoriaActual) {
		for (int i = 0; i < getMatrizDistancias().size(); i++) {
			if (!trayectoriaActual.contains(i)) {
				ArrayList<Integer> aumentarTrayectoria = (ArrayList<Integer>) trayectoriaActual.clone();
				aumentarTrayectoria.add(i);
				if (calcularRestoTrayectoria(aumentarTrayectoria) < cotaSuperior.getMejorValorObjetivo())
					listaTrayectorias.push(aumentarTrayectoria);
			}
		}
	}
	/**
	 * calcularRestoTrayectoria
	 */
	public double calcularRestoTrayectoria(ArrayList<Integer> trayectoria) {
		double costePrim = 0.0;
		int aux = 0;
		double minimo = VariablesGlobales.MAXDISTANCE;
		ArrayList<Integer> copiaTrayectoria = (ArrayList<Integer>) trayectoria.clone();
		//quitar un bucle y enlazar ultimo nodo de copiatrayectoria para que sea el explorado
		for (int i = 0; i <= getMatrizDistancias().size()-trayectoria.size(); i++) {
			if(i < getMatrizDistancias().size()-trayectoria.size()) {
				for (int j = 0; j < copiaTrayectoria.size(); j++) {
					for(int k = 0; k < getMatrizDistancias().size(); k++) {
						if(!copiaTrayectoria.contains(k)) {
							if (getMatrizDistancias().get(j).get(k) < minimo) {
								minimo = getMatrizDistancias().get(j).get(k);
								aux = k;
							}
						}
					}
				}
				costePrim += minimo;
				copiaTrayectoria.add(aux);
				minimo = VariablesGlobales.MAXDISTANCE;
			}
			else {
				for (int j = 0; j < copiaTrayectoria.size(); j++) {
					if (getMatrizDistancias().get(j).get(0) < minimo) {
						minimo = getMatrizDistancias().get(j).get(0);
						aux = j;
					}
				}
				costePrim += minimo;
				minimo = VariablesGlobales.MAXDISTANCE;
			}
			
		}
		double cotaInferior = calcularCotaInferior(trayectoria) + costePrim;
		//System.out.println(cotaInferior);
		return (cotaInferior);
	}
	/**
	 * calcularValorObjetivoRecorridoActual
	 */
	public double calcularCotaInferior(ArrayList<Integer> recorridoActual) {
		double valorObjetivo = 0.0;
		int anterior = 0;
		int primero = 0;
		for (int i = 0; i < recorridoActual.size(); i++) {
			if (primero == 0) {
				primero++;
				anterior = recorridoActual.get(i);
				continue;
			}
			valorObjetivo += getMatrizDistancias().get(anterior).get(recorridoActual.get(i));
			anterior = recorridoActual.get(i);
		}
		//valorObjetivo += getMatrizDistancias().get(recorridoActual.get(recorridoActual.size()-1)).get(verticePartida);
		return valorObjetivo;
	}
	/**
	 * getMatrizDistancias
	 */
	public ArrayList<ArrayList<Double>> getMatrizDistancias() {
		return cotaSuperior.getInfoProblema().getDistancias().getMatrizDistancias();
	}
	/**
	 * getUltimoVerticeMejorTour
	 */
	public int getUltimoVerticeMejorTour() {
		return cotaSuperior.getMejorTour().getTour().get(cotaSuperior.getMejorTour().getTour().size()-1);
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
	public void setListaTrayectorias(Stack<ArrayList<Integer>> listaTrayectorias) {
		this.listaTrayectorias = listaTrayectorias;
	}
}
