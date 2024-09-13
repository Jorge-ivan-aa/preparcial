package EjerciciosOscar.Excepciones;

public class Main2 {
    public static void main(String[] args) {
        testExcepciones();
        test2();
    }

    private static void test2() {
        //bloque 1
        //bloque 2
        try {
            //bloque3
            //bloque4
        }
        catch (ArithmeticException e) {
            //bloque 13
        }
        catch (NumberFormatException e) {
            //bloque 15
        }
        catch (Exception e) {
            //bloque 5
            try {
                //bloque6
                //bloque7
            } catch (Exception e1) {
                //bloque8
            }
            finally {
                //bloque 9
            }
            //bloque 10
        }
        finally {
            //bloque 11
        }
        //bloque 12
    }

    private static void testExcepciones() {
        // Bloque 1: Declaraciones iniciales
        String str = "100";
        String strInvalido = "abc";
        int resultado = 0;

        // Bloque 2: Más declaraciones y posibles configuraciones
        int divisor = 0; // Esto causará una excepción de división por cero

        try {
            // Bloque 3: Conversión de String a número (posible NumberFormatException)
            //int numero = Integer.parseInt(strInvalido);  // Esto lanzará NumberFormatException

            // Bloque 4: División por cero (posible ArithmeticException)
            resultado = 10 / 0;  // Esto lanzará ArithmeticException

        } catch (NumberFormatException e) {
            // Bloque 15: Manejo de excepción de formato numérico incorrecto
            System.out.println("Error: Formato de número inválido.");
            e.printStackTrace();

        } catch (Exception e) {
            // Bloque 5: Manejo genérico de excepciones
            System.out.println("Error: Excepción general.");
            e.printStackTrace();
            resultado = 10 / 0;

            try {
                // Bloque 6: Intentar manejar algo más dentro del bloque catch
                String nullString = null;
                int longitud = nullString.length();  // Esto lanzará NullPointerException
                // Bloque 7: Más lógica
            } catch (Exception e1) {
                // Bloque 8: Manejo de excepción dentro del bloque catch
                System.out.println("Error interno: NullPointerException.");
                e1.printStackTrace();
            } finally {
                // Bloque 9: Bloque finally dentro del catch
                System.out.println("Ejecutando finally interno.");
            }
            // Bloque 10: Continuación del catch después del bloque interno
        } finally {
            // Bloque 11: Bloque finally que siempre se ejecuta
            System.out.println("Bloque finally externo ejecutado.");
        }

        // Bloque 12: Lógica posterior al try-catch-finally
        System.out.println("Resultado final: " + resultado);
    }
}