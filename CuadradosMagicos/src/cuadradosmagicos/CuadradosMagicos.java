package cuadradosmagicos;

import java.util.Scanner;

/**
 *
 * @author Camilo Martínez
 */
//Hello World :v
public class CuadradosMagicos {

    private static final Scanner scan = new Scanner(System.in);
    private static int n, a, b, c, d, e, f;

    public static void main(String[] args) {

        CuadradosMagicos menu = new CuadradosMagicos();
        menu.correrPrograma();

    }

    public void correrPrograma() {

        cuadradoMagico();
        int[][] A = new int[n][n];
        int[] filas = new int[n];
        int[] columnas = new int[n];
        int diagonal = 0;
        int diagonaldi = 0;
        int k;

        //cambiar k < (n * n)   &&   en vez de (k-1) poner k si se quiere iniciar desde 0
        
        for (k = 1; k <= (n * n); k++) {

            int i = (a + (c * (k-1)) + (e * ((k-1) / n))) % n;
            int j = (b + (d * (k-1)) + (f * ((k-1) / n))) % n;

            
            if (i < 0) {
                i += n;
            }
            if (j < 0) {
                j += n;
            }

            A[i][j] = k;

            if (i == j) {
            
                diagonal += k;
            }

            for (int l = 0, s = n - 1; l < n; l++, s--) {

                if (i == l) {
                    filas[l] += A[i][j];
                }

                if (j == l) {
                    columnas[l] += A[i][j];
                }

            }

        }

        for (int l = 0, s = n - 1; l < n; l++, s--) {
            diagonaldi += A[l][s];
        }
        System.out.println("");
        for (int l = 0; l < n; l++) {
            for (int m = 0; m < n; m++) {
                System.out.print("[ " + A[l][m] + " ]  ");
            }
            System.out.println(" ");
        }
        System.out.println("***FILAS***                          ***COLUMNAS***");
        for (int l = 0; l < n; l++) {
            System.out.println("[" + (l + 1) + "] " + filas[l] + "                             [" + (l + 1) + "] " + columnas[l] + " ");

        }
        System.out.println("");
        System.out.println("");
        System.out.println("***DIAGONAL I-D***                     ***DIAGONAL D-I***");
        System.out.println(diagonal +"                        "+ diagonaldi);

        System.out.println(
                "***SI DESEA SALIR DIGITE EL 0***");
        String salir = scan.next();
         
        if (salir.charAt(0) == '0') {
            System.exit(0);
        }

        correrPrograma();
    }

    public int maximoComunDivisor(int a, int b) {

        int aux, resto, max;

        if (a < b) {
            aux = a;
            a = b;
            b = aux;
        }

        while (b != 0) {

            resto = a % b;
            a = b;
            b = resto;

        }

        max = Math.abs(a);
        return max;
    }

    public void cuadradoMagico() {

        System.out.print("n = ");
        n = scan.nextInt();
        System.out.print("a = ");
        a = scan.nextInt();
        System.out.print("b = ");
        b = scan.nextInt();
        System.out.print("c = ");
        c = scan.nextInt();
        System.out.print("d = ");
        d = scan.nextInt();
        System.out.print("e = ");
        e = scan.nextInt();
        System.out.print("f = ");
        f = scan.nextInt();

        //cambiar n * (n * n) - 1 / 2 si se quiere iniciar desde cero
        int sumaMagica = (n * ((n * n) + 1)) / 2;
        int cfde = (c * f) - (d * e);
        int A = (2 * a) % n;
        int A1 = (c + e + 1) % n;
        int B = (2 * b) % n;
        int B1 = (d + f + 1) % n;

        int maxCFDE = maximoComunDivisor(cfde, n);
        int maxCN = maximoComunDivisor(c, n);
        int maxEN = maximoComunDivisor(e, n);
        int maxDN = maximoComunDivisor(d, n);
        int maxFN = maximoComunDivisor(f, n);

        if (maxCFDE == 1) {

            if (maxEN == 1 & maxCN == 1 & maxDN == 1 & maxFN == 1) {
                System.out.println("|||   ES UN CUADRADO MAGICO   |||");
                System.out.println("");
                System.out.println("Y su suma mágica es " + sumaMagica);
            } else {
                if (maxEN == 1 && maxCN == 1) {
                    System.out.println("|||   ES UN CUADRADO MAGICO POR COLUMNAS  |||");
                    System.out.println("");
                    System.out.println("Y su suma mágica es " + sumaMagica);
                }

                if (maxDN == 1 && maxFN == 1) {
                    System.out.println("|||   ES UN CUADRADO MAGICO POR FILAS  |||");
                    System.out.println("");
                    System.out.println("Y su suma mágica es " + sumaMagica);
                }
            }

        } else {
            System.out.println("***No se cumplen las condiciones del teorema***");
            System.out.println("");

        }
        System.out.println("");
        System.out.println("Máximo Común Divisor de (CF - DE, N) = " + maxCFDE);
        System.out.println("Máximo Común Divisor de (C,N) = " + maxCN + "\nMáximo Común Divisor de (E,N) = " + maxEN);
        System.out.println("Máximo Común Divisor de (D,N) = " + maxDN + "\nMáximo Común Divisor de (F,N) = " + maxFN);

    }

}
