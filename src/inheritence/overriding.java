package inheritence;
class app
{
	void version()//if static cannot be overwritten
	{
		System.out.println("App version 8");
	}
}
class newapp extends app
{
	void version()
	{
		super.version();
		System.out.println("App version changed to 9");
	}
}
public class overriding {
	public static void main(String[] args) {
		newapp n=new newapp();
		n.version();
	}

}
