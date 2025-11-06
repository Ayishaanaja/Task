package Collections;

import java.util.ArrayList;

public class StudentDetails 
{
	ArrayList<Collegedb> st;
	public ArrayList<Collegedb> AddDetails() 
	{
		st=new ArrayList<Collegedb>();
		st.add(new Collegedb(4100,"Ayisha","CS"));
		st.add(new Collegedb(4101,"Aishwarya","EC"));
		st.add(new Collegedb(4102,"Sree","ME"));
		return st;
	}
	
	public Collegedb viewStudent(int admno)
	{
		Collegedb hehe=new Collegedb();
		for(Collegedb c:st)
		{
			if(c.getAdmno()==admno)
			{
				hehe=c;
			}
		}
		return hehe;
	}
	public static void main(String[] args) {
		StudentDetails sd=new StudentDetails();
		ArrayList<Collegedb> all=sd.AddDetails();
		for(Collegedb c:all)
		{
			System.out.println(c);
		}
		System.out.println("--------------------------------------------------------------------------------");
		Collegedb clg=sd.viewStudent(4101);
		System.out.println(clg);
		System.out.println(all);
	}
}
