package GameBoards;

/*
 * Board Class
 * -----------
 *  Creates a multidimensional array of cells of n rows and n columns
 *  Runs th game of life
 */

public class Board {

    public static final int DEFAULT_LEN = 8;

    private Cell[][] cellsArray;

    private int rowSize;
    private int columnSize;

    private boolean debugOn;

    public Board(){
        this(DEFAULT_LEN, DEFAULT_LEN, false);
    }

    public Board(boolean debugOn){
        this(DEFAULT_LEN, DEFAULT_LEN, debugOn);
    }

    public Board(int rows, int columns){
        this(rows, columns, false);
    }

    public Board(int rows, int columns, boolean debugOn){

        this.debugOn = debugOn;

        rowSize = rows;
        columnSize = columns;
        cellsArray = new Cell[rowSize][columnSize];

        for(int i = 0; i < rowSize; i++)
            for(int j = 0; j < columnSize; j++)
                cellsArray[i][j] = new Cell();
    }

    public Board(Board other){
        this.rowSize = other.rowSize;
        this.columnSize = other.columnSize;
        this.cellsArray = other.cellsArray;
    }

    /*
     * createCell
     * ----------
     *  Sets the cell on the specified row and column position
     *  If the row or column position is out of bounds throws an Exception
     *  If the new cell is created at the position returns true
     *  Otherwise it returns false
     */

    public boolean createCell(int row, int column) throws ArrayIndexOutOfBoundsException {

        if(row < 0 || row >= rowSize || column < 0 || column >= columnSize)
            throw new ArrayIndexOutOfBoundsException();

        cellsArray[row][column] = new Cell(true);

        assert(cellsArray[row][column] != null);

        if(cellsArray[row][column] == null)
            return false;

        return true;
    }

    public boolean deleteCell(int row, int column) throws ArrayIndexOutOfBoundsException {

        if(row < 0 || row >= rowSize || column < 0 || column >= columnSize)
            throw new ArrayIndexOutOfBoundsException();

        cellsArray[row][column].setAlive(false);

        assert(cellsArray[row][column].isAlive() == false);

        return true;

    }

    @Override
    public boolean equals(Object obj){

        if(obj == null)
            return false;

        Board other = (Board) obj;

        for(int rowIndex = 0; rowIndex < rowSize; rowIndex++)
            for(int columnIndex = 0; columnIndex < columnSize; columnIndex++)
                if(!cellsArray[rowIndex][columnIndex].equals(other.cellsArray[rowIndex][columnIndex]))
                    return false;

        return true;
    }

    @Override
    public String toString(){

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < columnSize; j++){
                if(debugOn){
                    sb.append(cellsArray[i][j].toString() + ":"
                        + String.valueOf(cellsArray[i][j].getLiveNeighborsCount()) + " ");
                } else {
                    sb.append(cellsArray[i][j].toString() + " ");
                }
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    @Override
    public int hashCode(){

        int hash = 1;

        hash = hash * 31;

        return hash;
    }

    public int countNeighbors(int row, int column){

        int count = 0;

        if(row == 0){

            if(column == 0){


            } else if(column == columnSize - 1){

            }

            if(cellsArray[rowSize-1][column].isAlive())
                count++;
            if(cellsArray[row][columnSize-1].isAlive())
                count++;

        } else if(row == rowSize - 1){

            if(column == 0){

            } else if(column == columnSize - 1){

            }

            if(cellsArray[0][column].isAlive())
                count++;

        } else {

        }

        return count;
    }

    public void startGame(){

    }

    public static void main(String[] args){

        Board board = new Board(false);

        System.out.println(board);

        board.createCell(3, 1);
        board.createCell(3, 2);

        System.out.println(board);
    }
}
