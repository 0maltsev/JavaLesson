package homework5.interfaces;

import homework5.objects.Order;

public interface Dispatcher {
    void notifyAvailable(Taxi taxi);

    void placeOrder(Taxi taxi, Order order);

    void run();
}
