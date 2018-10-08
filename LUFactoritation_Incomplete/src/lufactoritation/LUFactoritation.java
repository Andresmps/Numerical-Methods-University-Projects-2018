package lufactoritation;

import java.util.Scanner;

/**
 *
 * @author camil
 */
public class LUFactoritation {

    private static final Scanner scan = new Scanner(System.in);
    private static int[][] A = new int[3][3];
    private static int[][] L = new int[3][3];
    private static int[][] U = new int[3][3];
    private static int[][] prueba = new int[3][3];

    public static void main(String[] args) {

        int c = 3;
        int fila, columna,fila1;
        System.out.println("Digite los elementos de la matriz");

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                System.out.print("A[" + i + "]" + "[" + j + "] = ");
                A[i][j] = scan.nextInt();

            }
        }

        lowerAndUpperM(A, c);

        if (A[0][0] == 0) {
            permutado(A, c);
        }

        if (A[1][0] != 0) {
            fila1 = 0;
            fila = 1;
            columna = 0;
            LUFact(A, c, fila, columna,fila1);
        }

        if (A[2][0] != 0) {
            fila1 = 0;
            fila = 2;
            columna = 0;
            LUFact(A, c, fila, columna,fila1);
        }
        if (A[2][1] != 0) {
            fila1 = 1;
            fila = 2;
            columna = 1;
            LUFact(A, c, fila, columna,fila1);
        }

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {

                prueba[i][j] = U[i][j] * L[j][i];

            }

        }

        // [0][0] * [0][0]
        // [0][1] * [1][0]
        // [0][2] * [2][0]
        // [1][0] * [0][1]
        // [1][1] * [1][1]
        // [1][2] * [2][1]
        // [2][0] * [0][2]
        // [2][1] * [1][2]
        // [2][2] * [2][2]
        
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("prueba[" + i + "]" + "[" + j + "] = " + prueba[i][j] + "  ");
            }
            System.out.println("");
        }
        

    }

    public static void permutado(int A[][], int c) {

        int[] B = new int[c];
        int[] C = new int[c];

        B = A[0].clone();
        C = A[1].clone();

        for (int i = 0; i < c; i++) {
            A[0][i] = C[i];
            A[1][i] = B[i];
        }

    }

    public static void LUFact(int A[][], int c, int fila, int columna, int fila1) {

        int[] B = new int[c];
        int[] C = new int[c];
        
        int a = U[fila1][columna];
        int b = U[fila][columna];

        for (int i = 0; i < c; i++) {
            B[i] = U[fila1][i];
            C[i] = U[fila][i];
        }

        for (int i = 0; i < c; i++) {
            B[i] *= -b;
            C[i] *= a;
        }
        
        L[fila][columna] = -(U[fila][columna]);
        
        for (int i = 0; i < c; i++) {
            C[i] += B[i];
        }
        for (int i = 0; i < c; i++) {
            U[fila][i] = C[i];
        }
        for (int i = 0; i < c; i++) {
            
        }
        System.out.println("");
        for (int i = 0; i < c; i++) {
            System.out.println("U =" + U[fila][i]);
        }
        
        System.out.println("");        
        
        
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("A[" + i + "]" + "[" + j + "] = " + A[i][j] + "  ");
            }
            System.out.println("");
        }

        System.out.println("");
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("U[" + i + "]" + "[" + j + "] = " + U[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("");
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("L[" + i + "]" + "[" + j + "] = " + L[i][j] + "  ");
            }
            System.out.println("");
        }

        
        System.out.println("");
        
        
    }

    public static void lowerAndUpperM(int A[][], int c) {

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                if (i == j) {
                    L[i][j] = 1;
                } else {
                    L[i][j] = 0;
                }
                U[i][j] = A[i][j];

            }
        }

    }

}
