package homework_2.utility;

import homework_2.Car;

import java.util.Comparator;

public class CompareVelocityUtility implements Comparator<Car> {

    @Override
    public int compare(Car first, Car second) {
        int velocity = Long.compare(first.getMaxVelocity(), second.getMaxVelocity());
        if (velocity == 0) {
            return (-1) * Long.compare(first.getId(), second.getId());
        }
        return (-1) * velocity;
    }
}
