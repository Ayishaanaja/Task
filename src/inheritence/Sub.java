//hierarchical inheritence from Numbers.java
package inheritence;

public class Sub extends Numbers {
public static void main(String[] args) {
	Sub a=new Sub();
	int diff=(a.a-a.b);
	System.out.println("Substraction of the two numbers "+a.a+" and "+a.b+ " equals "+diff);
}
}
