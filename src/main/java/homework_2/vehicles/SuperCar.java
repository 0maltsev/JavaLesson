package homework_2.vehicles;

public class SuperCar extends DefaultVehicle{
    private final int uniqueSuperCarFeature;

    public SuperCar(long carId, String brand, String modelName, int maxVelocity, int power, int ownerId, int uniqueSuperCarFeature) {
        super(carId, brand, modelName, maxVelocity, power, ownerId);
        this.uniqueSuperCarFeature = uniqueSuperCarFeature;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SuperCar superCar = (SuperCar) object;
        return this.getId() == superCar.getId();
    }
}
