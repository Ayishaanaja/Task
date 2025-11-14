package methodSynchronization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Appointment implements Serializable {
    private String patientName;
    private String doctorName;
    private String appointmentTime;
    private String appointmentId;

    public Appointment(String patientName, String doctorName, String appointmentTime, String appointmentId) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentTime = appointmentTime;
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    @Override
    public String toString() {
        return "Appointment [Patient: " + patientName + ", Doctor: " + doctorName + ", Time: " + appointmentTime + ", ID: " + appointmentId + "]";
    }
}

class AppointmentSerializer {
       public synchronized void saveAppointment(Appointment appointment) {
        try (FileOutputStream fileOut = new FileOutputStream("appointments.ser", true); // Append mode
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(appointment);
            System.out.println("Appointment for " + appointment.getPatientName() + " saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class AppointmentBookingThread extends Thread {
    private Appointment appointment;

    public AppointmentBookingThread(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public void run() {
    	AppointmentSerializer as=new AppointmentSerializer();
        as.saveAppointment(appointment);
    }
}

public class AppointmentBookingApp {
    public static void main(String[] args) {
        Appointment appointment1 = new Appointment("John Doe", "Dr. Smith", "2025-11-15 10:00 AM", "APT001");
        Appointment appointment2 = new Appointment("Jane Smith", "Dr. Lee", "2025-11-15 11:00 AM", "APT002");
        Appointment appointment3 = new Appointment("Emily Johnson", "Dr. Brown", "2025-11-15 02:00 PM", "APT003");

        Thread thread1 = new AppointmentBookingThread(appointment1);
        Thread thread2 = new AppointmentBookingThread(appointment2);
        Thread thread3 = new AppointmentBookingThread(appointment3);

        thread1.start();
        thread2.start();
        thread3.start();

//        System.out.println("All appointment bookings have been processed.");
    }
}
