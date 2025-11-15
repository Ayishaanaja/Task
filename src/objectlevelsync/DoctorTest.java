package objectlevelsync;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
 class Doctor implements Serializable {

    private String name;

    public Doctor(String name) {
        this.name = name;
    }

    // Object-level synchronization: lock = THIS object
    public void serializeDoctor() {

        synchronized (this) {
            try (ObjectOutputStream oos =
                         new ObjectOutputStream(new FileOutputStream(name + ".ser", true))) {

                System.out.println(Thread.currentThread().getName() +
                        " serializing Doctor: " + name);

                Thread.sleep(1000);  // simulate work

                oos.writeObject(this);

                System.out.println(Thread.currentThread().getName() +
                        " FINISHED Doctor: " + name);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
public class DoctorTest {
    public static void main(String[] args) {

        // Three independent Doctor objects
        Doctor doc1 = new Doctor("Dr.Alex");
        Doctor doc2 = new Doctor("Dr.John");
        Doctor doc3 = new Doctor("Dr.Maya"); // SAME NAME but DIFFERENT object
        Doctor doc4 = doc1; // SAME OBJECT as doc1

        // Running serialization on different objects
        Thread t1 = new Thread(doc1::serializeDoctor, "T1");
        Thread t2 = new Thread(doc2::serializeDoctor, "T2");
        Thread t3 = new Thread(doc3::serializeDoctor, "T3");
        Thread t4 = new Thread(doc4::serializeDoctor, "T4"); // same as doc1 (blocking)

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
