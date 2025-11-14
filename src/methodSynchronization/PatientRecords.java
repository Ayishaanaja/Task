package methodSynchronization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
class Patientbean implements Serializable {
    private String patientname;
    private int patientage;
    private String patientid;

    public Patientbean(String patientname, int patientage, String patientid) {
        this.patientname = patientname;
        this.patientage = patientage;
        this.patientid = patientid;
    }

    public String getPatientname() {
        return patientname;
    }

    public int getPatientage() {
        return patientage;
    }

    public String getPatientid() {
        return patientid;
    }

    @Override
    public String toString() {
        return "Patient [Name=" + patientname + ", Age=" + patientage + ", ID=" + patientid + "]";
    }
}

class PatientSerializer {
    public synchronized void savePatient(Patientbean patient) {
        try (FileOutputStream fileOut = new FileOutputStream("patient_records.ser", true); 
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(patient);
            System.out.println("Patient " + patient.getPatientname() + " saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Desk1 extends Thread {
    private Patientbean patient;

    public Desk1(Patientbean patient) {
        this.patient = patient;
    }

    @Override
    public void run() {
    	PatientSerializer ps=new PatientSerializer();
        ps.savePatient(patient);
    }
}

public class PatientRecords {
    public static void main(String[] args) {
        Patientbean patient1 = new Patientbean("John Doe", 30, "P001");
        Patientbean patient2 = new Patientbean("Jane Smith", 25, "P002");
        Patientbean patient3 = new Patientbean("Emily Johnson", 40, "P003");

        Thread thread1 = new Desk1(patient1);
        Thread thread2 = new Desk1(patient2);
        Thread thread3 = new Desk1(patient3);

        thread1.start();
        thread2.start();
        thread3.start();

//        try {
//            thread1.join();
//            thread2.join();
//            thread3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        System.out.println("All patient records have been processed.");
    }
}