

package javaapplication31;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Camilo Martínez
 */
public class Main {

    Scanner scan = new Scanner(System.in);
    ArrayList<Double> error = new ArrayList();
    int iteracion = 0;
    double P = 0;    
    
    public static void main(String[] args) {
        
        Main main = new Main();
        main.rootAproximation();
        
        
    }
    // Calcula la aproximacion de la raiz
    public void rootAproximation(){
        int a = scan.nextInt();
        int b = scan.nextInt();
        double raizA;
        
        
        // Valida que los valores f(a) y f(b) sean de signos contrarios, de lo contrario pide de nuevo los datos
        if((ecuacion(a) > 0 && ecuacion(b) < 0) || (ecuacion(a) < 0 && ecuacion(b) > 0)){
            raizA = binarySearch(a, b); 
            System.out.println("\n*** Por lo tanto, la aproximación de la raiz por binarySearch = "+raizA+" ***");
            System.out.println("Y tuvo un total de "+iteracion+" iteraciones.");
            
        }else{
            System.out.println("***Los valores a y b deben de ser de signo opuesto***");
            System.out.println("Ingrese de nuevo los valores");
            rootAproximation();
        }
        
        
    }
    
    public double binarySearch(double a, double b){
        
        iteracion++;
        double error = errorRelativo(a, b);
        
        System.out.println("Intervalo(a, b) = ("+a+", "+b+")");
        System.out.println("\nEn la iteración #"+iteracion+" f(P) = "+ecuacion(((a+b)/2))+" y el error relativo es = "+error);
        System.out.println("Y P = "+((a+b)/2));
        
        // Evalua si f(p) = 0, si lo es retorna p el cual sera la aproximación de la raiz 
        if(ecuacion((a+b)/2) == 0) 
            return (a+b)/2;
        
        // Evalua si f(p)*f(a) > 0, si lo es se llama recursivamente, pero esta vez con el intervalo (a, p) 
        else if (ecuacion(a)*ecuacion(((a+b)/2)) < 0) 
            return binarySearch(a, (a+b)/2);
        // Evalua si f(p)*f(a) < 0, si lo es se llama recursivamente, pero esta vez con el intervalo (p, b) 
        else if (ecuacion(a)*ecuacion(((a+b)/2)) > 0) 
            return binarySearch((a+b)/2, b);
        
        
        return  -1; 
    } 
    
    // Calcula la ecuacion en cualquier n que se le envie
    public double ecuacion(double n){
        
        return Math.pow(n, 3) + 4*(Math.pow(n, 2)) - 10;
    }
    
    // Calcula el error relativo
    public double errorRelativo(double a, double b) {

        double errorAprox = 0;
        double puntoMendio1 = 0;
        double puntoMendio2 = 0;
        error.add(a);
        error.add(b);

        if (iteracion > 1) {
            puntoMendio1 = Math.abs(((error.get(2) + error.get(3)) / 2.0));
            puntoMendio2 = Math.abs(((error.get(0) + error.get(1)) / 2.0));
            
            if (puntoMendio2 != 0) {
                errorAprox = (puntoMendio2-puntoMendio1 / puntoMendio2);
            
                error.remove(3);
                error.remove(2);
                
                return errorAprox;
            } else {
                return 0;
            }

        }
        return ecuacion((a + b) / 2);
    }

    
    
}
