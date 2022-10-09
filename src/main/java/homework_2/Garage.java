package homework_2;

import java.util.Collection;

public interface Garage {

    Collection<Owner> allCarsUniqueOwners();


    Collection<Car> topThreeCarsByMaxVelocity();


    Collection<Car> allCarsOfBrand(String brand);


    Collection<Car> carsWithPowerMoreThan(int power);


    Collection<Car> allCarsOfOwner(Owner owner);


    int meanOwnersAgeOfCarBrand(String brand);


    long meanCarNumberForEachOwner();




    Car removeCar(long carId);

    void addCar(Car car, Owner owner);
}

