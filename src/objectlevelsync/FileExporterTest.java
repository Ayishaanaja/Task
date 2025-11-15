package objectlevelsync;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class FileExporter {

    // Map to store a separate lock for each file
    private static final Map<String, Object> fileLocks = new ConcurrentHashMap<>();

    // Get or create lock object for a file
    private static Object getFileLock(String fileName) {
        return fileLocks.computeIfAbsent(fileName, key -> new Object());
    }

    // Method to serialize any object into a file
    public void exportToFile(String fileName, Object obj) {

        Object lock = getFileLock(fileName);  // custom lock for this file

        synchronized (lock) {
            try (ObjectOutputStream oos =
                         new ObjectOutputStream(
                                 new FileOutputStream(fileName, true))) {

                System.out.println(Thread.currentThread().getName()
                        + " → Writing to file: " + fileName);

                // Actual serialization
                oos.writeObject(obj);

                Thread.sleep(1000);  // slow down to show locking

                System.out.println(Thread.currentThread().getName()
                        + " → Finished writing: " + fileName);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
public class FileExporterTest {
    public static void main(String[] args) {

        FileExporter exporter = new FileExporter();

        // Threads writing to the SAME file → will BLOCK each other
        Thread t1 = new Thread(() -> exporter.exportToFile("doctor.ser", "Data1"), "T1");
        Thread t2 = new Thread(() -> exporter.exportToFile("doctor.ser", "Data2"), "T2");

        // Threads writing to DIFFERENT files → run in PARALLEL
        Thread t3 = new Thread(() -> exporter.exportToFile("patient.ser", "DataA"), "T3");
        Thread t4 = new Thread(() -> exporter.exportToFile("nurse.ser", "DataB"), "T4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
