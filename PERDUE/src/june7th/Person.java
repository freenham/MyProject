package june7th;

public abstract class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		setName(name);
		setAge(age);
	}

	public abstract String act();
	
	public void setName(String name) {
		if(name != null) {
			this.name = name;
		}
	}
	
	public void setAge(int age) {
		if(age >= 0) {
			this.age = age;
		}
	}
	
	public String toString() {
		return this.name + ", " +this.age+" years old";
	}
	
}
