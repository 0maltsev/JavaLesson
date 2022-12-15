package homework5.objects;

import homework5.interfaces.Dispatcher;
import homework5.interfaces.Taxi;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class DispatcherObject implements Dispatcher {
    private final BlockingQueue<Order> orderQueue;
    private final BlockingQueue<Taxi> taxiQueue;
    private final AtomicBoolean isInUse;
    private final Thread thread;


    public DispatcherObject() {
        this.taxiQueue = new PriorityBlockingQueue<>();
        this.orderQueue = new PriorityBlockingQueue<>();
        this.isInUse = new AtomicBoolean(false);

        this.thread = new Thread(() -> {
            while (true) {
                try {
                    Order nextOrder = orderQueue.take();

                    placeOrder(taxiQueue.take(), nextOrder);
                } catch (InterruptedException exception) {
                    throw new RuntimeException(exception);
                }
            }
        });
    }

    public void addOrder(Order order) {
        if (!isInUse.get()) {
            orderQueue.add(order);
        }
    }

    @Override
    public void notifyAvailable(Taxi taxi) {
        taxiQueue.add(taxi);
    }

    @Override
    public void placeOrder(Taxi taxi, Order order) {
        taxi.placeOrder(order);
    }

    @Override
    public void run() {
        thread.start();
    }

    public void joinThread() throws InterruptedException {
        if (isInUse.get()) {
            throw new RuntimeException("Already joined!");
        }

        isInUse.set(true);

        thread.join();
    }

}
