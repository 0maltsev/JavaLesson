package homework_2;

import homework_2.utility.ComparePowerUtility;
import homework_2.utility.CompareVelocityUtility;
import homework_2.utility.vehicleUpgrader;
import homework_2.vehicles.Car;
import homework_2.vehicles.DefaultVehicle;

import static java.util.stream.Collectors.toList;

import java.util.*;
import java.util.function.Predicate;

public class GarageClass<T extends DefaultVehicle> implements Garage<T>{
    private final HashMap<Long, T> carIdMap;
    private final HashMap<Long, Owner> ownerIdMap;

    private final HashMap<String, HashSet<T>> carBrandMap;
    private final HashMap<Owner, HashSet<T>> carOwnerMap;
    private final HashMap<String, HashSet<Owner>> brandOwnerMap;

    private final TreeSet<T> velocitySort;
    private final TreeSet<T> powerSort;

    public GarageClass() {
        carIdMap = new HashMap<>();
        ownerIdMap = new HashMap<>();

        carBrandMap = new HashMap<>();
        carOwnerMap = new HashMap<>();
        brandOwnerMap = new HashMap<>();

        velocitySort = new TreeSet<T>((Comparator<? super T>) new CompareVelocityUtility());
        powerSort = new TreeSet<T>((Comparator<? super T>) new ComparePowerUtility());
    }

    @Override
    public Collection<Owner> allCarsUniqueOwners() {
        return carOwnerMap.keySet();
    }

    @Override
    public Collection<T> topThreeCarsByMaxVelocity() {
        return velocitySort.stream().limit(3).collect(toList());
    }

    @Override
    public Collection<T> allCarsOfBrand(String brand) {
        return carBrandMap.get(brand);
    }

    @Override
    public Collection<T> carsWithPowerMoreThan(int power) {
        Collection<T> сar = (Collection<T>) new DefaultVehicle(-1, "", "", 0, power + 1, -1);
        return powerSort.headSet((T) сar);
    }

    @Override
    public Collection<T> allCarsOfOwner(Owner owner) {
        return carOwnerMap.get(owner);
    }

    @Override
    public int meanOwnersAgeOfCarBrand(String brand) {

        float ageSum = 0.f;


        HashSet<T> carsOfBrand = carBrandMap.get(brand);

        HashSet<Owner> ownersOfBrand = new HashSet<>();
        for (T car : carsOfBrand) {
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
    public T removeCar(Object carObj) {
        return null;
    }

    @Override
    public Collection<T> removeCars(List<? extends T> cars) {
        return cars.stream().map(this::removeCar).toList();
    }

    @Override
    public boolean addCar(DefaultVehicle car, Owner owner) {
        return false;
    }

    @Override
    public List<T> filterCars(Predicate<? super T> predicate) {
        return carIdMap.values().stream().filter(predicate).toList();
    }

    @Override
    public List<Object> upgradeCars(vehicleUpgrader upgrader) {
        return carIdMap.values().stream().map(upgrader::upgrade).toList();
    }

    @Override
    public Car removeCar(long carId) {
        return null;
    }

    @Override
    public boolean addCars(List cars, List owner) {
        return false;
    }



    @Override
    public void addCar(Car car, Owner owner) {
        carIdMap.put(car.getId(), (T) car);
        ownerIdMap.put(car.getId(), owner);


        carOwnerMap.computeIfAbsent(owner, k -> new HashSet<>());

        carBrandMap.computeIfAbsent(car.getBrand(), k -> new HashSet<>());

        carBrandMap.get(car.getBrand()).add((T) car);
        carOwnerMap.get(owner).add((T) car);

        velocitySort.add((T) car);
        powerSort.add((T) car);
    }



}
