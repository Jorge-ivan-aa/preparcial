package co.edu.uniquindio.sigecim.preparcial1;

public class Ejercicio1 {

    public String[][] carcel = {
            {"", "P", "X", "", "P", "P", "", "P"},
            {"", "P", "P", "", "P", "P", "", "P"},
            {"", "", "", "", "", "", "", ""},
            {"P", "", "P", "P", "", "P", "P", ""},
            {"P", "", "X", "P", "", "P", "P", ""},
            {"", "", "", "", "", "", "", "G"},
            {"P", "X", "P", "", "P", "P", "", "P"}
    };

    private static final int TOTAL_PRESOS = 26; // Cantidad total de presos esperados
    private boolean[][] visitado;  // Matriz para saber qué celdas ya han sido visitadas
    private boolean puntoControl = false; // Variable para saber si ya se llegó al punto de control

    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args) {
        Ejercicio1 m = new Ejercicio1();
        m.visitado = new boolean[m.carcel.length][m.carcel[0].length];  // Inicializamos la matriz de visitados
        int[] totalPresos = {0};  // contador de presos
        m.resolver(0, 0, totalPresos);  // empezar desde la posición (0, 0)
        m.imprimirCarcel(0, 0);  // imprimimos la cárcel con el recorrido marcado
        System.out.println("Total de presos encontrados: " + totalPresos[0]);

        // Comprobación final
        if (m.puntoControl) {
            if (totalPresos[0] == TOTAL_PRESOS) {
                System.out.println("Todos los presos han sido encontrados. No se escapó ningún preso.");
            } else {
                System.out.println("Se escaparon " + (TOTAL_PRESOS - totalPresos[0]) + " presos.");
            }
        } else {
            System.out.println("No se pudo llegar al punto de control (5,7).");
        }
    }

    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public void resolver(int i, int j, int[] totalPresos) {
        paso(i, j, totalPresos);  // recorrer toda la cárcel accesible
    }

    private boolean paso(int x, int y, int[] totalPresos) {
        // Verificar si estamos fuera de los límites o si la celda ya fue visitada
        if (x < 0 || y < 0 || x >= carcel.length || y >= carcel[0].length || visitado[x][y] || carcel[x][y].equals("X")) {
            return false;  // No continuamos si la celda ya fue visitada o está fuera de los límites o es un muro ("X")
        }

        // Marcar la celda como visitada
        visitado[x][y] = true;

        // Si es un preso y aún no lo hemos contado, lo contamos
        if (carcel[x][y].equals("P")) {
            totalPresos[0]++;
        }

        // Si hemos llegado al punto de control 'G', no detenemos el recorrido aún
        if (x == 5 && y == 7) {
            puntoControl = true;
            return false;  // No debemos parar aquí, necesitamos recorrer todos los caminos
        }

        // Marcamos la celda con '*' si es un espacio vacío
        if (carcel[x][y].equals("")) {
            carcel[x][y] = "*";
        }

        // Intentamos movernos en el patrón especificado: derecha, abajo, izquierda, arriba
        boolean result = false;
        if (paso(x, y + 1, totalPresos)) {  // mover hacia la derecha
            result = true;
        }
        if (paso(x + 1, y, totalPresos)) {  // mover hacia abajo
            result = true;
        }
        if (paso(x - 1, y, totalPresos)) {  // mover hacia arriba
            result = true;
        }
        if (paso(x, y - 1, totalPresos)) {  // mover hacia la izquierda
            result = true;
        }

        // Si no encontramos una solución y estamos en una celda vacía, marcamos con 'F' de retroceso
        if (!result && carcel[x][y].equals("*")) {
            carcel[x][y] = "F";
        }

        return result;
    }

    private void imprimirCarcel(int i, int j) {
        if (carcel.length - 1 == i) {  // verifica si está en la última fila
            if (carcel[0].length - 1 == j) {  // verifica si está en la última columna
                System.out.println(carcel[i][j]);
            } else {
                System.out.print(carcel[i][j] + " ");
                imprimirCarcel(i, j + 1);  // como no está en la última columna, aumenta la columna
            }
        } else {
            if (carcel[0].length - 1 == j) {  // verifica si está en la última columna
                System.out.println(carcel[i][j] + " ");
                imprimirCarcel(i + 1, 0);  // reinicia las columnas y aumenta la fila en uno
            } else {
                System.out.print(carcel[i][j] + " ");
                imprimirCarcel(i, j + 1);  // aumenta la columna
            }
        }
    }
}
