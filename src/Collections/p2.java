package Collections;

import java.util.*;
public class p2 {
	ArrayList<Employee> al;
		public ArrayList<Employee> addAndViewAllEmployee()
		{
			al=new ArrayList<Employee>();
			al.add(new Employee(101,"Vijay",45000));
			al.add(new Employee(102,"Karthik",56000));
			al.add(new Employee(103,"Praveen",66000));
			return al;
		}
		
		public Employee viewEmployeeById(int empid)
		{
			Employee eb=new Employee();
			for(Employee e:al)
			{
				if(e.getEmpid()==empid)
				{
					eb=e;
				}
			}
			return eb;
		}

		public static void main(String[] args) 
		{
			p2 ld=new p2();
			ArrayList<Employee> allEmp=ld.addAndViewAllEmployee();
			//allEmp.forEach(e->{System.out.println(e.getEmpid()+" "+e.getEmpname()+" "+e.getEmpsal());});
			Employee emp=ld.viewEmployeeById(102);
			System.out.println(emp.getEmpid()+" "+emp.getEmpname()+" "+emp.getEmpsal());
		}
}