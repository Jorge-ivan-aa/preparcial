package EjerciciosOscar.Recursividad.Clase;

public class EncontrarMenor {
    public static void main(String[] args) {
        int[] arreglo = {3,5,4,18,5,22,};
        int inicio = 0;
        int fin = arreglo.length-1;
        int numero = encontrarMenor(inicio,fin,arreglo);
        System.out.println("Menor es = "+numero);
    }

    private static int encontrarMenor(int inicio, int fin, int[] arreglo) {
        if(inicio == fin){
            return arreglo[inicio];
        }else {
            int numero = encontrarMenor(inicio+1,fin,arreglo);
            return Math.min(numero,arreglo[inicio]);
        }
    }
}