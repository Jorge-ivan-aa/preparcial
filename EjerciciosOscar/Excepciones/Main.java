package EjerciciosOscar.Excepciones;

public class Main {
    public static void main(String[] args) {
        prueba1();
    }

    private static void prueba1() {
        int a = 5;
        int b = 2;
        int c = 0;
        Cliente cliente = null;
        try{
            c = a/b;
            cliente.setNombre("Pedro");
        }
        catch(ArithmeticException e){
            System.out.println("Se genero un problerma: "+e.getMessage());
        }catch(Exception e){
            System.out.println("Error general");
        }

        System.out.println("Valor de C: "+c);
    }
}