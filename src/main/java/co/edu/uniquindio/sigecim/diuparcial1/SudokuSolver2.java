package co.edu.uniquindio.sigecim.diuparcial1;

public class SudokuSolver2 {

    // Tablero de Sudoku inicial con algunos valores predefinidos
    private int[][] board = {
            {5, 1, 7, 6, 0, 0, 0, 3, 4},
            {2, 8, 9, 0, 0, 4, 0, 0, 0},
            {3, 4, 6, 2, 0, 5, 0, 9, 0},
            {6, 0, 2, 0, 0, 0, 0, 1, 0},
            {0, 3, 8, 0, 0, 6, 0, 4, 7},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 9, 0, 0, 0, 0, 0, 7, 8},
            {7, 0, 3, 4, 0, 0, 5, 6, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    // Método principal para ejecutar el solucionador de Sudoku
    public static void main(String[] args) {
        SudokuSolver2 solver = new SudokuSolver2();
        if (solver.solveSudoku(0, 0)) {
            solver.printBoard(0, 0);
        } else {
            System.out.println("No se encontró solución.");
        }
    }

    // Método para resolver el Sudoku utilizando backtracking
    public boolean solveSudoku(int row, int col) {
        // Si hemos llegado al final de las filas, el Sudoku está resuelto
        if (row == 9) {
            return true;
        }

        // Si hemos llegado al final de las columnas, pasamos a la siguiente fila
        if (col == 9) {
            return solveSudoku(row + 1, 0);
        }

        // Si la celda actual ya tiene un valor, continuamos con la siguiente
        if (board[row][col] != 0) {
            return solveSudoku(row, col + 1);
        }

        // Intentamos colocar números del 1 al 9 en la celda vacía
        return tryNumber(row, col, 1);
    }

    // Método para intentar colocar un número en una celda y verificar si es válido
    private boolean tryNumber(int row, int col, int num) {
        // Si el número supera 9, no hay solución en esta rama
        if (num > 9) {
            return false;
        }

        // Verificamos si el número es válido en la posición actual
        if (isValid(row, col, num)) {
            board[row][col] = num; // Colocamos el número en la celda
            if (solveSudoku(row, col + 1)) { // Continuamos con la siguiente celda
                return true;
            }
            // Retroceso: removemos el número si no lleva a una solución
            board[row][col] = 0;
        }
        // Intentamos con el siguiente número
        return tryNumber(row, col, num + 1);
    }

    // Método para verificar si un número es válido en una posición dada:
    // verifica si el número es válido en la fila, columna y subcuadrícula 3x3
    private boolean isValid(int row, int col, int num) {
        return isRowValid(row, 0, num) && isColValid(0, col, num)
                && isBoxValid(row - row % 3, col - col % 3, 0, 0, num);
    }

    // Método para verificar si un número es válido en una fila
    private boolean isRowValid(int row, int col, int num) {
        // Si hemos llegado al final de la fila, el número es válido en esta fila
        if (col == 9) {
            return true;
        }
        // Si encontramos el número en la fila, no es válido
        if (board[row][col] == num) {
            return false;
        }
        // Continuamos verificando el siguiente número en la fila
        return isRowValid(row, col + 1, num);
    }

    // Método para verificar si un número es válido en una columna
    private boolean isColValid(int row, int col, int num) {
        // Si hemos llegado al final de la columna, el número es válido en esta columna
        if (row == 9) {
            return true;
        }
        // Si encontramos el número en la columna, no es válido
        if (board[row][col] == num) {
            return false;
        }
        // Continuamos verificando el siguiente número en la columna
        return isColValid(row + 1, col, num);
    }

    // Método para verificar si un número es válido en una subcuadrícula 3x3
    private boolean isBoxValid(int startRow, int startCol, int rowOffset, int colOffset, int num) {
        // Si hemos recorrido todas las filas de la subcuadrícula, el número es válido
        if (rowOffset == 3) {
            return true;
        }
        // Si hemos recorrido todas las columnas de la fila actual, pasamos a la siguiente fila
        if (colOffset == 3) {
            return isBoxValid(startRow, startCol, rowOffset + 1, 0, num);
        }
        // Si encontramos el número en la subcuadrícula, no es válido
        if (board[startRow + rowOffset][startCol + colOffset] == num) {
            return false;
        }
        // Continuamos verificando el siguiente número en la subcuadrícula
        return isBoxValid(startRow, startCol, rowOffset, colOffset + 1, num);
    }

    // Método para imprimir el tablero de Sudoku
    private void printBoard(int row, int col) {
        // Si hemos llegado al final de las filas, terminamos la impresión
        if (row == 9) {
            return;
        }
        // Si hemos llegado al final de las columnas, imprimimos un salto de línea y pasamos a la siguiente fila
        if (col == 9) {
            System.out.println();
            printBoard(row + 1, 0);
            return;
        }
        // Imprimimos el valor de la celda actual seguido de un espacio
        System.out.print(board[row][col] + " ");
        // Continuamos con la siguiente celda en la misma fila
        printBoard(row, col + 1);
    }
}