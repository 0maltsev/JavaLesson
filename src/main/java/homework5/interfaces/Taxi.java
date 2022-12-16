package homework5.interfaces;

import homework5.objects.Order;

import java.util.List;

public interface Taxi {
    void joinThread() throws InterruptedException;

    void run();

    void placeOrder(Order order);

    List<Order> getFinishedOrders();
}
