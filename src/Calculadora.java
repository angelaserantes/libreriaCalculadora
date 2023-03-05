/**
 * Libreria para calcular las cuatro operaciones básicas
 * suma, resta, multiplicación y división
 * @version 0.2
 * @author Angela Serantes
 */



public class Calculadora {

    /**
     *constante que indica la opción de sumar
     */
    public static final String SUMAR = "sumar";

    /**
     *constante que indica la opción de restar
     */
    public static final String RESTAR = "restar";

    /**
     *constante que indica la opción de multiplicar
     */
    public static final String MULTIPLICAR = "multiplicar";

    /**
     *constante que indica la opción de dividir
     */
    public static final String DIVIDIR = "dividir";

    public static final String RAICES =  "raices";


    /**
     * variable operacion que indica la operación a realizar
     */



    /**
     * método que calcula el resultado de la operación aritmética deseada
     * @return resultado operación
     */
    public  static float Calcular(){


        float numero1 = EntradaSalida.numero1;
        float numero2 = EntradaSalida.numero2;
        String operacion = EntradaSalida.operacion;

        switch (operacion){
            case SUMAR:
                return numero1 + numero2;
            case RESTAR:
                return numero1 - numero2;
            case MULTIPLICAR:
                return numero1 * numero2;
            case DIVIDIR:
                if (numero2==0){
                    System.out.println("No se puede realizar la operación");
                }
                return numero1/numero2;
            case RAICES:
                if (numero2 == 2){
                    return (float) Math.sqrt(numero1);
                } else if (numero2 == 3) {
                    return (float) Math.cbrt(numero1);
                }else{
                    throw new IllegalArgumentException("No es un índice correcto");
                }
            default:
                System.out.println("No se puede realizar la operación");
        }
        return 0.0f;
    }
}
