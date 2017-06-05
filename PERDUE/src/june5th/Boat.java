package june5th;

public abstract class Boat {
	private int team;
	private Coordinates location;
	private int direction;
	private int health;
	private int strength;
	private int vision;

	public Boat(int team, Coordinates location, int direction, int health, int strength, int vision) {
		this.team = team;
		this.location = location;
		this.direction = direction;
		this.health = health;
		this.strength = strength;
		this.vision = vision;
	}

	public int getTeam() {
		return team;
	}

	public Coordinates getLocation() {
		return location;
	}

	public char getDirection() {
		if (direction == World.NORTH)
			return 8593;
		else if (direction == World.NORTHEAST)
			return 8599;
		else if (direction == World.EAST)
			return 8594;
		else if (direction == World.SOUTHEAST)
			return 8600;
		else if (direction == World.SOUTH)
			return 8595;
		else if (direction == World.SOUTHWEST)
			return 8601;
		else if (direction == World.WEST)
			return 8592;
		else if (direction == World.NORTHWEST)
			return 8598;
		else
			return 0;
	}

	public int getHealth() {
		return health;
	}

	public int getStrength() {
		return strength;
	}

	public int getVision() {
		return vision;
	}

	public abstract char getID();

	public abstract String act(int[][] choice, World world);

	public abstract String getAction();

	public String move(World world) {
		Coordinates c = location;
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
		if (world.isLocationOccupied(ac))
			return String.format("%s cannot move to %c%c as it is occupied.", toString(), (char) (y + 65), (char) (x + 48),
					x, y);
		else if (!world.isLocationValid(ac))
			return String.format("%s cannot move off the map.", toString());
		else
			return String.format("%s moves from %c%c to %c%c", toString(), (char) (c.getY() + 65), (char) (c.getX() + 48),
					(char) (ac.getY() + 65), (char) (ac.getX() + 48));
	}
	public String turn(int dic) {
		String d="";
		if(dic == -1) {
			direction--;
			if(direction<0)
				direction=World.NORTHWEST;
			else if(direction>7)
				direction = World.NORTH;
			if (direction == World.NORTH)
				d="N";
			else if (direction == World.NORTHEAST) {
				d="NE";
			} else if (direction == World.EAST)
				d="E";
			else if (direction == World.SOUTHEAST) {
				d="SE";
			} else if (direction == World.SOUTH)
				d="S";
			else if (direction == World.SOUTHWEST) {
				d="SW";
			} else if (direction == World.WEST)
				d="W";
			else if (direction == World.NORTHWEST) {
				d="NW";
			}
			return String.format("%s turned left, now facing %s", toString(),d);
		}
		else if(dic == 1) {
			direction++;
			if(direction<0)
				direction=World.NORTHWEST;
			else if(direction>7)
				direction = World.NORTH;
			if (direction == World.NORTH)
				d="N";
			else if (direction == World.NORTHEAST) {
				d="NE";
			} else if (direction == World.EAST)
				d="E";
			else if (direction == World.SOUTHEAST) {
				d="SE";
			} else if (direction == World.SOUTH)
				d="S";
			else if (direction == World.SOUTHWEST) {
				d="SW";
			} else if (direction == World.WEST)
				d="W";
			else if (direction == World.NORTHWEST) {
				d="NW";
			}
			return String.format("%s turned right, now facing %s",toString(),d);
			}
		else
			return "";
	}
	
	public String takeHit(int strength) {
		health -= strength;
		if(health <= 0) {
			health = 0;
			return String.format("%s has been sunk!", toString());
		}
		else {
			return String.format("%s takes %d damage.", toString(),strength);
		}
	}
	
	public void setLocation(Coordinates c) {
		location = c;
	}
	
	public String toString() {
		return String.format("%s", ""+getID()+team);
	}
	

}
