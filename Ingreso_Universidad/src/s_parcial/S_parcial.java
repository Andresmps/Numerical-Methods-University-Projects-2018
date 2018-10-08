package s_parcial;

import java.util.Scanner;

// Hola Mundo :V

public class S_parcial {

    private static Scanner sc = new Scanner(System.in);
    private static int estudiantesMat = 0;
    private static int estudiantesSis = 0;
    private static int estudiantesInd = 0;
    private static double montoMatematicas = 0; 
    private static double montoSitemas = 0;
    private static double montoIndustrial = 0;

    public static void main(String[] args) {
        mostrar();

    }

    public static void mostrar() {

        System.out.println("Bienvenido a la Konrad Lorenz");
        System.out.println("");
        System.out.println("1) Consultar Codigos de Programas.");
        System.out.println("2) Consultar valor de matricula por programa academico.");
        System.out.println("3) Realizar matricula.");
        System.out.println("4) Salir.");

        String opcion = sc.nextLine();
        switch (Integer.parseInt(opcion)) {
            case 1:
                codigos();
                break;
            case 2:
                valorProgramaAcademico();
                break;
            case 3:
                realizarMatricula();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                mostrar();
        }
        mostrar();
    }

    public static void realizarMatricula() {

        String nombre;
        String codigo;
        String modalidaPago;
        String programaA;
        int precio;
        String si = "si";
        String no = "no";
        String E = "E";
        String T = "T";
        String porcentaje = "0%";
        double precioTotal;
        double valorDescuento;

        System.out.println("Digite sus nombres y apellidos");
        nombre = sc.nextLine();

        do {
            System.out.println("Digite el codigo del programa academico");
            codigo = sc.nextLine();
        } while (Integer.parseInt(codigo) != 614182005 && Integer.parseInt(codigo) != 506181067 && Integer.parseInt(codigo) != 506182000);

        System.out.println("Digite la modalidad de pago. E/T/C");
        modalidaPago = sc.nextLine();

        programaA = programaAcademico(codigo);
        precio = precio(codigo);
        valorDescuento = metodoPago(modalidaPago, precio);
        precioTotal = precio - valorDescuento;

        System.out.println("¿Desea continuar con el proceso de matricula?");
        String respuesta = sc.nextLine();

        if (modalidaPago.equalsIgnoreCase(E)) {
            porcentaje = "10%";
        } else if (modalidaPago.equalsIgnoreCase(T)) {
            porcentaje = "5%";
        }

        if (respuesta.equalsIgnoreCase(si)) {

            System.out.println("¿Desea ver el formato de inscripcion?");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase(si)) {
                formatoMatricula(codigo, programaA, nombre, modalidaPago, porcentaje, precio, valorDescuento, precioTotal);
            }
            System.out.println("¿Desea ver el numero de matriculados de la universidad?");
            String ans = sc.nextLine();
            if (ans.equalsIgnoreCase(si)) {
                universidad(programaA, precioTotal);
            }

        }

    }

    public static void universidad(String programaA, double precioTotal) {

        String mensaje = "";
        String matemáticas = "Matemáticas";
        String sistemas = "Ingenieria de Sistemas";
        String industrial = "Ingenieria Industrial";
        String mate = "M";
        String sis = "I";
        String ind = "I";

        if (programaA.equalsIgnoreCase(sistemas)) {
            estudiantesSis++;
            montoSitemas += precioTotal;
        } else if (programaA.equalsIgnoreCase(industrial)) {
            estudiantesInd++;
            montoIndustrial += precioTotal;
        } else if (programaA.equalsIgnoreCase(matemáticas)) {
            estudiantesMat++;
            montoMatematicas += precioTotal;
        }

        mensaje += "--------------------------------------------------------------------------------------";
        mensaje += "\n Programa              Cantidad Matriculas          Monto             |";
        mensaje += "\n    " + sis + "                       " + estudiantesSis + "                      " + montoSitemas;
        mensaje += "\n    " + ind + "                       " + estudiantesInd + "                      " + montoIndustrial;
        mensaje += "\n    " + mate + "                       " + estudiantesMat + "                      " + montoMatematicas;
        mensaje += "\n-------------------------------------------------------------------------------------";

        System.out.println(mensaje);

    }

    public static void formatoMatricula(String codigo, String programaA, String nombre, String modalidaPago, String porcentaje, int precio, double valorDescuento, double precioTotal) {
        String mensaje = "";

        mensaje += "---------------------------------------------------------------------------------------------------";
        mensaje += "\nCódigo programa: " + codigo + "                Nombre Programa: " + programaA;
        mensaje += "\nEstudiante Nombres y Apellidos: " + nombre;
        mensaje += "\nModalidad de Pago: " + modalidaPago + "               Porcentaje Descuento: " + porcentaje;
        mensaje += "\nValor Semestre: " + precio + "            Valor Descuento: " + valorDescuento + "      Total a pagar: " + precioTotal;
        mensaje += "\n-------------------------------------------------------------------------------------------------";
        System.out.println(mensaje);

    }

    public static String programaAcademico(String codigo) {

        String maths = "614182005";
        String sistemas = "506181067";
        String industrial = "506182000";
        String programa = "";

        if (codigo.equals(maths)) {
            programa = "Matemáticas";

        } else if (codigo.equals(sistemas)) {
            programa = "Ingenieria de Sistemas";

        } else if (codigo.equals(industrial)) {
            programa = "Ingenieria Industrial";

        }
        return programa;

    }

    public static int precio(String codigo) {

        String maths = "614182005";
        String sistemas = "506181067";
        String industrial = "506182000";
        int precio = 0;

        if (codigo.equals(maths)) {
            precio = 3100000;
        } else if (codigo.equals(sistemas)) {

            precio = 4000000;
        } else if (codigo.equals(industrial)) {

            precio = 4500000;
        }
        return precio;

    }

    public static double metodoPago(String modalidaPago, int precio) {
        String efectivo = "E";
        String tarjeta = "T";
        String credito = "C";
        double descuento = 0.0;

        if (modalidaPago.equalsIgnoreCase(efectivo)) {
            descuento = precio * 0.1;
        } else if (modalidaPago.equalsIgnoreCase(tarjeta)) {
            descuento = precio * 0.05;
        } else if (modalidaPago.equalsIgnoreCase(credito)) {
            descuento = 0.0;
        } else {
            System.out.println("Valor Erroneo");
            System.out.println("");
            realizarMatricula();
        }
        return descuento;
    }

    public static void valorProgramaAcademico() {
        System.out.print("Digite el codigo del programa academico:");
        String codigo = sc.nextLine();
        if (Integer.parseInt(codigo) == 614182005) {
            System.out.println("");
            System.out.println("Programa Matemáticas");
            System.out.println("Valor: 3,100,000");
        } else if (Integer.parseInt(codigo) == 506181067) {
            System.out.println("");
            System.out.println("Programa Ingenieria de Sistemas");
            System.out.println("Valor: 4,000,000");
        } else if (Integer.parseInt(codigo) == 506182000) {
            System.out.println("");
            System.out.println("Programa Ingenieria Industrial");
            System.out.println("Valor: 4,500,000");
        } else {
            System.out.println("***Ha digitado un codigo erroneo***");
            
        }

    }

    public static void codigos() {
        String mensaje = "";

        mensaje += "\n-------------------------------------------------------------";
        mensaje += "\n/   Matemáticas    / Ingenieria sistemas / Ingenieria industrial/ ";
        mensaje += "\n-------------------------------------------------------------";
        mensaje += "\n/    614182005     /     506181067       /     506182000     /";
        mensaje += "\n-------------------------------------------------------------";

        System.out.println(mensaje);

    }
}
