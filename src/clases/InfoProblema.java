/**
 * File name:InfoProblema.java
 * Package name: clases
 * Proyect name: cc_travelling_salesman
 */
package clases;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class InfoProblema {
	/**
	 * Atributos
	 */
	private Distancias matrizDistancias;

	/**
	 * Constructor: InfoProblema
	 */
	public InfoProblema(String nombreFichero) {
		matrizDistancias = new Distancias();
		leerDatosProblema(nombreFichero);
	}

	/**
	 * leerDatosProblema
	 */
	public void leerDatosProblema(String nombreFichero) {
		try {
			// Crear el DOM para trabajar con el
			DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newInstance();
			DocumentBuilder creadorDocumento = fabricaCreadorDocumento.newDocumentBuilder();
			Document documento = creadorDocumento.parse(nombreFichero);
			// Seleccionar el elemento raiz
			Element raiz = documento.getDocumentElement();
			// Obtener la lista de vertices
			NodeList listaVertices = raiz.getElementsByTagName("vertex");
			// Rellenar la matriz de distancias con valores altos
			matrizDistancias.rellenarMatrizValoresAltos(listaVertices.getLength());
			// Recorrer la lista de vertices
			for (int i = 0; i < listaVertices.getLength(); i++) {
				// Obtener la lista de distancias del vertice i
				Node vertice = listaVertices.item(i);
				NodeList distanciasVertice = vertice.getChildNodes();
				// Recorrer la lista de distancias del vertice i
				for (int j = 0; j < distanciasVertice.getLength(); j++) {
					// Para cada distancia, almacenar en la matriz 
					Node nodo = distanciasVertice.item(j);
					if (nodo.getNodeType() == Node.ELEMENT_NODE) {
						Node nodoContenido = nodo.getFirstChild();
						if (nodoContenido != null && nodoContenido.getNodeType() == Node.TEXT_NODE) {
							Element distancia = (Element) distanciasVertice.item(j);
							if (distancia.hasAttribute("cost"))
								matrizDistancias.getMatrizDistancias().get(i).set(
										Integer.parseInt(nodoContenido.getNodeValue()),
										Double.parseDouble(distancia.getAttribute("cost")));
						}
					}

				}
			}

		} catch (SAXException ex) {
			System.out.println("ERROR: El formato XML del fichero no es correcto\n" + ex.getMessage());
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("ERROR: Se ha producido un error el leer el fichero\n" + ex.getMessage());
			ex.printStackTrace();
		} catch (ParserConfigurationException ex) {
			System.out.println("ERROR: No se ha podido crear el generador de documentos XML\n" + ex.getMessage());
			ex.printStackTrace();
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
