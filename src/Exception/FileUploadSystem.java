package Exception;

import java.io.*;

public class FileUploadSystem {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            // ✅ Correct path - remove extra quotes and point to an actual file
        	File file = new File("C:\\Users\\aiswa_h\\OneDrive\\Documents\\A.txt");


            fis = new FileInputStream(file);
            int data;
            System.out.println("Reading file content:");
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        } catch (SecurityException e) {
            System.out.println("Security Error: You don't have permission to access this file!");
        } catch (IOException e) {
            System.out.println("I/O Error occurred while reading the file.");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                    System.out.println("\nFile closed successfully.");
                }
            } catch (IOException e) {
                System.out.println("Error while closing the file.");
            }
        }
    }
}
