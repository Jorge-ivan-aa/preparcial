package EjerciciosOscar.Recursividad.Clase;

public class ContarCeros {
    public static void main(String[] args) {
        int indice = 0;
        int[] arreglo = {1,2,0,1,5,0,13,0,0};
        int numero = contarCeros(indice, arreglo);
        System.out.println("Numero de ceros = "+numero);
    }

    private static int contarCeros(int indice, int[] arreglo) {
        if(indice > arreglo.length-1) {
            return 0;
        }else{
            if(arreglo[indice] == 0){
                return contarCeros(indice+1,arreglo)+1;
            }else{
                return contarCeros(indice+1,arreglo);
            }
        }
    }
}