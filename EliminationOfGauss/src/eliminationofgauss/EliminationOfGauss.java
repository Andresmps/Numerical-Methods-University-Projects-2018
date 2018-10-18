/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eliminationofgauss;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Camilo Martínez
 */
public class EliminationOfGauss {

    static Scanner scan = new Scanner(System.in);
    double[][] matriz_A;
    double[] vector_Xs;
    int n;

    public static void main(String[] args) {

        EliminationOfGauss main = new EliminationOfGauss();
        main.menu();
    }

    public void menu() {

        System.out.print("Digite el orden de la matriz: ");
        n = scan.nextInt();

        matriz_A = new double[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print("A [" + (i + 1) + "]" + "[" + (j + 1) + "] = ");
                matriz_A[i][j] = scan.nextDouble();
            }
        }
        
        // Para precargar la matriz debe comentar el ciclo que esta sobre esta linea 
        // Al momento de correr el programa y le piden el orden de la matriz debe colocar 4  
//        precargarMatriz();
        
        System.out.println("\n***Matriz A aumentada***\n");
        mostrarMatrix();
        ErrorFilaZero();
        
        System.out.println("\n***Matriz triangular superior***\n");
        matrizTriangularSuperior();
        mostrarMatrix();
        
        sustitucionX();
        mostrarVector();
    }

    public void precargarMatriz() {

        Random random = new Random();
        int opcion = random.nextInt(2) + 1;

        switch (opcion) {
            case 1:
                double[][] matrix1 = {
                    {1, 1, 0, 3, 4},
                    {2, 1, -1, 1, 1},
                    {3, -1, -1, 2, -3},
                    {-1, 2, 3, -1, 4}
                };
                matriz_A = matrix1;
                break;
            case 2:
                double[][] matrix2 = {
                    {1, -1, 2, -1, -8},
                    {2, -2, 3, -3, -20},
                    {1, 1, 1, 0, -2},
                    {1, -1, 4, 3, 4}
                };
                matriz_A = matrix2;
                break;
        }
    }

    public void sustitucionX() {

        vector_Xs = new double[n];

        vector_Xs[n - 1] = matriz_A[n - 1][n] / matriz_A[n - 1][n - 1];

        for (int i = n - 2; i >= 0; i--) {
            vector_Xs[i] = (matriz_A[i][n] - sumatoriaX(i)) / matriz_A[i][i];
        }
    }

    public double sumatoriaX(int fila) {

        double suma = 0;

        for (int i = fila + 1; i < n; i++) {
            suma += matriz_A[fila][i] * vector_Xs[i];
        }

        return suma;
    }

    public void matrizTriangularSuperior() {

        int k = 0;
        double m = 0;
        do {

            if (matriz_A[k][k] == 0) {
                ErrorDiagonalZero(k);
                matrizTriangularSuperior();
            } else {
                for (int i = 1 + k; i < n; i++) {
                    m = matriz_A[i][k] / matriz_A[k][k];
                    for (int j = 0; j < n + 1; j++) {

                        matriz_A[i][j] -= m * matriz_A[k][j];
                    }

                }
                //mostrarMatrix();
                k++;
            }
        } while (matriz_A[n - 1][n - 2] != 0);

        if (matriz_A[n - 1][n - 1] == 0) {

            mostrarMatrix();
            System.out.println("\nEl sistema de ecuaciones no tiene una solución única");
            System.exit(0);
        }
    }

    public void ErrorFilaZero() {

        boolean condicion = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {

                if (matriz_A[i][j] != 0) {
                    condicion = false;
                }
            }
        }
        if (condicion) {
            System.out.println("El sistema de ecuaciones no tiene una solución única");
            System.exit(0);
        }

    }

    public void ErrorDiagonalZero(int columna) {

        int columna2 = 0;
        for (int i = columna + 1; i < n; i++) {
            if (matriz_A[i][columna] != 0) {
                columna2 = i;
            }
        }

        for (int i = 0; i < n + 1; i++) {
            double temp = matriz_A[columna][i];
            matriz_A[columna][i] = matriz_A[columna2][i];
            matriz_A[columna2][i] = temp;

        }

    }

    public void mostrarMatrix() {

        for (int i = 0; i < n; i++) {
            System.out.print("| ");
            for (int j = 0; j < n + 1; j++) {
                if (j != n) {

                    if (matriz_A[i][j] < 0) {
                        System.out.print((Math.round(matriz_A[i][j] * 10d) / 10d) + "  ");
                    } else {
                        System.out.print((Math.round(matriz_A[i][j] * 10d) / 10d) + "   ");
                    }

                } else {
                    System.out.print(" | " + (Math.round(matriz_A[i][j] * 10d) / 10d) + "  ");
                }

            }
            System.out.println("|");
        }
    }

    public void mostrarVector() {

        System.out.println("\nValores de X");
        String mensaje = "{ ";
        for (int i = 0; i < n; i++) {
            mensaje += "\nX_[" + (i + 1) + "] = " + (Math.round(vector_Xs[i] * 10d) / 10d) + ", ";
        }

        mensaje = mensaje.substring(0, mensaje.length() - 2);
        mensaje += "\n}";
        System.out.println(mensaje);
    }
}
