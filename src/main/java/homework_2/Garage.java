package homework_2;

import homework_2.utility.vehicleUpgrader;
import homework_2.vehicles.Car;
import homework_2.vehicles.DefaultVehicle;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public interface Garage <T extends DefaultVehicle>{

    Collection<Owner> allCarsUniqueOwners();


    Collection<T> topThreeCarsByMaxVelocity();


    Collection<T> allCarsOfBrand(String brand);


    Collection<T> carsWithPowerMoreThan(int power);


    Collection<T> allCarsOfOwner(Owner owner);


    int meanOwnersAgeOfCarBrand(String brand);


    long meanCarNumberForEachOwner();

    T removeCar(Object car);

    Collection<T> removeCars(List<? extends T> cars);



    boolean addCar(T car, Owner owner);

    boolean addCars(List<? extends T> cars, List<Owner> owner);

    List<T> filterCars(Predicate<? super T> predicate);

    List<Object> upgradeCars(vehicleUpgrader upgrader);


    Car removeCar(long carId);

    void addCar(Car car, Owner owner);
}

