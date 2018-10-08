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
public class Phi_ {

    double pn;
    double pn_1;
    double pn_1_pn;
    double k_1;
    double k;
    double limite;
    int i;

    public void menu() {

        pn_1 = 3;
        pn = ecuacion(pn_1);
        k = derivada(pn_1);

        k_1 = Math.abs((1.0 / (1.0 - k)));
        pn_1_pn = Math.abs(pn_1 - pn);
        
        limite = k_1 * pn_1_pn * Math.pow(k, 1);

        System.out.println("Fixed Point: " + procedure(1));
        System.out.println("n: " + ( Math.abs(Math.log(Math.pow(k, i) * k_1 * pn_1_pn ) ) ) );
        System.out.println("");
        System.out.println("f(x) = x^2 - x - 1");
        System.out.println("g(x) = \\sqrt(x+1)");
        System.out.println("g'(x) = 1 / 2\\sqrt(x+1)");
        System.out.println("");
        
    }

    public double procedure(int n) {
        
        i++;
        System.out.println("iteraciòn: {" + n + "}");
        System.out.println("pn: " + pn);
        System.out.println("pn_1: " + pn_1);
        System.out.println("pn_1_pn: " + pn_1_pn);
        System.out.println("k: " + k);
        System.out.println("limite: " + limite);
        System.out.println("");
        
        if (limite < Math.pow(10, -3)  && k < 1) {
            return pn;
        }

        pn_1 = pn;
        pn = ecuacion(pn_1);
        k = derivada(pn_1);
        limite = k_1 * pn_1_pn * Math.pow(k, n + 1);

        return procedure(n + 1);
    }

    public Double ecuacion(double n) {

        Double number = Math.sqrt(n + 1);
        Double total = (double) Math.round(number * 1000d) / 1000d;

        return total;
    }

    public Double derivada(double n) {

        Double number = 1.0 / (2 * Math.sqrt(n + 1));
        Double total = (double) Math.round(number * 1000d) / 1000d;

        return total;
    }

}
