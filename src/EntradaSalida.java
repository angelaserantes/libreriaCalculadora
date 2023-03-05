import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Libreria para sacar por dispositivos un mensaje y
 * pedir por consola distintos tipos de datos
 * @version 0.4
 * @author Angela Serantes
 */
public class EntradaSalida {
    /**
     * opción de uso de la consola para imprimir un mensaje
     */
    public static final int SALIDA_CONSOLA = 1;
    /**
     * opción de uso de utilizar una ventana en el escritorio para sacar un mensaje
     */
    public static final int SALIDA_WINDOW = 2;



    /**
     * opción para recoger un string
     */
    public static final int STRING_COMENTARIO = 1;
    /**
     * opción para recoger un entero
     */
    public static final int INT_COMENTARIO =2;

    /**
     * opción para recoger un float
     */
    public static final  int ENTRADA_FLOAT = 3;

    /**
     * opción para recoger una operacion
     */
    public static final int ENTRADA_OPERACION =4;

    private void EntradaSalida(){};

    /**
     * Salida por ventana o consala de un mensaje
     * @param msj cadena que queremos imprimir
     * @param device dispositivo de salida<br>consola: SALIDA_CONSOLA<br>ventana:SALIDA_VENTANA
     * @return si es true: correcto si no false
     */
    public static boolean salida(String msj, int device) {
        switch (device) {
            case SALIDA_CONSOLA:
                try {
                    System.out.println("Consola: " + msj);
                    return true;
                } catch (Exception e) {
                    return false;
                }

            case SALIDA_WINDOW:
                try {
                    JOptionPane.showMessageDialog(null,"Sale por un ventana " + msj);
                    return true;
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            default:
                return false;
        }
    }
    /**
     * Salida por ventana o consala de un número entero
     * @param edad cadena que queremos imprimir
     * @param device dispositivo de salida<br>consola: SALIDA_CONSOLA<br>ventana:SALIDA_VENTANA
     * @return si es true: correcto si no false
     */

    public static boolean salidanumero(int edad, int device) {
        switch (device) {
            case SALIDA_CONSOLA:
                try {
                    System.out.println("Consola: " + edad);
                    return true;
                } catch (Exception e) {
                    return false;
                }

            case SALIDA_WINDOW:
                try {
                    JOptionPane.showMessageDialog(null,"Sale por un ventana " + edad);
                    return true;
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            default:
                return false;
        }
    }


    /**
     * Salida por ventana o consola del resultado, llama a la función de calcular de la clase Calculadora
     * @param device dispositivo de salida<br>consola: SALIDA_CONSOLA<br>ventana:SALIDA_VENTANA
     * @return si es true: correcto si no false
     */

    public static boolean salidaFloats(int device){
        float resultadofinal=Calculadora.Calcular();

        switch (device) {

            case SALIDA_CONSOLA:
                try {
                   System.out.println("Consola: " + resultadofinal);
                    return true;
                } catch (Exception e) {
                    return false;
                }

            case SALIDA_WINDOW:
                try {
                  JOptionPane.showMessageDialog(null,"Sale por un ventana " + resultadofinal);
                    return true;
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            default:
                return false;
        }
    }



    /**
     * método para obtener un String por consola
     * @param device dispositivo de salida<br>consola: SALIDA_CONSOLA<br>ventana:SALIDA_VENTANA
     * @return null
     */
    public static String entradaString(int device){
        switch (device){
            case STRING_COMENTARIO:
                try {
                    System.out.println("Dime tu nombre");
                    Scanner datos = new Scanner(System.in);
                    return datos.nextLine();
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    return null;
                }
            default:
                return null;
        }


    }


    /**
     * método para obtener un entero por consola
     * @param device dispositivo de salida<br>consola: SALIDA_CONSOLA<br>ventana:SALIDA_VENTANA
     * @return edad
     */

    public static int entradaInt(int device) {
        boolean edadOK = false;
        int edad = 0;
        Scanner datos = new Scanner(System.in);
        while (!edadOK) {
            switch (device) {
                case INT_COMENTARIO:

                    try {
                        edadOK = true;
                        System.out.println("Dime tu edad");
                        edad = datos.nextInt();
                        //return datos.nextInt();
                    } catch (InputMismatchException ex) {
                        edadOK = false;
                        ex.printStackTrace();
                        datos.next();

                    }

            }
        } return edad;

    }


    /**
     * variable para almacenar numero1, obteniendo el primer operador
     */
    static float numero1;

    /**
     * variable para almacenar numero2, obteniendo el segundo operador
     */
    static float numero2;


    /**
     * método para obtener los operadores decimales por consola
     * @param device dispositivo de salida<br>consola: SALIDA_CONSOLA<br>ventana:SALIDA_VENTANA
     * @return operadores obtenidos
     */
    public static EntradaSalida leerFloat(int device) {
            boolean numerosOK = false;
        while (!numerosOK){
            switch (device){
                case ENTRADA_FLOAT:
                    Scanner operadores = new Scanner(System.in);

                    try {
                        numerosOK = true;
                        System.out.println("Introduce un número o un radicando en caso de querer calcular una raíz");
                        numero1 = operadores.nextFloat();
                        try {
                            numerosOK = true;
                            System.out.println("Introduce un número o un índice en caso de querer calcular una raíz");
                            numero2 = operadores.nextFloat();
                        }catch (Exception e){
                            System.out.println("Introduce un número decimal válido");
                            numerosOK = false;
                        }
                    }catch (Exception e){
                        System.out.println("Introduce un número decimal válido");
                        numerosOK = false;
                    }

            }

        }

    return null;
    }

    /**
     * método para obtener el tipo de operación que se quiere realizar por consola
     * @param device dispositivo de salida<br>consola: SALIDA_CONSOLA<br>ventana:SALIDA_VENTANA
     * @return operación ha realizar
     */

    static String operacion=null;
    public static String leerOperacion(int device){
        switch (device) {
            case ENTRADA_OPERACION:
                try {
                    System.out.println("¿Qué operación quieres realizar? " + " sumar, restar, multiplicar, dividir, o raices");
                    Scanner datos = new Scanner(System.in);
                    operacion = datos.nextLine();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                return operacion;
        }

        return null;
    }




}


