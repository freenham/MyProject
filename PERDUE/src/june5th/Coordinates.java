package june5th;

public class Coordinates {
	private int x;
	private int y;

	public Coordinates() {
		x = 0;
		y = 0;
	}

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
//		return String.format("\"%c%c\" // x = %d, y = %d", (char) (y + 65), (char) (x + 48), x, y);
		return (char)(y+'A') + "" +(x+1);

	}
}
