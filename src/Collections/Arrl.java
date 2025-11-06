package Collections;

import java.util.ArrayList;

public class Arrl {
	public static void main(String[] args) {
		ArrayList al=new ArrayList();
		al.add("Mango");
		al.add(80);
		al.add('x');
		al.add(55.66f);
		al.add("Mango");
		al.remove(2);
		al.set(3,"Apple");
		System.out.println(al);
	}
}
