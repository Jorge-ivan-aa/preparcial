package EjerciciosOscar.Recursividad.Clase;

import EjerciciosOscar.Recursividad.Clase.Model.Clase2;
import EjerciciosOscar.Recursividad.Clase.Model.Estudiante;

public class Parametros_PorReferencia {
    public static void main(String[] args) {
        //Paso por referencia
        Estudiante pruebaObjeto = new Estudiante();
        System.out.println("Valor del objeto antes de modificar: "+pruebaObjeto.getEdad());

        Clase2 clase2 = new Clase2();
        clase2.cambiarValor(pruebaObjeto);
        System.out.println("Valor del objeto al cambiarlo: "+pruebaObjeto.getEdad());
    }
}