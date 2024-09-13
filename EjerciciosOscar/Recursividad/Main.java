package EjerciciosOscar.Recursividad;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int suma = sumarEnteros(n);
        System.out.println("Valor de la suma: "+suma);
    }

    private static int sumarEnteros(int n) {
        if(n == 1){
            return 1;
        }else{
            int valor = sumarEnteros(n-1);
            return valor + n;
        }
    }
}