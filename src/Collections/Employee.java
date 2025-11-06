package Collections;
public class Employee {
private int empid;
private String empname;
private int empsal;
public Employee()
{
}
public Employee(int empid, String empname, int empsal) {
this.empid = empid;
this.empname = empname;
this.empsal = empsal;
}
public int getEmpid() {
return empid;
}
public void setEmpid(int empid) {
this.empid = empid;
}
public String getEmpname() {
return empname;
}
public void setEmpname(String empname) {
this.empname = empname;
}
public int getEmpsal() {
return empsal;
}
public void setEmpsal(int empsal) {
this.empsal = empsal;
}
@Override
public String toString() {
return "Employee [empid=" + empid + ", empname=" + empname + ", empsal=" + empsal + "]\n";
}
}