package homework_2.vehicles;

public class Car extends DefaultVehicle {

    private final int uniqueCarFeature;

    public Car(long carId, String brand, String modelName, int maxVelocity, int power, int ownerId, int uniqueCarFeature) {
        super(carId, brand, modelName, maxVelocity, power, ownerId);
        this.uniqueCarFeature = uniqueCarFeature;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return this.getId() == car.getId();
    }
}


