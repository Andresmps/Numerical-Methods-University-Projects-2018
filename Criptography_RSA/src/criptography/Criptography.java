package criptography;

/**
 *
 * @author Camilo Martínez
 */
//Hola Mundo
import java.util.Scanner;
import java.math.BigInteger;

public class Criptography {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Criptography menu = new Criptography();
        System.out.println(menu.euclidesExtendido(8, 7, 8));
        // Mira si e y phi de e son primos realtivos
        //menu.maximoComunDivisor();
        
        // Calcula la potencia de cualquier p numero en el modulo e o d
        //menu.cuentasAMano();

        // Calcula la multiplicacion de numeros modulo n
        //menu.modMultiplicacion();
        
        // Calcula el inverso de e
        //menu.euclidesD();
        
        // Cifra y decifra el mensaje
        //menu.menu();
    }

    public void euclidesD(){
        
        System.out.print("p: ");
        int p = scan.nextInt();
        System.out.print("q: ");
        int q = scan.nextInt();
        System.out.print("e: ");
        int e = scan.nextInt();
        int phiN = (p-1)*(q-1);
        
        int d = euclidesExtendido(phiN, e, phiN);
        
        System.out.println("d: "+d);
    }
    
    public void cuentasAMano() {

        System.out.print("P: ");
        int p = scan.nextInt();
        System.out.print("e: ");
        int e = scan.nextInt();
        System.out.print("mod: ");
        int modulo = scan.nextInt();
        BigInteger congruencia = new BigInteger("" + p);
        BigInteger eOd = new BigInteger("" + e);
        BigInteger mod = new BigInteger("" + modulo);

        BigInteger o = congruencia.pow(e);
        BigInteger t = congruencia.modPow(eOd, mod);

        System.out.println(p + "^" + e + "=" + o);
        System.out.println("Es congruente con: " + t + " (mod " + mod + ")");

    }

    public void modMultiplicacion() {

        System.out.println("Digite el numero de numeros a multiplicar");
        int k = scan.nextInt();        
        BigInteger congruencia = new BigInteger("1");
        for (int i = 0; i < k; i++) {
            System.out.print("Digite el numero "+i+": ");
            congruencia = congruencia.multiply(scan.nextBigInteger());
        }
        System.out.println("p: "+congruencia);
        System.out.print("mod: ");
        int modulo = scan.nextInt();
        

        BigInteger mod = new BigInteger("" + modulo);

        BigInteger t = congruencia.mod(mod);

        System.out.println("Es congruente con " + t + " (mod " + mod + ")");

    }

    public void maximoComunDivisor() {

        System.out.print("p: ");
        int p = scan.nextInt();
        System.out.print("q: ");
        int q = scan.nextInt();
        System.out.print("e: ");
        int e = scan.nextInt();

        int a = (p - 1) * (q - 1);
        int b = e;
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

        System.out.println("MCD (e, (p-1)*(q-1) ) = " + max);

    }

    public void menu() {

        System.out.println("Digite el mensaje: ");
        String msj = scan.nextLine();
        String msj1 = "";
        int c = 0;
        String mensaje = "";

        for (int i = 0; i < msj.length(); i++) {
            if (i != 4 * i) {
                msj1 += msj.charAt(i);
            } else {
                msj1 += " " + msj.charAt(i);
            }

            if (msj.charAt(i) != ' ') {
                mensaje += msj.charAt(i);

            }
        }

        c = mensaje.length();

        convertidorMensaje(mensaje, c, msj);

    }

    public void convertidorMensaje(String mensaje, int c, String mensaje1) {

        System.out.print("Digite los primos p y q: ");
        int p = scan.nextInt();
        int q = scan.nextInt();
        System.out.print("Digite e: ");
        int e = scan.nextInt();
        int n = p * q;
        char[] letras = new char[c];
        String numb = "";
        String numero = "";

        for (int i = 0; i < letras.length; i++) {
            letras[i] = mensaje.charAt(i);
            if (i % 2 != 0) {
                numero += numeros(letras[i]) + " ";
            } else {
                numero += numeros(letras[i]);
            }
        }

        if (c % 2 != 0) {
            numero += "24";
        }

        String[] splito = numero.split(" ");

        int[] cifrado = new int[splito.length];
        int[] cifradoE = new int[splito.length];
        int[] cifradoD = new int[splito.length];
        String[] cifrad = new String[splito.length];
        String[] cifradE = new String[splito.length];
        String[] cifradD = new String[splito.length];

        for (int i = 0; i < splito.length; i++) {
            cifrado[i] = Integer.parseInt(splito[i]);

            if (cifrado[i] < 10) {
                numb = "000" + cifrado[i];
            } else if (cifrado[i] < 100) {
                numb = "00" + cifrado[i];
            } else if (cifrado[i] < 1000) {
                numb = "0" + cifrado[i];
            } else {
                numb = "" + cifrado[i];
            }
            cifrad[i] = numb;
        }
        numb = "";
        for (int i = 0; i < cifrado.length; i++) {
            cifradoE[i] = e(cifrado[i], n, e);

            if (cifradoE[i] < 10) {
                numb = "000" + cifradoE[i];
            } else if (cifradoE[i] < 100) {
                numb = "00" + cifradoE[i];
            } else if (cifradoE[i] < 1000) {
                numb = "0" + cifradoE[i];
            } else {
                numb = "" + cifradoE[i];
            }
            cifradE[i] = numb;
        }
        int phiN = (p - 1) * (q - 1);

        int d = euclidesExtendido(phiN, e, phiN);

        for (int i = 0; i < cifrado.length; i++) {
            cifradoD[i] = e(cifradoE[i], n, d);

        }

        numb = "";
        String num1, num2, numb1, numb2;
        String mensajeDecifrado = "";
        String mensajeArreglado = "";
        String mensajeCifrado = "";

        for (int i = 0, j = 1; i < cifrado.length; i++) {
            numb = "" + cifradE[i];
            numb1 = "" + numb.charAt(0) + numb.charAt(1);
            numb2 = "" + numb.charAt(2) + numb.charAt(3);

            mensajeCifrado += letra(Integer.parseInt(numb1));
            mensajeCifrado += letra(Integer.parseInt(numb2));

        }

        for (int i = 0, j = 0; i < cifrado.length; i++) {

            if (cifradoD[i] < 10) {
                numb = "000" + cifradoD[i];
            } else if (cifradoD[i] < 100) {
                numb = "00" + cifradoD[i];
            } else if (cifradoD[i] < 1000) {
                numb = "0" + cifradoD[i];
            } else {
                numb = "" + cifradoD[i];
            }
            cifradD[i] = numb;
            num1 = "" + numb.charAt(0) + numb.charAt(1);
            num2 = "" + numb.charAt(2) + numb.charAt(3);

            mensajeDecifrado += letra(Integer.parseInt(num1));
            mensajeDecifrado += letra(Integer.parseInt(num2));

        }

        System.out.println("d: " + d);
        System.out.println("");
        System.out.println("***Mensaje Original***\n" + mensaje1);
        System.out.println("\nCifrado: ");
        for (int i = 0; i < cifrado.length; i++) {
            System.out.print(cifrad[i] + " ");
        }
        System.out.println("");
        System.out.println("\nCifrado    C = P^e (mod n): ");
        for (int i = 0; i < cifrado.length; i++) {
            System.out.print(cifradE[i] + " ");
        }
        System.out.println("\n");
        System.out.println("***Mensaje Cifrado*** \n" + mensajeCifrado);
        System.out.println("\nCifrado    P = C^d (mod n): ");
        for (int i = 0; i < cifrado.length; i++) {
            System.out.print(cifradD[i] + " ");
        }
        System.out.println("");
        System.out.println("\n***Mensaje decifrado*** \n" + mensajeDecifrado);

    }

    public int e(int numb, int modulo, int e1) {

        BigInteger numero = new BigInteger("" + numb);
        BigInteger e = new BigInteger("" + e1);
        BigInteger mod = new BigInteger("" + modulo);
        int cifrado = Integer.parseInt("" + numero.modPow(e, mod));

        return cifrado;
    }

    public int euclidesExtendido(long a, long b, int mod) {

        long[] resp = new long[3];

        long x = 0, y = 0, d = 0;

        if (b == 0) {
            resp[0] = a;
            resp[1] = 1;
            resp[2] = 0;
        } else {

            long x2 = 1, x1 = 0, y2 = 0, y1 = 1;
            long q = 0, r = 0;
            while (b > 0) {

                q = (a / b);
                r = a - (q * b);
                x = x2 - (q * x1);
                y = y2 - (q * y1);
                a = b;
                b = r;
                x2 = x1;
                x1 = x;
                y2 = y1;
                y1 = y;
            }

            resp[0] = a;
            resp[1] = x2;
            resp[2] = y2;
        }
        int inverse;

        if (resp[2] < 0) {
            inverse = (int) (resp[2] + mod);
        } else {
            inverse = (int) (resp[2]);
        }

        return inverse;
    }

    public String numeros(char letra) {

        String numero;

        if (letra == 'a') {
            numero = "00";
            return numero;
        } else if (letra == 'b') {
            numero = "01";
            return numero;
        } else if (letra == 'c') {
            numero = "02";
            return numero;
        } else if (letra == 'd') {
            numero = "03";
            return numero;
        } else if (letra == 'e') {
            numero = "04";
            return numero;
        } else if (letra == 'f') {
            numero = "05";
            return numero;
        } else if (letra == 'g') {
            numero = "06";
            return numero;
        } else if (letra == 'h') {
            numero = "07";
            return numero;
        } else if (letra == 'i') {
            numero = "08";
            return numero;
        } else if (letra == 'j') {
            numero = "09";
            return numero;
        } else if (letra == 'k') {
            numero = "10";
            return numero;
        } else if (letra == 'l') {
            numero = "11";
            return numero;
        } else if (letra == 'm') {
            numero = "12";
            return numero;
        } else if (letra == 'n') {
            numero = "13";
            return numero;
        } else if (letra == 'ñ') {
            numero = "14";
            return numero;
        } else if (letra == 'o') {
            numero = "15";
            return numero;
        } else if (letra == 'p') {
            numero = "16";
            return numero;
        } else if (letra == 'q') {
            numero = "17";
            return numero;
        } else if (letra == 'r') {
            numero = "18";
            return numero;
        } else if (letra == 's') {
            numero = "19";
            return numero;
        } else if (letra == 't') {
            numero = "20";
            return numero;
        } else if (letra == 'u') {
            numero = "21";
            return numero;
        } else if (letra == 'v') {
            numero = "22";
            return numero;
        } else if (letra == 'w') {
            numero = "23";
            return numero;
        } else if (letra == 'x') {
            numero = "24";
            return numero;
        } else if (letra == 'y') {
            numero = "25";
            return numero;

        } else if (letra == 'z') {
            numero = "26";
            return numero;
        }

        numero = "fallo";

        return numero;
    }

    public String letra(int numero) {

        String letra = "";
        numero %= 26;

        if (numero == 0) {
            letra += "a";
            return letra;
        } else if (numero == 1) {
            letra += "b";
            return letra;
        } else if (numero == 2) {
            letra += "c";
            return letra;
        } else if (numero == 3) {
            letra += "d";
            return letra;
        } else if (numero == 4) {
            letra += "e";
            return letra;
        } else if (numero == 5) {
            letra += "f";
            return letra;
        } else if (numero == 6) {
            letra += "g";
            return letra;
        } else if (numero == 7) {
            letra += "h";
            return letra;
        } else if (numero == 8) {
            letra += "i";
            return letra;
        } else if (numero == 9) {
            letra += "j";
            return letra;
        } else if (numero == 10) {
            letra += "k";
            return letra;
        } else if (numero == 11) {
            letra += "l";
            return letra;
        } else if (numero == 12) {
            letra += "m";
            return letra;
        } else if (numero == 13) {
            letra += "n";
            return letra;
        } else if (numero == 14) {
            letra += "ñ";
            return letra;
        } else if (numero == 15) {
            letra += "o";
            return letra;
        } else if (numero == 16) {
            letra += "p";
            return letra;
        } else if (numero == 17) {
            letra += "q";
            return letra;
        } else if (numero == 18) {
            letra += "r";
            return letra;
        } else if (numero == 19) {
            letra += "s";
            return letra;
        } else if (numero == 20) {
            letra += "t";
            return letra;
        } else if (numero == 21) {
            letra += "u";
            return letra;
        } else if (numero == 22) {
            letra += "v";
            return letra;
        } else if (numero == 23) {
            letra += "w";
            return letra;
        } else if (numero == 24) {
            letra += "x";
            return letra;
        } else if (numero == 25) {
            letra += "y";
            return letra;
        } else if (numero == 26) {
            letra += "z";
            return letra;
        }

        return letra;
    }

}
