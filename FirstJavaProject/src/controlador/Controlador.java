
package controlador;


public class Controlador {
    private int numUno = 0;

    public int getNumUno() {
        return numUno;
    }

    public void setNumUno(int numUno) {
        this.numUno = numUno;
    }
    
    public int proceso()
    {
        System.out.println("Los multiplos de "+numUno+" antes de 200 son: ");
        for (int i = 1; numUno*i <= 200; i++) {
            System.out.print("["+i+"]");
        }        
        System.out.println(" ");
        return 0;
    }
}
