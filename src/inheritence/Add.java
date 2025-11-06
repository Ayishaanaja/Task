//hierarchical inheritence from Numbers.java
package inheritence;

public class Add extends Numbers{
public static void main(String[] args) {
	Add a=new Add();
	int sum=a.a+a.b;;
	System.out.println("Addition of the two numbers "+a.a+" and "+a.b+ " equals "+sum);
}
}
