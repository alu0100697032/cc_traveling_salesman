package clases;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class InfoProblema {

	/*
	 * Atributos
	 */

	private Distancias matrizDistancias;

	/*
	 * Constructor
	 */

	public InfoProblema(String nombreFichero) {
		matrizDistancias = new Distancias();
		leerDatosProblema(nombreFichero);
	}

	/*
	 * Método de lectura
	 */

	public void leerDatosProblema(String nombreFichero) {
		try {
			DocumentBuilderFactory fábricaCreadorDocumento = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder creadorDocumento = fábricaCreadorDocumento
					.newDocumentBuilder();
			Document documento = creadorDocumento.parse(nombreFichero);
			// Obtener el elemento raíz del documento
			Element raiz = documento.getDocumentElement();

			// Obtener la lista de nodos que tienen etiqueta "EMPLEADO"
			NodeList listaVertices = raiz.getElementsByTagName("vertex");
			// Recorrer la lista de empleados
			for (int i = 0; i < listaVertices.getLength(); i++) {
				matrizDistancias.getMatrizDistancias().add(
						new ArrayList<Double>());
				// Obtener de la lista un empleado tras otro
				Node vertice = listaVertices.item(i);
				// Obtener la lista de los datos que contiene ese empleado
				NodeList distanciasVertice = vertice.getChildNodes();
				// Recorrer la lista de los datos que contiene el empleado
				for (int j = 0; j < listaVertices.getLength(); j++) {
					if (j == i){
						matrizDistancias.getMatrizDistancias().get(i).add(9999.0);
					}else {
						if (distanciasVertice.item(j).getNodeType() == Node.ELEMENT_NODE) {
							Element distancia = (Element) distanciasVertice
									.item(j);
							if (distancia.hasAttribute("cost"))
								matrizDistancias
										.getMatrizDistancias()
										.get(i)
										.add(Double.parseDouble(distancia
												.getAttribute("cost")));
						}
					}
				}
			}

		} catch (SAXException ex) {
			System.out
					.println("ERROR: El formato XML del fichero no es correcto\n"
							+ ex.getMessage());
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out
					.println("ERROR: Se ha producido un error el leer el fichero\n"
							+ ex.getMessage());
			ex.printStackTrace();
		} catch (ParserConfigurationException ex) {
			System.out
					.println("ERROR: No se ha podido crear el generador de documentos XML\n"
							+ ex.getMessage());
			ex.printStackTrace();
		}
	}

	/*
	 * Mostrar matriz de distancias
	 */
	public void mostrarMatriz() {
		for (int i = 0; i < matrizDistancias.getMatrizDistancias().size(); i++) {
			for (int j = 0; j < matrizDistancias.getMatrizDistancias().get(i)
					.size(); j++) {
				System.out.print(matrizDistancias.getMatrizDistancias()
						.get(i).get(j)
						+ " ");
			}
			System.out.println("");
		}
	}

	/**
	 * @return the matrizDistancias
	 */
	public Distancias getDistancias() {
		return matrizDistancias;
	}

	/**
	 * @param matrizDistancias
	 *            the matrizDistancias to set
	 */
	public void setDistancias(Distancias matrizDistancias) {
		this.matrizDistancias = matrizDistancias;
	}
}
