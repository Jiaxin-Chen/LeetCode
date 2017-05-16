
public class Main {
	 interface Animal {
		 void vocalize();
	 }
	 
	 class Dog implements Animal {
		 public void vocalize(){
			 System.out.println("Dog!");
		 }
	 }
	 
	 class Cow implements Animal {
		 public void vocalize(){
			 System.out.println("Cow!");
		 }
		 
		 public void moo(){
			 System.out.println("Moo!");
		 }
	 }
	 
	 public static void main(String[] args){
		 //Animal a = new Animal();
		 //a.vocalize();
		 
		 Dog b = new Dog();
		 b.vocalize();
		 
		 Animal c = new Cow();
		 c.vocalize();
		 
		 Cow d = new Cow();
		 d.moo();
	 }
}
