package homework_2.vehicles;

public class Truck extends DefaultVehicle{
    private final int uniqueTruckFeature;

    public Truck(long carId, String brand, String modelName, int maxVelocity, int power, int ownerId, int uniqueTruckFeature) {
        super(carId, brand, modelName, maxVelocity, power, ownerId);
        this.uniqueTruckFeature = uniqueTruckFeature;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Truck truck = (Truck) object;
        return this.getId() == truck.getId();
    }
}
