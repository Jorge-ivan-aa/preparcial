package EjerciciosOscar.Recursividad.Clase;

import EjerciciosOscar.Recursividad.Clase.Model.Clase;

public class Parametros_PorValor {
    public static void main(String[] args) {
        //Paso por valor
        int valor = 5;
        System.out.println("Valor antes de cambiarlo: "+valor);
        Clase clase = new Clase();
        clase.cambiarValor(valor);
        System.out.println("Valor despues de cambiarlo: "+valor);
    }
}