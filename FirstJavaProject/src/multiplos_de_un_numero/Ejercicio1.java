package multiplos_de_un_numero;

import controlador.Controlador;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controlador objeto = new Controlador();
        System.out.println("Digite un numero: ");
        objeto.setNumUno(sc.nextInt());
        objeto.proceso();
        System.out.println("Gracias por su colaboración");
        System.out.println("Hasta luego");

    }

}
