package homework_2.utility;

import homework_2.Car;

import java.util.Comparator;

public class ComparePowerUtility implements Comparator<Car> {

    @Override
    public int compare(Car first, Car second) {
        int power = Long.compare(first.getPower(), second.getPower());
        if (power == 0) {
            return (-1) * Long.compare(first.getId(), second.getId());
        }
        return (-1) * power;
    }
}
