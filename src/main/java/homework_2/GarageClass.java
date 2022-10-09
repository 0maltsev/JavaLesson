package homework_2;

import homework_2.utility.ComparePowerUtility;
import homework_2.utility.CompareVelocityUtility;
import static java.util.stream.Collectors.toList;

import java.util.*;
import java.util.stream.Collectors;

public class GarageClass implements Garage{
    private final HashMap<Long, Car> carIdMap;
    private final HashMap<Long, Owner> ownerIdMap;

    private final HashMap<String, HashSet<Car>> carBrandMap;
    private final HashMap<Owner, HashSet<Car>> carOwnerMap;
    private final HashMap<String, HashSet<Owner>> brandOwnerMap;

    private final TreeSet<Car> velocitySort;
    private final TreeSet<Car> powerSort;

    public GarageClass() {
        carIdMap = new HashMap<>();
        ownerIdMap = new HashMap<>();

        carBrandMap = new HashMap<>();
        carOwnerMap = new HashMap<>();
        brandOwnerMap = new HashMap<>();

        velocitySort = new TreeSet<Car>(new CompareVelocityUtility());
        powerSort = new TreeSet<Car>(new ComparePowerUtility());
    }

    @Override
    public Collection<Owner> allCarsUniqueOwners() {
        return carOwnerMap.keySet();
    }

    @Override
    public Collection<Car> topThreeCarsByMaxVelocity() {
        return velocitySort.stream().limit(3).collect(toList());
    }

    @Override
    public Collection<Car> allCarsOfBrand(String brand) {
        return carBrandMap.get(brand);
    }

    @Override
    public Collection<Car> carsWithPowerMoreThan(int power) {
        Car сar = new Car(-1, "", "", 0, power + 1, -1);
        return powerSort.headSet(сar);
    }

    @Override
    public Collection<Car> allCarsOfOwner(Owner owner) {
        return carOwnerMap.get(owner);
    }

    @Override
    public int meanOwnersAgeOfCarBrand(String brand) {

        float ageSum = 0.f;


        HashSet<Car> carsOfBrand = carBrandMap.get(brand);

        HashSet<Owner> ownersOfBrand = new HashSet<>();
        for (Car car : carsOfBrand) {
            ownersOfBrand.add(ownerIdMap.get(car.getId()));
        }


        for (Owner owner : ownersOfBrand) {
            ageSum = ageSum + owner.getAge();
        }

        return Math.round(ageSum / ownersOfBrand.size());
    }

    @Override
    public long meanCarNumberForEachOwner() {

        long counter = 0;
        double meanAmount = 0;
        for (Owner owner : carOwnerMap.keySet()) {
            meanAmount = meanAmount * counter;
            counter = counter + 1;
            meanAmount += carOwnerMap.get(owner).size();
            meanAmount = meanAmount/counter;
        }
        return Math.round(meanAmount);
    }


    @Override
    public Car removeCar(long carId) {
        Car car = carIdMap.get(carId);
        carIdMap.remove(carId);

        carBrandMap.get(car.getBrand()).remove(car);
        carOwnerMap.get(ownerIdMap.get(car.getOwnerId())).remove(car);

        powerSort.remove(car);
        velocitySort.remove(car);

        return car;
    }


    @Override
    public void addCar(Car car, Owner owner) {
        carIdMap.put(car.getId(), car);
        ownerIdMap.put(car.getId(), owner);


        carOwnerMap.computeIfAbsent(owner, k -> new HashSet<>());

        carBrandMap.computeIfAbsent(car.getBrand(), k -> new HashSet<>());

        carBrandMap.get(car.getBrand()).add(car);
        carOwnerMap.get(owner).add(car);

        velocitySort.add(car);
        powerSort.add(car);
    }



}
