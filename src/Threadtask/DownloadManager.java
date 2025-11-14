package Thread;

class FileDownloader extends Thread {
    String chunkName;

    FileDownloader(String chunkName) {
        this.chunkName = chunkName;
    }

    public void run() {
        try {
            System.out.println(chunkName + " started downloading...");
            Thread.sleep(2000); // simulate download time
            System.out.println(chunkName + " finished downloading.");
        } catch (Exception e) {}
    }
}

public class DownloadManager {
    public static void main(String[] args) {

        FileDownloader d1 = new FileDownloader("Chunk 1");
        FileDownloader d2 = new FileDownloader("Chunk 2");
        FileDownloader d3 = new FileDownloader("Chunk 3");

        d1.start();
        d2.start();
        d3.start();

        try {
            d1.join();   // wait for chunk 1
            d2.join();   // wait for chunk 2
            d3.join();   // wait for chunk 3
        } catch (Exception e) {}

        System.out.println("Download complete!");
    }
}
