package co.edu.uniquindio.sigecim.preparcial1;

public class Ejercicio3 {

    // Matriz de ejemplo, se puede cambiar el tamaño
    String[][] matriz = {
            {"1", "2"},
            {"3", "4"},
            {"5", "6"},
            {"7", "8"}
    };

    String[][] matriz2 = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"},
            {"10", "11", "12"}
    };

    String[][] matriz3 = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"},
            {"17", "18", "19", "20"},
            {"21", "22", "23", "24"},
            {"25", "26", "27", "28"},
            {"29", "30", "31", "32"},
            {"33", "34", "35", "36"},
            {"37", "38", "39", "40"},
            {"41", "42", "43", "44"},
            {"45", "46", "47", "48"},
            {"49", "50", "51", "52"},
            {"53", "54", "55", "56"},
            {"57", "58", "59", "60"},
            {"61", "62", "63", "64"},
            {"65", "66", "67", "68"},
            {"69", "70", "71", "72"},
            {"73", "74", "75", "76"},
            {"77", "78", "79", "80"},
            {"81", "82", "83", "84"},
            {"85", "86", "87", "88"},
            {"89", "90", "91", "92"},
            {"93", "94", "95", "96"},
            {"97", "98", "99", "100"}
    };

    public static void main(String[] args) {
        Ejercicio3 ejercicio = new Ejercicio3();

        // Crear la matriz transpuesta con dimensiones inversas a la original
        String[][] transpuesta = new String[ejercicio.matriz[0].length][ejercicio.matriz.length];

        // Llamar a la función recursiva para llenar la matriz transpuesta
        ejercicio.transponerMatriz(ejercicio.matriz, transpuesta, 0, 0);

        // Imprimir la matriz transpuesta
        ejercicio.imprimirMatriz(transpuesta, 0, 0);
    }

    // Función recursiva para transponer la matriz
    public void transponerMatriz(String[][] original, String[][] transpuesta, int i, int j) {
        // Si hemos llegado al final de las filas de la matriz original, terminamos
        if (i == original.length) {
            return;
        }

        // Si hemos llegado al final de las columnas de la fila actual, pasamos a la siguiente fila
        if (j == original[i].length) {
            transponerMatriz(original, transpuesta, i + 1, 0);
            return;
        }

        // Colocar el elemento de la fila 'i' y columna 'j' en la posición transpuesta 'j' y 'i'
        transpuesta[j][i] = original[i][j];

        // Llamada recursiva para la siguiente columna
        transponerMatriz(original, transpuesta, i, j + 1);
    }

    // Función recursiva para imprimir la matriz
    public void imprimirMatriz(String[][] matriz, int i, int j) {
        // Si hemos recorrido todas las filas, terminamos
        if (i == matriz.length) {
            return;
        }

        // Imprimir el valor actual
        System.out.print(matriz[i][j] + " ");

        // Si hemos llegado al final de una fila, pasamos a la siguiente fila
        if (j == matriz[i].length - 1) {
            System.out.println();
            imprimirMatriz(matriz, i + 1, 0);
        } else {
            // Si no, seguimos con la siguiente columna
            imprimirMatriz(matriz, i, j + 1);
        }
    }
}
