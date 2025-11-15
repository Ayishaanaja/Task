package STATIC_SYNCHRONISATION;

import java.io.*;

class LogWriter {

    public static synchronized void writeLog(String msg) {
        try (ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream("log.txt", true))) {

            out.writeObject(msg);
            System.out.println(Thread.currentThread().getName() + " wrote log");
        } 
        catch (Exception e) { e.printStackTrace(); }
    }
}
public class LogTest {
    public static void main(String[] args) {

        Runnable r = () ->
            LogWriter.writeLog("Log from " + Thread.currentThread().getName());

        new Thread(r, "Logger-1").start();
        new Thread(r, "Logger-2").start();
        new Thread(r, "Logger-3").start();
    }
}
