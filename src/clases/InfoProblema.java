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
	
	private ArrayList<ArrayList<Double>> matrizDistancias;
	
	/*
	 * Constructor
	 */
	
	public InfoProblema(){
		matrizDistancias = new ArrayList<ArrayList<Double>>();			
	}

	
	/*
	 * Método de lectura
	 */
	
	public void leerDatosProblema(String nombreFichero){
		try {
		    DocumentBuilderFactory fábricaCreadorDocumento = DocumentBuilderFactory.newInstance();
		    DocumentBuilder creadorDocumento = fábricaCreadorDocumento.newDocumentBuilder();
		    Document documento = creadorDocumento.parse(nombreFichero);
		    //Obtener el elemento raíz del documento
		    Element raiz = documento.getDocumentElement();

		    //Obtener la lista de nodos que tienen etiqueta "EMPLEADO"
		    NodeList listaVertices = raiz.getElementsByTagName("vertex");
		    //Recorrer la lista de empleados
		    for(int i=0; i<listaVertices.getLength(); i++) {   
		        //Obtener de la lista un empleado tras otro
		        Node vertice = listaVertices.item(i);
		        System.out.println("Vértice "+i);
		        System.out.println("==========");    

		        //Obtener la lista de los datos que contiene ese empleado
		        NodeList distanciasVertice = vertice.getChildNodes();
		        //Recorrer la lista de los datos que contiene el empleado
		        for(int j=0; j<distanciasVertice.getLength(); j++) {
		            //Obtener de la lista de datos un dato tras otro
		            Node distancia = distanciasVertice.item(j);

		            //Comprobar que el dato se trata de un nodo de tipo Element
		            if(distancia.getNodeType()==Node.ELEMENT_NODE) {
		                //Mostrar el nombre del tipo de dato
		                System.out.print(distancia.getNodeName()+": ");
		                //El valor está contenido en un hijo del nodo Element
		                Node datoContenido = distancia.getFirstChild();                        
		                //Mostrar el valor contenido en el nodo que debe ser de tipo Text
		                if(datoContenido!=null && datoContenido.getNodeType()==Node.TEXT_NODE)
		                    System.out.println(datoContenido.getNodeValue());
		            }
		        }
		        //Se deja un salto de línea de separación entre cada empleado
		        System.out.println();
		    }
		 
		} catch (SAXException ex) {
		    System.out.println("ERROR: El formato XML del fichero no es correcto\n"+ex.getMessage());
		    ex.printStackTrace();
		} catch (IOException ex) {
		    System.out.println("ERROR: Se ha producido un error el leer el fichero\n"+ex.getMessage());
		    ex.printStackTrace();
		} catch (ParserConfigurationException ex) {
		    System.out.println("ERROR: No se ha podido crear el generador de documentos XML\n"+ex.getMessage());
		    ex.printStackTrace();
		}
	}
	
	/**
	 * @return the matrizDistancias
	 */
	public ArrayList<ArrayList<Double>> getMatrizDistancias() {
		return matrizDistancias;
	}

	/**
	 * @param matrizDistancias the matrizDistancias to set
	 */
	public void setMatrizDistancias(ArrayList<ArrayList<Double>> matrizDistancias) {
		this.matrizDistancias = matrizDistancias;
	}
}
