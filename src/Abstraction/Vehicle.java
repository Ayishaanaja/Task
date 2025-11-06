package Abstraction;

abstract class Pvehicle{
	void hasWheels() {
		System.out.println("Has four wheels");
	}
	abstract void fuelTypex();
	abstract void maxSpeed();
}
class car extends Pvehicle{
	@Override
	void fuelTypex() {
		System.out.println("Car can be run on petrol,diesel and electricity");
	}

	@Override
	void maxSpeed() {
		System.out.println("Max speed in common cars are mostly 280kmph");
	}
	
}
public class Vehicle {
	public static void main(String[] args) {
		car c=new car();
		c.hasWheels();
		c.fuelTypex();
		c.maxSpeed();
	}
}
