package co.edu.uniquindio.sigecim.preparcial1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio2 {

    // Matriz con las palabras a evaluar
    String[][] matriz = {
            {"vacio", "carro", "baul", "perro"},
            {"colombia", "casa", "moto", "caza"},
            {"llanta", "reir", "archivo", "silla"},
            {"cocina", "ola", "ave", "freir"}
    };

    // Lista que almacenará las palabras con dos vocales seguidas
    ArrayList<String> listaPalabras = new ArrayList<>();

    public static void main(String[] args) {
        Ejercicio2 ejercicio = new Ejercicio2();
        ejercicio.recorrerMatriz(ejercicio.matriz, 0, 0, ejercicio.listaPalabras);
        System.out.println("Palabras con vocales seguidas: " + ejercicio.listaPalabras);
    }

    // Método recursivo para recorrer la matriz
    public void recorrerMatriz(String[][] matriz, int i, int j, ArrayList<String> listaPalabras) {
        // Verificamos si estamos fuera de los límites de la matriz
        if (i >= matriz.length) {
            return; // Termina si recorremos toda la matriz
        }

        // Verificamos la palabra actual si tiene dos vocales seguidas
        if (verificarVocalesSeguidas(matriz[i][j], 0)) {
            listaPalabras.add(matriz[i][j]); // Añadir palabra a la lista si cumple la condición
        }

        // Si hemos llegado al final de una fila, pasamos a la siguiente fila
        if (j == matriz[i].length - 1) {
            recorrerMatriz(matriz, i + 1, 0, listaPalabras); // Ir a la siguiente fila
        } else {
            recorrerMatriz(matriz, i, j + 1, listaPalabras); // Ir a la siguiente columna
        }
    }

    // Método recursivo para verificar si una palabra tiene dos vocales seguidas
    public boolean verificarVocalesSeguidas(String palabra, int i) {
        // Vocales a verificar
        List<Character> vocales = Arrays.asList('a', 'e', 'i', 'o', 'u');

        // Caso base: si hemos llegado al final de la palabra
        if (i >= palabra.length() - 1) {
            return false; // No hay dos vocales seguidas
        }

        // Si encontramos dos vocales seguidas, retornamos true
        if (vocales.contains(palabra.charAt(i)) && vocales.contains(palabra.charAt(i + 1))) {
            return true;
        }

        // Llamada recursiva para el siguiente carácter
        return verificarVocalesSeguidas(palabra, i + 1);
    }
}
