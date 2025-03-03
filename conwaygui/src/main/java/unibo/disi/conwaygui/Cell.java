package unibo.disi.conwaygui;

public class Cell {

    // state of the cell
    // true if alive, false if dead
    private boolean state;

    // constructor
    public Cell() {
        this.state = false;
    }

    public void setAlive() {
        this.state = true;
    }
    public void setDead() {
        this.state = false;
    }

    public boolean isAlive() {
        return this.state;
    }

    public void toggle() {
        this.state = !this.state;
    }

    @Override
    public String toString() {
        return this.state ? "1" : "0";
    }
}
