package co.edu.uniquindio.sigecim.preparcial1;

public class Ejercicio5 {
    // Matriz que representa el parqueadero
    String[][] parqueadero = {
            {"L", "", "L", "D", "R1", "L", ""},
            {"L", "", "L", "C", "", "L", ""},
            {"", "", "", "C", "", "", ""},
            {"C", "", "", "C", "D", "D", ""},
            {"C", "", "", "", "", "L", ""},
            {"C", "", "C", "", "", "L", ""},
            {"C", "", "C", "", "C", "C", ""},
            {"", "", "C", "", "", "", ""},
            {"C", "", "C", "", "C", "", "C"},
            {"C", "", "R", "", "C", "", "R"},
            {"", "", "R", "", "C", "C", "R"},
            {"E", "", "R", "", "", "", "R2"}
    };

    public static void main(String[] args) {
        Ejercicio5v2 e = new Ejercicio5v2();
        e.estacionarCarros(2); // Estacionar 2 carros
    }

    // Método recursivo para estacionar una cantidad de carros
    public void estacionarCarros(int cantidad) {
        // Caso base: si no hay más carros por estacionar, retornar
        if (cantidad == 0) {
            return;
        }

        // Intentar mover el carro desde la posición inicial (11, 0)
        if (moverCarro(11, 0)) {
            System.out.println("Carro estacionado.");
            imprimirParqueadero(0, 0); // Imprimir el estado del parqueadero
        } else {
            System.out.println("No se pudo estacionar el carro.");
        }

        // Resetear el camino marcado y llamar recursivamente para el siguiente carro
        resetearCamino(0, 0);
        estacionarCarros(cantidad - 1);
    }

    // Método para mover el carro en el parqueadero
    public boolean moverCarro(int i, int j) {
        // Verificar límites del parqueadero
        if (i < 0 || j < 0 || i >= parqueadero.length || j >= parqueadero[0].length) {
            return false;
        }

        // Verificar si se ha encontrado un espacio de parqueo (R1 o R2)
        if (parqueadero[i][j].equals("R1") || parqueadero[i][j].equals("R2")) {
            parqueadero[i][j] = "C"; // Marcar el espacio como ocupado
            return true;
        }

        // Verificar si la celda actual es transitable
        if (!parqueadero[i][j].equals("L") && !parqueadero[i][j].equals("") && !parqueadero[i][j].equals("E") && !parqueadero[i][j].equals("F")) {
            return false;
        }

        // Marcar la celda actual como visitada
        parqueadero[i][j] = "+";

        // Intentar mover el carro en las cuatro direcciones posibles
        if (moverCarro(i, j + 1)) { // Derecha
            return true;
        }
        if (moverCarro(i + 1, j)) { // Abajo
            return true;
        }
        if (moverCarro(i - 1, j)) { // Arriba
            return true;
        }
        if (moverCarro(i, j - 1)) { // Izquierda
            return true;
        }

        // Marcar la celda como no transitable y retornar false
        parqueadero[i][j] = "F";
        return false;
    }

    // Método recursivo para resetear el camino marcado con "+"
    public void resetearCamino(int i, int j) {
        // Si estamos fuera de los límites del parqueadero, retornar
        if (i >= parqueadero.length) {
            return;
        }
        if (j >= parqueadero[0].length) {
            resetearCamino(i + 1, 0); // Pasar a la siguiente fila
            return;
        }
        // Si la celda está marcada con "+", la reseteamos
        if (parqueadero[i][j].equals("+")) {
            parqueadero[i][j] = "";
        }
        // Llamada recursiva para la siguiente celda en la fila
        resetearCamino(i, j + 1);
    }

    // Método recursivo para imprimir el estado del parqueadero
    public void imprimirParqueadero(int i, int j) {
        // Si estamos fuera de los límites del parqueadero, retornar
        if (i >= parqueadero.length) {
            return;
        }
        if (j >= parqueadero[0].length) {
            System.out.println(); // Nueva línea al final de la fila
            imprimirParqueadero(i + 1, 0); // Pasar a la siguiente fila
            return;
        }
        // Imprimir la celda actual
        System.out.print(parqueadero[i][j] + " ");
        // Llamada recursiva para la siguiente celda en la fila
        imprimirParqueadero(i, j + 1);
    }
}