package june5th;

public class World {
	Object[][] map;
	public static int NORTH = 0;
	public static int NORTHEAST = 1;
	public static int EAST = 2;
	public static int SOUTHEAST = 3;
	public static int SOUTH = 4;
	public static int SOUTHWEST = 5;
	public static int WEST= 6;
	public static int NORTHWEST = 7;
	
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

}
