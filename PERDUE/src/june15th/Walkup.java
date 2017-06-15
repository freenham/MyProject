package june15th;

public class Walkup extends Ticket {
	private int date;

	public Walkup() {
		super();
		date=0;
	}
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		if (date == 0)
			return 50;
		else
			return -1;
	}
}
