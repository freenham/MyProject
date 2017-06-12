package june7th;

public class Clown extends Person{
	private boolean isScary;

	public Clown(String name, int age,boolean isScary) {
		super(name, age);
		this.isScary = isScary;
	}

	@Override
	public String act() {
		return "Monk honk!";
	}
	
	public String toString() {
		if(this.isScary) {
			return "Mwahaha! " + super.toString();
		}
		return "Teeheehee! " + super.toString();
	}

}
