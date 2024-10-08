package EjerciciosOscar.Recursividad.Clase;

public class MainMultiple {
    public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		int[] arreglo = {1,2,3,4,5};
//		int n = 4;
//		int resultado = 0;
////		recorrerArreglo(arreglo);
//		resultado = sumaEnteros(n);
//		System.out.println("resultado: "+resultado);

        int[] arreglo = {1,2,5,6,7,5,5};
        int inicio = 0;
        int fin = arreglo.length-1;//6
        int elem = 5;
        System.out.println("Numero apariciones= "+ contarApariciones(arreglo, inicio, fin, elem));
    }

    private static int contarApariciones(int[] arreglo, int inicio, int fin,  int elem) {
        if(inicio > fin){
            return 0;
        }else{
            if(arreglo[inicio] == elem){
                return contarApariciones(arreglo, inicio+1, fin, elem) +1;
            }else{
                return contarApariciones(arreglo, inicio+1, fin, elem);
            }
        }
    }

    private static void recorrerArreglo(int[] arreglo) {
        for (int i = arreglo.length-1; i >=0 ; i--) {
            System.out.println(arreglo[i]);
        }
    }

    private static int sumaEnteros(int n){
        if(n == 1){
            return 1;
        }
        else{
            return sumaEnteros(n-1)+n;
        }
    }
}