//single inheritence from Father
package inheritence;

class Father {
String name="Appan";
}

public class Son extends Father{
public static void main(String[] args) {
	{
		Son s=new Son();
		System.out.println("Father is "+s.name);
	}
}
}
