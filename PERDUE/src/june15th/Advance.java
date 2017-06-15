package june15th;

public class Advance extends Ticket {
	private int purchasedDate;

	public Advance(int purchaseDate) {
		super();
		this.purchasedDate = purchaseDate;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		if (purchasedDate >= 10)
			return 30;
		else
			return 40;
	}

}
