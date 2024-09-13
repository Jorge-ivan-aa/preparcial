package EjerciciosOscar.Recursividad.Clase.Model;

public class Clase2 {
    public void cambiarValor(Estudiante pruebaObjeto)
    {
        pruebaObjeto.setEdad(10);
        System.out.println("Valor modificado en el metodo"+ pruebaObjeto.getEdad());
    }
}