
package cellimage;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author camil
 */
public class CellImage {

    private static Scanner scan = new Scanner(System.in);
    private Datos datos = new Datos();
    private int c = 0;

    public static void main(String[] args) {

        CellImage menu = new CellImage();
        menu.mostrarMenu();
    }

    public void mostrarMenu() {

        if (c == 0) {
            setCell();
        }
        c++;

        String mensaje = "";

        mensaje += "\tMenú";
        mensaje += "\n1) Agregar nueva celula";
        mensaje += "\n2) Mostrar información de las celulas";
        mensaje += "\n3) Eliminar celula";
        mensaje += "\n4) Cambiar el área de la celula";
        mensaje += "\n5) Cambiar el nuclei de la celula";
        mensaje += "\n6) Cambiar el ancho de la celula";
        mensaje += "\n7) Cambiar la altura de la celula";
        mensaje += "\n8) Salir";

        System.out.println(mensaje);

        String opcion = scan.nextLine();

        switch (Integer.parseInt(opcion)) {

            case 1:
                agregarCelula();
                break;
            case 2:
                mostrarCelula();
                break;
            case 3:
                eliminarCelula();
                break;
            case 4:
                cambiarArea();
                break;
            case 5:
                cambiarNuclei();
                break;
            case 6:
                cambiarWidth();
                break;
            case 7:
                cambiarHeight();
                break;
            case 8:
                System.exit(0);
                break;

        }
        mostrarMenu();
    }

    public void agregarCelula() {
        
        System.out.println("Ingrese los datos de la celula separados por '&'.");
        System.out.println(" <CellArea> & <Nucleic Cound> & <CellWidth> & <CellHeight>");

        String str = scan.nextLine();
        String[] splito = str.split("&");
        
        datos.newCell(Integer.parseInt(splito[0]), Integer.parseInt(splito[1]), Integer.parseInt(splito[2]), Integer.parseInt(splito[3]));

        System.out.println("");
        System.out.println("La celula se ha guardado correctamente.");

    }

    public void mostrarCelula() {

        System.out.println(datos.Tostring());

    }

    public void cambiarArea() {

        System.out.println("Ingrese el numero de la celula y su nuevo área");
        System.out.println(" <CellNumber> & <NucleicArea>");
        String str = scan.nextLine();
        String[] splito = str.split("&");

        datos.changeArea((Integer.parseInt(splito[0])) - 1, Integer.parseInt(splito[1]));

        System.out.println("");
        System.out.println("El area de la celula ha sido cambiado");

    }

    public void cambiarNuclei() {

        System.out.println("Ingrese el numero de la celula y su nuevo Nuclei Count");
        System.out.println(" <CellNumber> & <Nucleic Cound>");
        String str = scan.nextLine();
        String[] splito = str.split("&");

        datos.changeNucleiCount((Integer.parseInt(splito[0])) - 1, Integer.parseInt(splito[1]));

        System.out.println("");
        System.out.println("El Nuclei Count de la celula ha sido cambiado");
    }

    public void cambiarWidth() {

        System.out.println("Ingrese el numero de la celula y su nuevo ancho");
        System.out.println(" <CellNumber> & <CellWidth> ");
        String str = scan.nextLine();
        String[] splito = str.split("&");

        datos.changeCellWidth((Integer.parseInt(splito[0])) - 1, Integer.parseInt(splito[1]));

        System.out.println("");
        System.out.println("El ancho de la celula ha sido cambiado");
    }

    public void cambiarHeight() {

        System.out.println("Ingrese el numero de la celula y su nueva altura");
        System.out.println(" <CellNumber> & <CellHeight>");

        String str = scan.nextLine();
        String[] splito = str.split("&");

        datos.changeCellHeight((Integer.parseInt(splito[0])) - 1, Integer.parseInt(splito[1]));

        
        
        System.out.println("");
        System.out.println("La altura de la celula ha sido cambiado");
    }

    public void eliminarCelula() {
        System.out.println("Ingrese el numero de la celula");
        String indice = scan.nextLine();
        datos.deletecell((Integer.parseInt(indice)) - 1);

        System.out.println("");
        System.out.println("La celula ha sido eliminada");
    }

    public void setCell() {

        datos.newCell(441, 4, 37, 34);
        datos.newCell(352, 2, 33, 34);
        datos.newCell(281, 2, 26, 31);
        datos.newCell(324, 2, 33, 32);
        datos.newCell(488, 4, 35, 37);
        datos.newCell(601, 4, 40, 42);
        datos.newCell(405, 4, 34, 36);
        datos.newCell(232, 0, 30, 26);
        datos.newCell(442, 2, 36, 38);
        datos.newCell(325, 0, 32, 33);
        datos.newCell(313, 4, 29, 31);

    }

}
//