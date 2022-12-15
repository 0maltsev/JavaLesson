package homework5;

import homework5.interfaces.Dispatcher;
import homework5.interfaces.Taxi;
import homework5.objects.DispatcherObject;
import homework5.objects.Order;
import homework5.objects.TaxiObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Taxi> createTaxis(Dispatcher dispatcher, int count) {
        List<Taxi> taxis = new ArrayList<>(count);
        for (int i = 0; i < count; ++i) {
            taxis.add(new TaxiObject(dispatcher));
        }

        return taxis;
    }

    private static void runTaxis(List<Taxi> taxis) {
        for (Taxi taxi : taxis) {
            taxi.run();
        }
    }

    private static void stopTaxis(List<Taxi> taxis) throws InterruptedException {
        for (Taxi taxi : taxis) {
            taxi.joinThread();
        }
    }

    // usage example
    public static void main(String[] args) throws InterruptedException {
        int ordersCount = 120;

        DispatcherObject dispatcher = new DispatcherObject();
        List<Taxi> taxis = createTaxis(dispatcher, 50);
        dispatcher.run();
        runTaxis(taxis);

        for (int i = 0; i < ordersCount; ++i) {
            Order order = new Order();
            dispatcher.addOrder(order);
        }

        dispatcher.joinThread();
        stopTaxis(taxis);
    }
}
