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
public class Phi_2 {
    
    int i;
    double pn;
    double pn_1;
    double pn_1_pn;
    double pn_1_pnCopia;
    double k_1;
    double k;
    double limite;
    
    public void menu(){
        
        pn_1 = 0.5;
        pn = ecuacion(pn_1);
        k = derivada(pn_1);
        
        k_1 = Math.abs((1.0/(1.0-k)));
        pn_1_pn = Math.round( Math.abs(pn_1-pn));
        pn_1_pnCopia = pn_1_pn;
        
        limite = k_1 * pn_1_pn * Math.pow(k, 1);

        System.out.println("Fixed Point: " + procedure(1));
        System.out.println("n: " + ( Math.abs( Math.log( Math.pow(k, i) * k_1 * pn_1_pn ) ) ) );
                
        System.out.println("");
        System.out.println("f(x) = x^2 - x - 1");
        System.out.println("g(x) = 1 + 1 / x");
        System.out.println("g'(x) = -1 / (x^2)");
        System.out.println("");

    }
    
    public double procedure(int n){
        
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
        pn_1_pnCopia = Math.abs(pn_1 - pn);
        k = derivada(pn_1);
        limite = k_1 * pn_1_pn * Math.pow(k, n+1);
        
        return procedure(n+1);
    }
    
    public Double ecuacion(double n){
        
        Double number = Math.abs(1.0+(1.0/n));
        Double total = (double)Math.round(number * 1000d) / 1000d;
       
        return total; 
    }
    
    public Double derivada(double n){
       
       Double number = Math.abs(-(1.0/Math.pow(n, 2)));
       Double total = (double)Math.round(number * 1000d) / 1000d;
       
       return total; 
    }
    
    //
}
