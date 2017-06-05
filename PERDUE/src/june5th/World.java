package june5th;

public class World {
	Object[][] map;
	public final static int NORTH = 0;
	public final static int NORTHEAST = 1;
	public final static int EAST = 2;
	public final static int SOUTHEAST = 3;
	public final static int SOUTH = 4;
	public final static int SOUTHWEST = 5;
	public final static int WEST= 6;
	public final static int NORTHWEST = 7;
	
	public World(int width, int height) {
		if(width <= 4)
			width = 4;
		else if(width >= 10)
			width = 10;
		if(height <= 4)
			height = 4;
		else if(height >= 10)
			height = 10;
		map = new Object[height][width];
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				map[i][j] = null;
			}
		}
	}
	
	public int getWidth() {
		return map[0].length;
	}
	
	public int getHeight() {
		return map.length;
	}
	
	public Object getOccupant(Coordinates c) {
		if(isLocationOccupied(c))
			return map[c.getX()][c.getY()];
		else
			return null;
	}
	
	public boolean isLocationValid(Coordinates c){
			return c.getX()<map[0].length && c.getY()<map.length;
	}
	public boolean isLocationOccupied(Coordinates c) {
		return map[c.getX()][c.getY()] != null;
	}
	
	public boolean setOccupant(Object map,Coordinates c) {
		return false;
	}
		
}
