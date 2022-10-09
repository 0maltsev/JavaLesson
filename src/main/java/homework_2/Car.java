package homework_2;

import java.util.Objects;

public class Car {
    private final long carId;
    private final String brand;
    private final String modelName;
    private final int maxVelocity;
    private final int power;
    private final int ownerId;

    public Car(long carId, String brand, String modelName, int maxVelocity, int power, int ownerId) {
        this.carId = carId;
        this.brand = brand;
        this.modelName = modelName;
        this.maxVelocity = maxVelocity;
        this.power = power;
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return carId == car.carId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId);
    }

    public long getId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public long getPower() {
        return power;
    }

    public long getMaxVelocity() {
        return maxVelocity;
    }

    public int getOwnerId() {
        return ownerId;
    }
}


