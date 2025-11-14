package Thread;

class StatusUpdater implements Runnable {
    public void run() {
        try {
            System.out.println("Order Received");
            Thread.sleep(5000);
            System.out.println("Out for Delivery");
            Thread.sleep(5000);
            System.out.println("Delivered");
        } catch (Exception e) {}
    }
}

class ETAUpdater implements Runnable {
    public void run() {
        try {
            int time = 30;
            while (time >= 0) {
                System.out.println("Estimated Time of Arrival: " + time + " mins");
                Thread.sleep(3000);
                time -= 3;
            }
        } catch (Exception e) {}
    }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {
        Thread t1 = new Thread(new StatusUpdater());
        Thread t2 = new Thread(new ETAUpdater());

        t1.start();
        t2.start();
    }
}
