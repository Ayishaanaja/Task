package Abstraction;

abstract class Animal{
	void NoOfLegs() {
		System.out.println("Has total of 4 legs");
	}
	void isWild()
	{
		System.out.println("The animal lives in wild");
	}
	abstract void nameofAnimal();
	abstract void eats();
}
class tiger extends Animal{

	@Override
	void nameofAnimal() {
		System.out.println("Tiger");
	}

	@Override
	void eats() {
		System.out.println("Eats meat");
	}
	
}

public class Animall {
public static void main(String[] args) {
	tiger a=new tiger();
	a.nameofAnimal();
	a.eats();
	a.NoOfLegs();
	a.isWild();
}
}
