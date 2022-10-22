package homework_2.vehicles;

import homework_2.vehicles.Vehicle;

public class DefaultVehicle implements Vehicle {

    private final long carId;
    private final String brand;
    private final String modelName;
    private final int maxVelocity;
    private final int power;
    private final int ownerId;

    public DefaultVehicle(
            long carId,
            String brand,
            String modelName,
            int maxVelocity,
            int power,
            int ownerId
    ) {
        this.carId = carId;
        this.brand = brand;
        this.modelName = modelName;
        this.maxVelocity = maxVelocity;
        this.power = power;
        this.ownerId = ownerId;
    }

    @Override
    public long getId() {
        return carId;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public long getPower() {
        return power;
    }

    @Override
    public long getMaxVelocity() {
        return maxVelocity;
    }

    @Override
    public int getOwnerId() {
        return ownerId;
    }
}
