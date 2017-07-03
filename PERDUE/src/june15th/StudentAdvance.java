package june15th;

public class StudentAdvance extends Advance{
	private int date;
	
	public StudentAdvance(int date) {
		super(date);
	}

	@Override
	public double getPrice() {
		return super.getPrice()/2;
	}
	
	public String toString() {
		return super.toString() +"\n (student ID required)";
	}

}
