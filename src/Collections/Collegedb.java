package Collections;

public class Collegedb {
private int admno;
private String name;
private String dept;
public int getAdmno() {
	return admno;
}
public Collegedb()
{
}
public Collegedb(int admno, String name, String dept) {
	super();
	this.admno = admno;
	this.name = name;
	this.dept = dept;
}
@Override
public String toString() {
	return "Collegedb [admno=" + admno + ", name=" + name + ", dept=" + dept + "]";
}

}
