
package cellimage;

/**
 *
 * @author camil
 */
public class Cell {

    private int cellArea;
    private int nucleiCount;
    private int cellWidth;
    private int cellHeight;
    
    public Cell(int cellArea, int nucleiCount, int cellWidth, int cellHeight){
        this.cellArea = cellArea;
        this.nucleiCount = nucleiCount;
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
    }

    public int getCellArea() {
        return cellArea;
    }

    public int getNucleiCount() {
        return nucleiCount;
    }

    public int getCellWidth() {
        return cellWidth;
    }

    public int getCellHeight() {
        return cellHeight;
    }
    
    public void changeArea(int cellArea) {
        
        this.cellArea = cellArea;
    }
    public void changeNucleiCount(int nucleiCount) {
        
           this.nucleiCount = nucleiCount;
    }
    public void changeCellWidth(int cellWidth) {
        
        this.cellWidth = cellWidth;
    }
    public void changeCellHeight(int cellHeight) {
        
        this.cellHeight = cellHeight;
    }
    
}
