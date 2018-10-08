
package cellimage;

import java.util.ArrayList;

/**
 *
 * @author camil
 */
public class Datos {
    
    private ArrayList<Cell> cell = new ArrayList();
    private Integer[] cells = new Integer[4];
    
    public void newCell(int cellArea, int nucleiCount, int cellWidth, int cellHeight) {
        
        Cell cell1 = new Cell(cellArea, nucleiCount, cellWidth, cellHeight);
        cell.add(cell1);
        
    }
    
    public void calcularArea() {
        //No se como calcularon el area de las celulas 
    }
    
    public void deletecell(int indice) {
        
        cell.remove(indice);
    }
    
    public void changeArea(int indice, int area) {
        
        cell.get(indice).changeArea(area);
    }
    
    public void changeNucleiCount(int indice, int nuclei) {
        
        cell.get(indice).changeNucleiCount(nuclei);
    }
    
    public void changeCellWidth(int indice, int width) {
        
        cell.get(indice).changeCellWidth(width);
    }
    
    public void changeCellHeight(int indice, int height) {
        
        cell.get(indice).changeCellHeight(height);
    }
    
    
    public String Tostring(){
        
        String mensaje = "";
        
        for (int i = 0; i < cell.size(); i++) {
            mensaje += "\nCell Number: ["+(i+1)+"], Cell Areá: ["+cell.get(i).getCellArea()+"], Nuclei Count : ["+cell.get(i).getNucleiCount()+"], Cell Width: ["+cell.get(i).getCellWidth()+"], Cell Height: ["+cell.get(i).getCellHeight()+"]";
        }
        
        return mensaje;
    }
    
}
