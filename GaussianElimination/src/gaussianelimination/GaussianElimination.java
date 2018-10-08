/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaussianelimination;

import java.util.Scanner;

/**
 *
 * @author Andrés Martínez
 */
public class GaussianElimination {

    /**
     * @param args the command line arguments
     */
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        double[][] matrix = new double[2][3];
        double M, X_2, X_1;


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scan.nextDouble();
            }
        }
        

        /*
0,003
59,14
59,17
5,29
-6,14
46,78

         */
//        matrix[0][0] = 0.003;
//        matrix[0][1] = 59.14;
//        matrix[0][2] = 59.17;
//        matrix[1][0] = 5.29;
//        matrix[1][1] = -6.14;
//        matrix[1][2] = 46.78;

        System.out.println("Matrix:");
        System.out.println("------------------------");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrix[i].length - 1; j++) {
                System.out.print(" " + matrix[i][j] + "  ");
            }
            System.out.print("|");
            for (int j = matrix[i].length - 1; j < matrix[i].length; j++) {
                System.out.print("  " + matrix[i][j] + " ");
            }
            System.out.println("\n------------------------");
        }

        if (matrix[0][0] < matrix[1][0]) {

            
//            matrix[0][0] = 5.29;
//            matrix[0][1] = -6.14;
//            matrix[0][2] = 46.78;
//            matrix[1][0] = 0.003;
//            matrix[1][1] = 59.14;
//            matrix[1][2] = 59.17;

            for (int i = 0; i < matrix[0].length; i++) {
                double aux = matrix[0][i];
                matrix[0][i] = matrix[1][i];
                matrix[1][i] = aux;
            }

            System.out.println("\n***Intercambio de filas***\n");
        }

        System.out.println("Matrix:");
        System.out.println("------------------------");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrix[i].length - 1; j++) {
                System.out.print(" " + matrix[i][j] + "  ");
            }
            System.out.print("|");
            for (int j = matrix[i].length - 1; j < matrix[i].length; j++) {
                System.out.print("  " + matrix[i][j] + " ");
            }
            System.out.println("\n------------------------");
        }

        double number = matrix[1][0] / matrix[0][0];
        M = Math.round(number * 10000d) / 10000d;

        for (int i = 0; i < matrix[1].length; i++) {
            matrix[1][i] = Math.round((matrix[1][i] - (matrix[0][i] * M)) * 1000d) / 1000d;
        }

        X_2 = Math.round((matrix[1][2] / matrix[1][1]) * 10000d) / 10000d;
        X_1 = Math.round(((matrix[0][2] - (matrix[0][1] * X_2)) / matrix[0][0]) * 10000d) / 10000d;;

        System.out.println("\n***Despues de pivotear***\n");

        System.out.println("Matrix:");
        System.out.println("--------------------------");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrix[i].length - 1; j++) {
                System.out.print(" " + matrix[i][j] + "  ");
            }
            System.out.print("|");
            for (int j = matrix[i].length - 1; j < matrix[i].length; j++) {
                System.out.print("  " + matrix[i][j] + " ");
            }
            System.out.println("\n--------------------------");
        }

        System.out.println("\nM = " + M);
        System.out.println("X_1 = " + X_1);
        System.out.println("X_2 = " + X_2);
    }

}
