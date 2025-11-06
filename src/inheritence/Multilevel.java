package inheritence;
class Person {
    public void eat() {
        System.out.println("Person eats food.");
    }
}
class Employee extends Person {
    public void work() {
        System.out.println("Employee works in an office.");
    }
}
class Manager extends Employee {
    public void manageTeam() {
        System.out.println("Manager leads the team.");
    }
}
public class Multilevel {
    public static void main(String[] args) {
        Manager mgr = new Manager();

        mgr.eat();         // From Person
        mgr.work();        // From Employee
        mgr.manageTeam();  // From Manager
    }
}

