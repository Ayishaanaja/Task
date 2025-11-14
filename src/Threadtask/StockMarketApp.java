package Thread;
class Stock implements Runnable {
    String name;
    int price;

    Stock(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void run() {
        try {
            while (true) {
                price++;               // increase price by 1
                Thread.sleep(2000);    // updates every 2 seconds
            }
        } catch (Exception e) {}
    }
}

public class StockMarketApp {
    public static void main(String[] args) {

        Stock s1 = new Stock("TATA", 500);
        Stock s2 = new Stock("INFOSYS", 800);
        Stock s3 = new Stock("RELIANCE", 1200);

        new Thread(s1).start();
        new Thread(s2).start();
        new Thread(s3).start();

        
        while (true) {
            System.out.println(
                s1.name + ": " + s1.price + " | " +
                s2.name + ": " + s2.price + " | " +
                s3.name + ": " + s3.price
            );

            try {
                Thread.sleep(1000); // main thread prints every second
            } catch (Exception e) {}
        }
    }
}
