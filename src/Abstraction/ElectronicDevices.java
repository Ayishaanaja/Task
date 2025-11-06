package Abstraction;
abstract class Ec{
		String brand;
	    int year;
	    public Ec(String brand, int year) {
	        this.brand = brand;
	        this.year = year;
	    }

	    abstract void powerOn();
	    abstract void powerOff();
	    void deviceInfo() {
	        System.out.println("Brand: " + brand);
	        System.out.println("Year: " + year);
	    }

}

class Laptop extends Ec {
    public Laptop(String brand, int year) {
        super(brand, year);
    }

    @Override
    void powerOn() {
        System.out.println("Laptop is booting up...");
    }

    @Override
    void powerOff() {
        System.out.println("Laptop is shutting down...");
    }
}

public class ElectronicDevices {
public static void main(String[] args) {
	   Laptop myLaptop = new Laptop("Dell", 2022);
       System.out.println("Laptop Details:");
       myLaptop.deviceInfo();
       myLaptop.powerOn();
       myLaptop.powerOff();
       Laptop myLaptop1 = new Laptop("Hp", 2025);
       System.out.println("Laptop Details:");
       myLaptop1.deviceInfo();
       myLaptop1.powerOn();
       myLaptop1.powerOff();

}
}
