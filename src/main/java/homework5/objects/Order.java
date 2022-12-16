package homework5.objects;

public class Order implements Comparable<Order>{
    private final long orderId;
    private static long nextOrderId = 0;


    public Order() {
        this.orderId = nextOrderId++;
    }

    public void finishOrder()  {
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }

        System.out.println("Finish " + orderId);
    }

    @Override
    public int compareTo(Order o) {
        return 0;
    }
}
