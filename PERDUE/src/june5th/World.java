package june5th;

public class World {
	Object[][] map;
	public final static int NORTH = 0;
	public final static int NORTHEAST = 1;
	public final static int EAST = 2;
	public final static int SOUTHEAST = 3;
	public final static int SOUTH = 4;
	public final static int SOUTHWEST = 5;
	public final static int WEST = 6;
	public final static int NORTHWEST = 7;

	public World(int width, int height) {
		if (width <= 4)
			width = 4;
		else if (width >= 10)
			width = 10;
		if (height <= 4)
			height = 4;
		else if (height >= 10)
			height = 10;
		map = new Object[height + 1][width + 1];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
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
		if (isLocationOccupied(c))
			return map[c.getX()][c.getY()];
		else
			return null;
	}

	public boolean isLocationValid(Coordinates c) {
		return c.getX() < map[0].length && c.getY() < map.length;
	}

	public boolean isLocationOccupied(Coordinates c) {
		return map[c.getX()][c.getY()] != null;
	}

	public boolean setOccupant(Object boat, Coordinates c) {
		if (!isLocationOccupied(c)) {
			map[c.getY()][c.getX()] = boat;
			return true;
		} else
			return false;
	}

	public Coordinates getAdjacentLocation(Coordinates c, int direction) {
		int x = c.getX();
		int y = c.getY();
		if (direction == World.NORTH)
			y--;
		else if (direction == World.NORTHEAST) {
			x++;
			y--;
		} else if (direction == World.EAST)
			x++;
		else if (direction == World.SOUTHEAST) {
			x++;
			y++;
		} else if (direction == World.SOUTH)
			y++;
		else if (direction == World.SOUTHWEST) {
			x--;
			y++;
		} else if (direction == World.WEST)
			x--;
		else if (direction == World.NORTHWEST) {
			x--;
			y--;
		}
		Coordinates ac = new Coordinates(x, y);
		return ac;
	}

