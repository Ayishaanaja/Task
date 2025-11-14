//created an interface SmartControl with methods turnOn, turnOff and setTimer, then created classes like SmartFan that implement the interface and control the appliances.

package Interface;

interface SmartControl{
	void turnOn();
	void turnOff();
	void setTimer(int timer);
}

class SmartFan implements SmartControl{
	int timer;
	@Override
	public void turnOn() {
		System.out.println("Smartfan turning onn and turns off in "+timer);
	}

	@Override
	public void turnOff() {
		System.out.println("Smartfan turning of....");
	}

	@Override
	public void setTimer(int timer) {
		this.timer=timer;
	}
	
}

public class SmartAppliance {
public static void main(String[] args) {
	SmartFan s=new SmartFan();
}
}
