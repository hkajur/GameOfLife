package GameBoards;

/**
 * Cell is the base class for all Cell blocks
 * that we will be using for the Board class
 *
 * @author          Venkata Harish K Kajur
 * @version         %I%, %G%
 * @since           1.0
 */
class Cell implements Cloneable {

    public static final String ALIVE_CELL = "X";
    public static final String DEAD_CELL = "_";

    public static final byte MIN = 0;

    private boolean alive;
    private byte liveNeighbors;

    /**
     * Constructs an Cell Object with default values for alive, liveNeighbors
     */
    public Cell(){
        this(false, MIN);
    }

    /**
     * Constructs an Cell Object with the alive and count of live neighbors
     *
     * @param      alive boolean setting the status of instance variable alive variable
     */
    public Cell(boolean alive){
        this(alive, MIN);
    }

    /**
     * Constructs an Cell Object with the alive and count of live neighbors
     *
     * @param       alive boolean setting the status of instance variable variable
     * @param       liveneighbors byte setting the value of instance variable liveNeighbors
     */
    public Cell(boolean alive, byte liveNeighbors){
        this.alive = alive;
        this.liveNeighbors = liveNeighbors;
    }

    /**
     * Returns an boolean indicting if the cell is alive or not
     *
     * @return      true if the status of alive is true
     *              otherwise it will return false
     */
    public boolean isAlive(){
        return alive;
    }

    /**
     *  Sets the status of cell if it is alive or not
     *
     *  @param      alive boolean setting the status of instance variable alive variable
     */
    public void setAlive(boolean alive){
        this.alive = alive;
    }

    /**
     * Returns the number of live cells around the current cell object
     *
     *  @return     liveneighbors an integer which keeps track of live cells
     */
    public int getLiveNeighbors(){
        return liveNeighbors;
    }

    /**
     * Sets the number of live neighbors around this cell
     *
     * @param       n which is the count of the live neighbors
     */
    public void setLiveNeightbors(byte n){
        liveNeighbors = n;
    }

    /**
     * Returns an object which is the clone of this Cell object
     *
     * First it stores the clone of its super class into dummy reference variable
     * Then it copies the instance fields of this object into dummy reference variable
     * Afterwards, it will return the dummy reference variable
     *
     * @return      Object which will be a clone of this object
     * @throws      Clonenotsupportedexception if the super class doesn't support it
     */
    public Object clone() throws CloneNotSupportedException {
        Cell cloned = (Cell)super.clone();

        cloned.alive = this.alive;
        cloned.liveNeighbors = this.liveNeighbors;

        return cloned;
    }


    /**
     * Returns true if this object equals to the other object
     * Otherwise it will return false
     *
     * First checks if the object in the parameter is null
     * If the object is null, it will return false
     * Then it checks if the obj paramter is referencing the same object
     * as the this reference, if it is then it will return true
     * Because if they are referencing the same object then
     * there is no need to do the deep equals test
     * <p>
     * Then it checks if the object is an instance of Cell
     * If it isn't, then it can't possibly be equal to
     * this cell, so it will return false
     * Then it will compare if they are referencing the same object
     * If they are, then it will return true
     * There is no need to do the deep equals anymore
     * <p>
     * If the live neighbors of the new object are not equal
     * to the other object, it will return false
     * Then it will check if the alive conditions are equal,
     * if it isn't it will returns false
     * If the code reached after this point, then the objects
     * are equal so it will return true
     *
     * @param       obj which is another object of type Cell
     * @return      true if this object is equal to other object
     *              false if they are not equal
     */
    public boolean equals(Object obj){

        if(obj == null)
            return false;

        if(this == obj)
            return true;

        if(!(obj instanceof Cell))
            return false;

        Cell other = (Cell) obj;

        if(this.liveNeighbors != other.liveNeighbors)
            return false;

        if(this.alive != other.alive)
            return false;

        return true;
    }

    /**
     * Returns a hash code that represents the object
     *
     * @return      hash which is the calculated value based on instance variables
     */
    public int hashCode(){
        int hash = 1;
        hash = hash * 5 + ((alive) ? 1 : 0);
        hash = hash * 15 + liveNeighbors;
        return hash;
    }

    /**
     * Returns a String representation of the Object Cell
     * If the alive condition is true, then it will return "X"
     * otherwise, it will return "O"
     *
     * @return      string which will either be dead or alive
     */
    public String toString(){
        if(alive)
            return ALIVE_CELL;
        return DEAD_CELL;
    }

}
