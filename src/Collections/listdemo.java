package Collections;

import java.util.ArrayList;
import java.util.Iterator;

public class listdemo {
public static void main(String[] args) {
	ArrayList<String> al=new ArrayList<String>();
	al.add("mango");
	al.add("Apple");
	al.add("pappaya");
	Iterator itr=al.iterator();
	while(itr.hasNext())
	{
		System.out.println((String)itr.next());
	}
}
}
