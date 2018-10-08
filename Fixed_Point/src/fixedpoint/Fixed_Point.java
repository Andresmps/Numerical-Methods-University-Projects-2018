/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixedpoint;


/**
 *
 * @author ingenieria
 */
public class Fixed_Point {

    double pn;
    double pn_1;
    double pn_1_pn;
    double pn_1_pnCopia;
    double k_1;
    double k;
    double limite;
    int i;

    public static void main(String[] args) {
        Fixed_Point main = new Fixed_Point();
        Phi_ phi = new Phi_();
        Phi_2 phi2 = new Phi_2();
//        main.menu();
        phi.menu();
//        phi2.menu();
    }

    public void menu() {

        pn_1 = 1.0 / 3.0;
        pn = ecuacion(pn_1);
        k = derivada(pn_1);

        k_1 = Math.abs((1.0 / (1.0 - k)));
        pn_1_pn = Math.abs(pn_1 - pn);
        pn_1_pnCopia = pn_1_pn;


        limite = k_1 * pn_1_pn * Math.pow(k, 1);
        
        System.out.println("Fixed Point: " + procedure(1));
        System.out.println("n: " + (Math.abs(Math.log( Math.pow(k, i) ) * k_1 * pn_1_pn )));

    }

    public double procedure(int n) {

        i++;
        System.out.println("iteraciòn: {" + n + "}");
        System.out.println("pn: " + pn);
        System.out.println("pn_1: " + pn_1);
        System.out.println("pn_1_pn: " + pn_1_pn);
        System.out.println("k: " + k);
        System.out.println("limite: " + pn_1_pnCopia);
        System.out.println("");
        
        if (pn_1_pnCopia < Math.pow(10, -5)  && k < 1) {
            return pn;
        }

        pn_1 = pn;
        pn = ecuacion(pn_1);
        k = derivada(pn_1);
        pn_1_pnCopia = Math.abs(pn - pn_1);
        limite = k_1 * pn_1_pn * Math.pow(k, n + 1);

        return procedure(n + 1);
    }

    public Double ecuacion(double n) {

        Double number = Math.pow(3.0, -n);
        Double total = (double) Math.round(number * 100000d) / 100000d;

        return total;
    }

    public Double derivada(double n) {

        Double number = Math.pow(3.0, -n) * Math.log(3);
        Double total = (double) Math.round(number * 100000d) / 100000d;

        return total;
    }

}
