package conway;


/*
 * Il core di game of life
 * Non ha dipendenze da dispositivi di input/output
 * Non ha regole di controllo del gioco 
 */

public class Life {
    //La struttura
    private int rows=0;
    private int cols=0;
    private Grid grid;
    private Grid nextGrid;
    


    public Life( int rowsNum, int colsNum ) {
        this.rows   = rowsNum;
        this.cols   = colsNum;
        createGrids();   //crea la struttura a griglia
    }

    public int getRowsNum(){
        return rows;
    }
    public int getColsNum(){
        return cols;
    }

    protected void  createGrids() {
        grid     = new Grid(rows, cols);
        nextGrid = new Grid(rows, cols) ;
        //CommUtils.outyellow("Life | initializeGrids done");
    }

    protected void resetGrids() {
        grid.reset();
        nextGrid.reset();
        //CommUtils.outyellow("Life | initGrids done");
    }

    //conta i vicini vivi di una cella
    protected int countNeighborsLive(int row, int col) {
        int count=0;
        Cell cell;
        cell = grid.getCellDown(row, col);
        if (cell != null && cell.isAlive()) count++;
        cell = grid.getCellUp(row, col);
        if (cell != null && cell.isAlive()) count++;
        cell = grid.getCellLeft(row, col);
        if (cell != null && cell.isAlive()) count++;
        cell = grid.getCellRight(row, col);
        if (cell != null && cell.isAlive()) count++;
        cell = grid.getCellUpLeft(row, col);
        if (cell != null && cell.isAlive()) count++;
        cell = grid.getCellUpRight(row, col);
        if (cell != null && cell.isAlive()) count++;
        cell = grid.getCellDownLeft(row, col);
        if (cell != null && cell.isAlive()) count++;
        cell = grid.getCellDownRight(row, col);
        if (cell != null && cell.isAlive()) count++;

      return count;
    }

    protected void computeNextGen() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int n = countNeighborsLive(i,j);
                applyRules(i, j, n);
            }
        }
        copyAndResetGrid();
    }

    protected void copyAndResetGrid() {
        grid.copy(nextGrid);
        nextGrid.reset();
    }

    protected void applyRules(int row, int col, int numNeighbors) {
        //int numNeighbors = countNeighborsLive(row, col);
        //CELLA VIVA
        if (grid.isCellAlive(row, col)) {
            if (numNeighbors < 2) { //muore per isolamento
                nextGrid.setCellDead(row, col);
            } else if (numNeighbors == 2 || numNeighbors == 3) { //sopravvive
                nextGrid.setCellAlive(row, col);
            } else if (numNeighbors > 3) { //muore per sovrappopolazione
                nextGrid.setCellDead(row, col);
            }
        }
        //CELLA MORTA
        else if (grid.isCellDead(row, col)) {
            if (numNeighbors == 3) { //riproduzione
                nextGrid.setCellAlive(row, col);
            }
        }
        //CommUtils.outgreen("Life applyRules " + nextGrid   );
    }

    public void switchCellState(int i, int j){
        grid.switchCellState(i, j); 
    }

    public  boolean isCellAlive( int i, int j  ) {
        return   grid.isCellAlive(i, j);
    }
 


}