	public String drawTeamMap(Boat[] b, int viewType) {
		// Boolean flag = false;
		// String s = "";
		// if (viewType == 1) {
		//
		// for (int y = 0; y <= getHeight(); y++) {
		// s += "" + (char) (64 + y) + " ";
		// for (int x = 0; x < getWidth(); x++) {
		// if (y == 0) {
		// s += " " + (x + 1) + " ";
		// } else if (y != 0) {
		// s += "###";
		// }
		// }
		// s += "\n";
		// }
		// }
		//
		// else if (viewType == 2) {
		//
		// for (int y = 0; y <= getHeight(); y++) {
		// s += "" + (char) (64 + y) + " ";
		// for (int x = 0; x < getWidth(); x++) {
		// if (y == 0) {
		// s += " " + (x + 1) + " ";
		// }
		// flag = true;
		// for (int i = 0; i < b.length; i++) {
		// if (x == b[i].getLocation().getX() - 1 && y ==
		// b[i].getLocation().getY()) {
		// s += "" + b[i].getDirection() + b[0].getID() + b[i].getTeam();
		// flag = false;
		// } else if ((x >= b[i].getLocation().getX() - 1 - b[i].getVision()
		// && x <= b[i].getLocation().getX() - 1 + b[i].getVision())
		// && (y >= b[i].getLocation().getY() - b[i].getVision()
		// && y <= b[i].getLocation().getY() + b[i].getVision())) {
		// s += "~~~";
		// flag = false;
		// }
		// }
		// if (flag && y!=0) {
		// s += "###";
		// flag = true;
		// }
		//
		// }
		// s += "\n";
		// }
		// } else if (viewType == 3) {
		//
		// for (int y = 0; y <= getHeight(); y++) {
		// s += "" + (char) (64 + y) + " ";
		// for (int x = 0; x < getWidth(); x++) {
		// if (y == 0) {
		// s += " " + (x + 1) + " ";
		// } else if (x == b[0].getLocation().getX() - 1 && y ==
		// b[0].getLocation().getY()) {
		// s += "" + b[0].getHealth() + b[0].getID() + b[0].getTeam();
		// } else if ((x >= b[0].getLocation().getX() - 1 - b[0].getVision()
		// && x <= b[0].getLocation().getX() - 1 + b[0].getVision())
		// && (y >= b[0].getLocation().getY() - b[0].getVision()
		// && y <= b[0].getLocation().getY() + b[0].getVision())) {
		// s += "~~~";
		// } else if (y != 0) {
		// s += "###";
		// }
		// }
		// s += "\n";
		// }
		//
		// }
		// return s;
		Boolean flag = false;
		String s = "";
		if (viewType == 1) {
			for (int y = 0; y < getHeight(); y++) {
				for (int x = 0; x < getWidth(); x++) {
					map[x][y] = "###";
					if (x == 0)
						map[x][y] = "" + (char) (64 + y) + " ";
					else if (y == 0)
						map[x][y] = " " + (x) + " ";
				}
			}
		} else if (viewType == 2) {
			for (int y = 0; y < getHeight(); y++) {
				for (int x = 0; x < getWidth(); x++) {
					for (int i = 0; i < b.length; i++) {
						if (map[x][y] == null)
							map[x][y] = "###";
						if (x == 0)
							map[x][y] = "" + (char) (64 + y) + " ";
						else if (y == 0)
							map[x][y] = " " + (x) + " ";
						else if (x == b[i].getLocation().getX() && y == b[i].getLocation().getY()) {
							map[x][y] = "" + b[i].getDirection() + b[i].getID() + b[i].getTeam();
						} else if ((x >= b[i].getLocation().getX() - b[i].getVision()
								&& x <= b[i].getLocation().getX() + b[i].getVision())
								&& (y >= b[i].getLocation().getY() - b[i].getVision()
										&& y <= b[i].getLocation().getY() + b[i].getVision())) {
							if (map[x][y].equals("###"))
								map[x][y] = "~~~";
						}
					}
				}
			}
		}
		else if (viewType == 3) {
			for (int y = 0; y < getHeight(); y++) {
				for (int x = 0; x < getWidth(); x++) {
					for (int i = 0; i < b.length; i++) {
						if (map[x][y] == null)
							map[x][y] = "###";
						if (x == 0)
							map[x][y] = "" + (char) (64 + y) + " ";
						else if (y == 0)
							map[x][y] = " " + (x) + " ";
						else if (x == b[i].getLocation().getX() && y == b[i].getLocation().getY()) {
							map[x][y] = "" + b[i].getHealth() + b[i].getID() + b[i].getTeam();
						} else if ((x >= b[i].getLocation().getX() - b[i].getVision()
								&& x <= b[i].getLocation().getX() + b[i].getVision())
								&& (y >= b[i].getLocation().getY() - b[i].getVision()
										&& y <= b[i].getLocation().getY() + b[i].getVision())) {
							if (map[x][y].equals("###"))
								map[x][y] = "~~~";
						}
					}
				}
			}
		}

		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				s += map[x][y];
			}
			s += "\n";
		}
		return s;
	}

	public static void main(String[] args) {
		World w = new World(10, 10);
		Boat[] b = new Boat[5];
		Boat D1 = new BattleShip(1, new Coordinates(10, 2), World.NORTH, 2, 2, 1);
		Boat C1 = new BattleShip(1, new Coordinates(6, 6), World.NORTH, 3, 3, 3);
		Boat S1 = new BattleShip(1, new Coordinates(2, 8), World.NORTH, 3, 3, 2);
		Boat A1 = new BattleShip(1, new Coordinates(5, 8), World.NORTH, 5, 5, 0);
		Boat B1 = new BattleShip(1, new Coordinates(5, 10), World.NORTH, 4, 4, 1);

		b[0] = D1;
		 b[2] = C1;
		 b[3] = S1;
		 b[4] = A1;
		 b[1] = B1;
		System.out.println(w.drawTeamMap(b, 3));
	}
}
