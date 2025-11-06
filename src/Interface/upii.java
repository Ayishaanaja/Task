package Interface;

interface PaymentGateway {
	void processPayment(int amount); 
	void refund(int amount);
}
class UPI implements PaymentGateway{
	String UpiId;
	public UPI(String upiId)
	{
		this.UpiId=upiId;
	}
	@Override
	public void processPayment(int amount) {
		System.out.println("Payment of rs."+amount+" is debitted from UPI ID: "+UpiId);
	}

	@Override
	public void refund(int amount) {
		System.out.println("Refund of rs."+amount+" is creditted to UPI ID: "+UpiId);

	}
	
}
public class upii {
public static void main(String[] args) {
	UPI u=new UPI("hehe@sbi");
	u.processPayment(10000);
	u.refund(2000);
}
}
