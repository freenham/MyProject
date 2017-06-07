package june5th;

public class BattleShip extends Boat{

	public BattleShip(int team, Coordinates location, int direction, int health, int strength, int vision) {
		super(team, location, direction, health, strength, vision);
		// TODO Auto-generated constructor stub
	}

	@Override
	public char getID() {
		// TODO Auto-generated method stub
		return 'B';
	}

	@Override
	public String act(int[][] choice, World world) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
