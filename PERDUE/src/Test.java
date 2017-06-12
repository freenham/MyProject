class Animal {
   public void move() {
      System.out.print("Animals can move, ");
   }public void bark() {
	      System.out.println("Dogs can bark");
	   }
}

class Dog extends Animal {
   public void move() {
      System.out.print("Dogs can walk and run, ");
   }
   
}

public class Test {

   public static void main(String args[]) {
      Animal a = new Animal();   // Animal reference and object
      Dog b = new Dog();   // Animal reference and Dog object

      a.move();   
      b.move();   
      b.bark();
   }
   

   
}