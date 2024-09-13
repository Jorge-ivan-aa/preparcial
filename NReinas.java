import javax.swing.*;

public class NReinas {
	// creo el tablero
	public static void main(String[] args) {
		String[][] tablero = { { " ", " ", " ", " " }, { " ", " ", " ", " " }, { " ", " ", " ", " " },
				{ " ", " ", " ", " " } };
		boolean ward = true;
		int tam = 0;

		do {
			ward = true;
			try {
				//le solicito al usuario que ingrese el tamaño de filas y columnas del tablero
				tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del tablero"));
			} catch (NumberFormatException e) {
				//Lanzo una Excepcion para que el dato sea solo llenado con numeros
				JOptionPane.showMessageDialog(null, "Error, el dato ingresado es invalido", "Error",
						JOptionPane.WARNING_MESSAGE);
				ward = false;
			}
		} while (ward == false);
		tablero = generarTablero(tam);
		ubicarReina(tablero, 0);
	}
	// utilizo recursividad para recorrer el tablero y poder ubicar a la reina
	public static void ubicarReina(String[][] tablero, int etapa) {

		for (int i = 0; i < tablero.length; i++) {
			if (isValido(tablero, i, etapa)) {
				tablero[i][etapa] = "M";

				if (etapa < tablero.length - 1) {
					ubicarReina(tablero, etapa + 1);
				} else {
					imprimirMatriz(tablero);
					System.out.println("_________________________ ");
				}

				tablero[i][etapa] = " ";
			}

		}
	}

	public static boolean isValido(String[][] tablero, int i, int etapa) {
		// inicializamos que en la fila 0 hasta donde se ubique la reina este vacia
		for (int x = 0; x < etapa; x++) {
			if (tablero[i][x].equals("M")) {
				return false;
			}
		}
		// se evaluara a la diagonal hacia atras
		for (int j = 0; j < tablero.length && (i - j) >= 0 && (etapa - j) >= 0; j++) {
			// se resta i(etapa) con la j
			if (tablero[i - j][etapa - j].equals("M")) {
				return false;
			}

		}
		// aca se evalua la Diagonal hacia delante ...de la reina
		for (int j = 0; j < tablero.length && (i + j) < tablero.length && etapa - j >= 0; j++) {

			if (tablero[i + j][etapa - j].equals("M")) {
				return false;
			}
		}

		return true;

	}
	// Metodo para general el tablero de las reinas
	public static String[][] generarTablero(int length) {
		String[][] res = new String[length][length];
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
				res[i][j] = " ";
			}
		}
		return res;
	}
	//Este metodo lo utilizare para imprimir la matriz
	public static void imprimirMatriz(String[][] tablero) {
		for (String[] strings : tablero) {
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(strings[j] + ",");
			}
			System.out.println();
		}
	}
}