package co.edu.uniquindio.sigecim.diuparcial1;

import java.util.ArrayList;

public class Punto3 {

    // Dada una matriz de String de 4 x 5 conformada por números, sumar los dígitos de un número de forma
    // recursiva y si la suma es mayor a 10 agregar el número a un ArrayList.

    // Para recorrer la matriz se debe hacer de forma recursiva retrocediendo en filas y avanzando en columnas.
    // Función a utilizar recorrerMatriz(matriz,i,j, listaNumeros) Para verificar la suma de dígitos de un número se debe hacer de forma recursiva.
    // Funcion a utilizar verificarSumaDigitos(identificar los parámetros que necesita)

    String[][] matriz =
            {
                    {"454", "1010", "4141", "4444", "234"},
                    {"100", "2163", "5456", "222", "444"},
                    {"1001", "0", "99", "111", "5654"},
                    {"13", "89", "6", "112", "555"}
            };

    ArrayList<String> listaNumeros = new ArrayList<>();

    public static void main(String[] args) {
        Punto3 p = new Punto3();
        p.recorrerMatriz(p.matriz, 0, 0, p.listaNumeros);
        System.out.println(p.listaNumeros);

    }

    private void recorrerMatriz(String[][] matriz, int i, int j, ArrayList<String> listaNumeros) {
        if (i < matriz.length) {
            if (j < matriz[i].length) {
                verificarSumaDigitos(matriz[i][j], 0);
                recorrerMatriz(matriz, i, j + 1, listaNumeros);
            } else {
                recorrerMatriz(matriz, i + 1, 0, listaNumeros);
            }
        }
    }

    private int verificarSumaDigitos(String s, int i) {
        if (i < s.length()) {
            int num = Integer.parseInt(s.charAt(i) + "");
            int sum = num + verificarSumaDigitos(s, i + 1);
            if (i == 0 && sum > 10) {
                listaNumeros.add(s);
            }
            return sum;
        }
        return 0;
    }
}
