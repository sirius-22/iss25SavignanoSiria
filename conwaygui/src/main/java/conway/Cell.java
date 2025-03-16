package conway;

import java.util.Objects;

public class Cell {

    // state of the cell
    // true if alive, false if dead
    private boolean state;
    private int x;
    private int y;

    // constructor
    public Cell(int x, int y) {
        this.state = false;
        this.x=x;
        this.y=y;
    }

    @Override
	public int hashCode() {
		return Objects.hash(state, x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		return state == other.state && x == other.x && y == other.y;
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
        return this.state ? "Alive" : "Dead";
    }

	public boolean getState() {
		return state;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
