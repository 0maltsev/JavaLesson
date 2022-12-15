package homework5.objects;

import homework5.interfaces.Dispatcher;
import homework5.interfaces.Taxi;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class TaxiObject implements Taxi , Comparable<TaxiObject> {
    private final Dispatcher dispatcher;
    private final List<Order> finishedOrders;
    private final BlockingQueue<Order> activeOrder;
    private final AtomicBoolean isInUse;
    private final Thread taxiThread;


    public TaxiObject(Dispatcher dispatcher) {
        this.isInUse = new AtomicBoolean(false);

        this.activeOrder = new PriorityBlockingQueue<>();
        this.finishedOrders = new ArrayList<>();

        this.dispatcher = dispatcher;

        this.taxiThread = new Thread(() -> {
            this.dispatcher.notifyAvailable(this);
            while (true) {
                try {
                    Order nextOrder = activeOrder.take();

                    nextOrder.finishOrder();
                    synchronized (this) {
                        finishedOrders.add(nextOrder);
                    }

                    this.dispatcher.notifyAvailable(this);

                } catch (InterruptedException exception) {
                    throw new RuntimeException(exception);
                }
            }
        });
    }

    @Override
    public void joinThread() throws InterruptedException {
        if (isInUse.get()) {
            throw new RuntimeException("Already joined!");
        }
        isInUse.set(true);
        taxiThread.join();
    }

    @Override
    public void run() {
        taxiThread.start();
    }

    @Override
    public void placeOrder(Order order) {
        if (!isInUse.get()) {
            activeOrder.add(order);
        }
    }

    @Override
    public synchronized List<Order> getFinishedOrders() {
        return new ArrayList<>(finishedOrders);
    }

    @Override
    public int compareTo(TaxiObject o) {
        return 0;
    }
}
