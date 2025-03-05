package conway;

public class Grid {

    private Cell[][] grid;
    private int rows;
    private int cols;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.grid[i][j] = new Cell();
            }
        }
    }

    public void setCellAlive(int row, int col) {
        this.grid[row][col].setAlive();
    }

    public void setCellDead(int row, int col) {
        this.grid[row][col].setDead();
    }

    public boolean isCellAlive(int row, int col) {
        return this.grid[row][col].isAlive();
    }
    public boolean isCellDead(int row, int col) {
        return !this.grid[row][col].isAlive();
    }

    public Cell getCell(int row, int col) {
        return this.grid[row][col];
    }

    public void reset() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.grid[i][j].setDead();
            }
        }
    }

    public void copy(Grid nextGrid) {
        //modifico la griglia corrente con i valori della griglia nextGrid
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (nextGrid.getCell(i, j).isAlive()) {
                    this.setCellAlive(i, j);
                } else {
                    this.setCellDead(i, j);
                }
            }
        }
    }
    
    public int getRows() {
    	return this.rows;
    }
    
    public int getCols() {
    	return this.cols;
    }
    
    //metodi per ottenere le celle adiacenti
    public Cell getCellUp(int row, int col) {
        if (row == 0) {
            return null;
        } else {
            return this.grid[row - 1][col];
        }
    }
    public Cell getCellLeft(int row, int col) {
    	
        if (col == 0) {
            return null;
        } else {
            return this.grid[row][col - 1];
        }
    }
    public Cell getCellDown(int row, int col) {
        if (row == this.rows - 1) {
            return null;
        } else {
            return this.grid[row + 1][col];
        }
    }
    public Cell getCellRight(int row, int col) {
        if (col == this.cols - 1) {
            return null;
        } else {
            return this.grid[row][col + 1];
        }
    }
    public Cell getCellUpLeft(int row, int col) {
        if (row == 0 || col == 0) {
            return null;
        } else {
            return this.grid[row - 1][col - 1];
        }
    }
    public Cell getCellUpRight(int row, int col) {
        if (row == 0 || col == this.cols - 1) {
            return null;
        } else {
            return this.grid[row - 1][col + 1];
        }
    }
    public Cell getCellDownLeft(int row, int col) {
        if (row == this.rows - 1 || col == 0) {
            return null;
        } else {
            return this.grid[row + 1][col - 1];
        }
    }
    public Cell getCellDownRight(int row, int col) {
        if (row == this.rows - 1 || col == this.cols - 1) {
            return null;
        } else {
            return this.grid[row + 1][col + 1];
        }
    }

    public void switchCellState(int row, int col){
        this.grid[row][col].toggle();
    }



}
