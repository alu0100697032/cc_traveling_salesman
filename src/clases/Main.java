package clases;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*InfoProblema problema = new InfoProblema("src/ficherosXML/br17.xml");
		problema.mostrarMatriz();*/
		CotaSuperior cota = new CotaSuperior("src/ficherosXML/br17.xml");
		cota.calcularCota();
	}

}
