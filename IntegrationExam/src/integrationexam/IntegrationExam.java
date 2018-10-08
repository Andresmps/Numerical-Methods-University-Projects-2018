package integrationexam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Andrés
 */
public class IntegrationExam {

    static Random random = new Random();
    Scanner scan = new Scanner(System.in);

    ArrayList<Double> valoresDeX = new ArrayList();
    ArrayList<Double> areaPuntoMedio = new ArrayList();
    ArrayList<Double> areaTrapecio = new ArrayList();

    // Sólo es para mostrar los puntos
    ArrayList<String> puntosMedios = new ArrayList();
    ArrayList<String> puntosTrapecio = new ArrayList();
    ArrayList<String> funcionPuntosMedios = new ArrayList();
    ArrayList<String> funcionA = new ArrayList();
    ArrayList<String> funcionB = new ArrayList();

    // Valores por defecto de C y D
    double C = 6.0, D = 9.0;

    public static void main(String[] args) {
        IntegrationExam Menu = new IntegrationExam();
        Menu.menu();
    }

    public void menu() {

        double a, b, promedioPuntoMedio, promedioTrapecio,
                varianzaPuntoMedio, varianzaTrapecio,
                desviacionEstandarPuntoMedio, desviacionEstandarTrapecio;

        int numIntervalos, numRepeticiones;

        // Pide los valores a, b y N
        do {

            System.out.println("Digite los limites de la integración (a,b):");
            System.out.println("Recuerde que el valor de \"a\" debe ser menor que \"b\"");
            System.out.print("a: ");
            a = scan.nextDouble();
            System.out.print("b: ");
            b = scan.nextDouble();
            System.out.println("");
        } while (a >= b);

        System.out.println("Digite el numero N de intervalos:");
        numIntervalos = scan.nextInt();
        System.out.println("Digite el numero de repeticiones");
        numRepeticiones = scan.nextInt();

        for (int i = 0; i < numRepeticiones; i++) {
            valoresDeX.clear();
            puntosMedios.clear();
            puntosTrapecio.clear();
            funcionA.clear();
            funcionB.clear();
            funcionPuntosMedios.clear();
            calcularAreaPorMetodos(a, b, numIntervalos);
        }

        // Promedio
        promedioPuntoMedio = promedio(areaPuntoMedio);
        promedioTrapecio = promedio(areaTrapecio);

        // Varianza
        varianzaPuntoMedio = varianza(promedioPuntoMedio, areaPuntoMedio);
        varianzaTrapecio = varianza(promedioTrapecio, areaTrapecio);

        // Desviacion Estandar
        // Se calcula sacandole la raiz a la varianza
        desviacionEstandarPuntoMedio = Math.sqrt(varianzaPuntoMedio);
        desviacionEstandarTrapecio = Math.sqrt(varianzaTrapecio);

        
        System.out.println("\n\n");
        System.out.println("***Resultados Finales***"+ "\n");

        System.out.println("Punto Fijo:");
        System.out.println("\tPromedio: " + promedioPuntoMedio);
        System.out.println("\tVarianza: " + varianzaPuntoMedio);
        System.out.println("\tDesviación Estandar: " + desviacionEstandarPuntoMedio);
        System.out.println("\tAreas: "+mostrarAreas(areaPuntoMedio) + "\n");

        System.out.println("Trapecio:");
        System.out.println("\tPromedio: " + promedioTrapecio);
        System.out.println("\tVarianza: " + varianzaTrapecio);
        System.out.println("\tDesviación Estandar: " + desviacionEstandarTrapecio);
        System.out.println("\tAreas: "+mostrarAreas(areaTrapecio));

    }

