package inheritence;

public class overlaoding {
	overlaoding()
	{
		System.out.println("pinne entha");
	}
	overlaoding(int y)
	{
		System.out.println("constructor input "+y);
	}
	void hehe()
	{
		System.out.println("no input");
	}
	void hehe(int x)
	{
		System.out.println("first input "+x);
	}
	void hehe(String h)
	{
		System.out.println("input string is "+h);
	}
	public static void main(String[] args) {
		overlaoding o=new overlaoding();
		o.hehe();
		o.hehe(90);
		o.hehe("hiiiiiiiii");
	}
}
