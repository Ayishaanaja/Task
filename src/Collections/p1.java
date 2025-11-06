package Collections;

import java.util.ArrayList;

public class p1 {
public static void main(String[] args) {
	emp e1=new emp();
	e1.setEmpid(101);
	e1.setEmpname("ayisha");
	e1.setEmpsal(400000);
	
	emp e2=new emp();
	e2.setEmpid(102);
	e2.setEmpname("Aiswarya");
	e2.setEmpsal(430000);
	
	emp e3=new emp();
	e3.setEmpid(103);
	e3.setEmpname("Merin");
	e3.setEmpsal(4200000);
	
	ArrayList<emp> arl=new ArrayList<emp>();
	arl.add(e1);
	arl.add(e2);
	arl.add(e3);
	//System.out.println(arl);
	for (emp s:arl)
	{
		System.out.println(s.getEmpid()+" "+s.getEmpname()+" "+s.getEmpsal());
	}
	
}
}