    public void calcularAreaPorMetodos(double a, double b, int numIntervalos) {

        double puntoMedio, deltaX,
                funcionPuntoMedio, funcion_A, funcion_B,
                areaTotalPuntoMedio = 0, areaTotalTrapecio = 0;

        valoresDeX(a, b, numIntervalos);
        deltaX = b - a;

        // Calcula el area de la integral por medio del metodo punto fijo
        for (int i = 1; i < valoresDeX.size(); i++) {

            puntoMedio = (valoresDeX.get(i - 1) + valoresDeX.get(i)) / 2;
            funcionPuntoMedio = funcion(puntoMedio);
            puntosMedios.add(puntoMedio + "");
            funcionPuntosMedios.add(funcionPuntoMedio + "");
            areaTotalPuntoMedio = area(funcionPuntoMedio, deltaX);
        }

        // Calcula el area de la integral por medio del metodo del trapecio
        for (int i = 1; i < valoresDeX.size(); i++) {

            funcion_A = funcion(valoresDeX.get(i - 1));
            funcion_B = funcion(valoresDeX.get(i));
            puntoMedio = (funcion_A + funcion_B) / 2;
            funcionA.add(funcion_A + "");
            funcionB.add(funcion_B + "");
            puntosTrapecio.add(puntoMedio + "");
            areaTotalTrapecio = area(puntoMedio, deltaX);

        }

        areaPuntoMedio.add(areaTotalPuntoMedio);
        areaTrapecio.add(areaTotalTrapecio);

        // Si quieres mostrar todos los datos de punto fijo y trapecio descomenta lo siguiente
        //Desde aquí
//        
//        System.out.println("\n");
//        System.out.println("Valores de X:\n" + valoresDeX + "\n");
//
//        System.out.println("Punto Fijo:");
//        System.out.println("\tArea Total: " + areaTotalPuntoMedio);
//        System.out.println("\tPuntos medios: " + puntosMedios);
//        System.out.println("\tFunciones evaluada en los puntos medios: " + funcionPuntosMedios);
//
//        System.out.println("Trapecio:");
//        System.out.println("\tArea Total: " + areaTotalTrapecio);
//        System.out.println("\tFunciones f(A): " + funcionA);
//        System.out.println("\tFunciones f(B): " + funcionB);
//        System.out.println("\tPuntos medios: " + puntosTrapecio);

        //Hasta aquí
    }

    //   Calcula la varianza de las areas
    //  Recibe una lista con las areas, ya sea las calculadas por punto fijo o trapecio
    //   Realiza la sumatoria de las areas + el promedio de todas y al resultado le resta N - 1 
    public double varianza(double promedio, ArrayList<Double> areas) {

        double sumatoria = 0;

        for (int i = 0; i < areas.size(); i++) {

            double sumaTemp = areas.get(i) - promedio;
            sumatoria += Math.pow(sumaTemp, 2);
        }
        return sumatoria / areas.size();
    }

    // Calcula el promedio de las areas
    // Recibe una lista con las areas, ya sea las calculadas por punto fijo o trapecio
    public double promedio(ArrayList<Double> areas) {

        double promedio = 0;
        
        for (int i = 0; i < areas.size(); i++) {
            
            promedio += areas.get(i);    
        }
        
        return promedio / areas.size();
    }

    /*      Calcula el area 
    
        Donde la altura es:
                 altura = f(C) si es calculada por el punto medio o
                 altura = ( f(a) * f(b) ) / 2 si es calculada por el trapecio
                 delta(x) = b - a
     */
    public double area(double altura, double deltaX) {

        return altura * deltaX;
    }

//    public void valoresX(){
//        
//        valoresDeX.add(1.4234252);
//        
//        System.out.println(valoresDeX);
//        
//    }
//    
    //      Precarga los datos de X con numeros Pseudo-aleatorios
    public void valoresDeX(double a, double b, double N) {

        double rm = 0;
        double valorTemp = 0, rd = 0;

        valoresDeX.add(a);
        valoresDeX.add(b);

        for (int i = 0; i < N - 3; i++) {
        
            rd = random.nextDouble();
            if ((int) (b - a) == 0) {
                valorTemp = rd + a;
            } else {
                rm = (double) random.nextInt((int) (b - a)) + (int) a;
                valorTemp = rd + rm;
            }

            //System.out.println("numeroRandom: ["+valorTemp+"]");
            if (!valoresDeX.contains(valorTemp) && valorTemp < b && valorTemp > a) {
                valoresDeX.add(valorTemp);
            } else {

                i--;
            }

        }
        
        // Organiza los valores de X que han sido generados aleatorios
        valoresDeX.sort(Comparator.naturalOrder());
    }

    // Evalua la función
    public double funcion(double x) {

        double funcion = C + (D * Math.pow(x, 4));
        return Math.sqrt(funcion);
    }
    
    public String mostrarAreas(ArrayList areas){
        
        String mensaje = "{";
        
        for (int i = 0; i < areas.size(); i++) {
            mensaje += "\n\t["+areas.get(i)+"], ";
        }
        mensaje = mensaje.substring(0, mensaje.length()-2);
        mensaje += "}\n";
        
        return mensaje;
    }
}
