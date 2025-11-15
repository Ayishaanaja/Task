package objectlevelsync;

import java.io.*;

class PatientReport implements Serializable {
    String reportId;

    public PatientReport(String reportId) {
        this.reportId = reportId;
    }

    @Override
    public String toString() {
        return "Report: " + reportId;
    }
}

class ReportExporter {

    // Non-synchronized method
    public void exportReport(PatientReport report) {
        System.out.println(Thread.currentThread().getName() + " trying to export " + report);

        // Selective synchronization: only lock on this *particular* report
        synchronized (report) {

            System.out.println(Thread.currentThread().getName() +
                    " STARTED exporting " + report);

            // ---- Serialization logic ----
            try (ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(report.reportId + ".ser"))) {

                Thread.sleep(2000); // simulate long task
                oos.writeObject(report);

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() +
                    " FINISHED exporting " + report);
        }
    }
}

public class SelectiveSyncDemo {
    public static void main(String[] args) {

        ReportExporter exporter = new ReportExporter();

        PatientReport r1 = new PatientReport("R100");
        PatientReport r2 = new PatientReport("R200");

        // Threads working on SAME report → will block each other
        Thread t1 = new Thread(() -> exporter.exportReport(r1), "T1");
        Thread t2 = new Thread(() -> exporter.exportReport(r1), "T2");

        // Threads working on DIFFERENT reports → run in parallel
        Thread t3 = new Thread(() -> exporter.exportReport(r2), "T3");

        t1.start();
        t2.start();
        t3.start();
    }
}

