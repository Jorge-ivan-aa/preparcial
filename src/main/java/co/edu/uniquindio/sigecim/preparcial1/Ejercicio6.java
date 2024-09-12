package co.edu.uniquindio.sigecim.preparcial1;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio6 {

    public class Persona {
        private int edad;
        private String nombre;

        public Persona(int edad, String nombre) {
            this.edad = edad;
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public String getNombre() {
            return nombre;
        }
    }

    public static void main(String[] args) {
        Ejercicio6 ejercicio = new Ejercicio6();
        Persona p1 = ejercicio.new Persona(5, "Juan");
        Persona p2 = ejercicio.new Persona(7, "Maria");
        Persona p3 = ejercicio.new Persona(1, "Carlos");
        Persona p4 = ejercicio.new Persona(3, "Ana");
        Persona p5 = ejercicio.new Persona(6, "Luis");
        Persona p6 = ejercicio.new Persona(45, "Sofia");
        Persona p7 = ejercicio.new Persona(13, "Pedro");
        Persona p8 = ejercicio.new Persona(89, "Laura");
        Persona p9 = ejercicio.new Persona(2, "Andres");
        Persona p10 = ejercicio.new Persona(28, "Diana");
        Persona p11 = ejercicio.new Persona(496, "Jorge");
        Persona p12 = ejercicio.new Persona(8128, "Fernanda");
        Persona p13 = ejercicio.new Persona(11, "Camila");
        Persona p14 = ejercicio.new Persona(4, "Esteban");
        Persona p15 = ejercicio.new Persona(8, "Valentina");
        Persona p16 = ejercicio.new Persona(89, "Miguel");
        Persona p17 = ejercicio.new Persona(31, "Isabella");
        Persona p18 = ejercicio.new Persona(37, "Alejandro");
        Persona p19 = ejercicio.new Persona(43, "Catalina");
        Persona p20 = ejercicio.new Persona(10, "Gabriel");

        Persona[][] personas = {
                {p1, p2, p3, p4},
                {p5, p6, p7, p8},
                {p9, p10, p11, p12},
                {p13, p14, p15, p16},
                {p17, p18, p19, p20}
        };

        List<Persona> listaPrimos = new ArrayList<>();
        List<Persona> listaPerfectos = new ArrayList<>();

        recorrerMatriz(personas, 0, 0, listaPrimos, listaPerfectos);

        System.out.println("Personas con edades primas:");
        imprimirLista(listaPrimos, 0);

        System.out.println("\nPersonas con edades perfectas:");
        imprimirLista(listaPerfectos, 0);
    }

    // Método recursivo para imprimir la lista de personas
    private static void imprimirLista(List<Persona> lista, int index) {
        if (index >= lista.size()) {
            return;
        }
        Persona p = lista.get(index);
        System.out.println(p.getNombre() + " - Edad: " + p.getEdad());
        imprimirLista(lista, index + 1);
    }

    // Función recursiva para recorrer la matriz
    private static void recorrerMatriz(Persona[][] matriz, int i, int j, List<Persona> listaPrimos, List<Persona> listaPerfectos) {
        if (i >= matriz.length) {
            return; // Fin de la matriz
        }

        if (j >= matriz[i].length) {
            recorrerMatriz(matriz, i + 1, 0, listaPrimos, listaPerfectos); // Avanza a la siguiente fila
            return;
        }

        // Verificar si la edad es un número primo
        // Matriz[i][j] es un objeto de la clase Persona
        if (esPrimo(matriz[i][j].edad, 2)) {
            listaPrimos.add(matriz[i][j]);
        }

        // Verificar si la edad es un número perfecto
        // Matriz[i][j] es un objeto de la clase Persona
        if (esPerfecto(matriz[i][j].edad, 1, 0)) {
            listaPerfectos.add(matriz[i][j]);
        }

        // Avanzar a la siguiente columna
        recorrerMatriz(matriz, i, j + 1, listaPrimos, listaPerfectos);
    }

    // Función recursiva para verificar si un número es primo
    private static boolean esPrimo(int n, int divisor) {
        if (n < 2) {
            return false;
        }
        if (divisor > Math.sqrt(n)) {
            return true;
        }
        if (n % divisor == 0) {
            return false;
        }
        return esPrimo(n, divisor + 1);
    }

    // Función recursiva para verificar si un número es perfecto
    private static boolean esPerfecto(int n, int divisor, int suma) {
        if (divisor == n) {
            return suma == n;
        }
        if (n % divisor == 0) {
            suma += divisor;
        }
        return esPerfecto(n, divisor + 1, suma);
    }
}
