package clases;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*InfoProblema problema = new InfoProblema();
		problema.leerDatosProblema("src/ficherosXML/att48.xml");
		problema.mostrarMatriz();*/
		CotaSuperior cota = new CotaSuperior("src/ficherosXML/att48.xml");
		cota.calcularCota();
	}

}
