package STATIC_SYNCHRONISATION;

import java.io.*;

class HospitalStats {

    public static int patientCount = 0;

    public static synchronized void increment() {
        patientCount++;
    }

    public static synchronized void saveStats() {
        try (ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream("stats.ser"))) {

            out.writeInt(patientCount);
            System.out.println(Thread.currentThread().getName() +
                    " saved patientCount=" + patientCount);
        } 
        catch (Exception e) { e.printStackTrace(); }
    }
}
public class StatsTest {
    public static void main(String[] args) {

        Runnable r = () -> {
            HospitalStats.increment();
            HospitalStats.saveStats();
        };

        new Thread(r, "Stats-1").start();
        new Thread(r, "Stats-2").start();
        new Thread(r, "Stats-3").start();
    }
}