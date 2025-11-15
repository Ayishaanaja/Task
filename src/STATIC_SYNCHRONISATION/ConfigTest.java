package STATIC_SYNCHRONISATION;
import java.io.*;

class ClinicConfig implements Serializable {

    public static String hospitalName = "City Hospital";
    public static String location = "Downtown";

    public static synchronized void saveConfig() {
        try (ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream("config.ser"))) {

            out.writeObject(hospitalName);
            out.writeObject(location);

            System.out.println(Thread.currentThread().getName() + " saved config");
        } 
        catch (Exception e) { e.printStackTrace(); }
    }
}

public class ConfigTest {
	    public static void main(String[] args) {

	        Runnable task = ClinicConfig::saveConfig;

	        Thread t1 = new Thread(task, "Thread-1");
	        Thread t2 = new Thread(task, "Thread-2");

	        t1.start();
	        t2.start();
	    }
	}
