package homework_2.test;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import homework_2.GarageClass;
import homework_2.Car;
import homework_2.Owner;

import static java.util.stream.Collectors.toList;

public class UnitTest {
    @Test
    public void allCarsOfBrandTest() {
        var garage = new GarageClass();

        var owner = new Owner(1, "A", "A", 11);

        var cars = Arrays.asList(new Car(1, "AA", "a", 3, 10, 1),
                new Car(2, "AA", "b", 4, 20, 1),
                new Car(2, "BB", "c", 5, 10, 1));

        cars.forEach((Car car) -> garage.addCar(car, owner));
        var brand_cars = garage.allCarsOfBrand("AA");

        Assertions.assertTrue(brand_cars.stream().anyMatch(car -> car.getBrand().equals("AA")));
    }


    @Test
    public void allCarsUniqueOwners() {
        var owners = Arrays.asList(new Owner(1, "A", "A", 11),
                new Owner(2, "B", "B", 21),
                new Owner(3, "C", "C", 31),
                new Owner(4, "D", "D", 41),
                new Owner(5, "E", "E", 51),
                new Owner(6, "F", "F", 61),
                new Owner(7, "G", "G", 71));

        var garage = new GarageClass();

        for (int i = 0; i < 3; ++i) {
            for (int j = 1; j <= 7; ++j) {
                var car = new Car(j + i * 7, "AA", "a", 2, 1, j);
                garage.addCar(car, owners.get(j - 1));
            }
        }

        var owner_id_comparator = Comparator.comparingLong(Owner::getId);
        var unique_owners = garage.allCarsUniqueOwners().stream().sorted(owner_id_comparator).collect(toList());

        Assertions.assertTrue(unique_owners.equals(owners));
    }

    @Test
    public void carsWithPowerMoreThanTest() {
        var garage = new GarageClass();

        var owner = new Owner(1, "A", "A", 11);

        var cars = Arrays.asList(new Car(1, "AA", "a", 3, 10, 1),
                new Car(2, "AA", "b", 4, 20, 1),
                new Car(2, "BB", "c", 5, 10, 1));

        cars.forEach((Car car) -> garage.addCar(car, owner));

        var power_cars = garage.carsWithPowerMoreThan(12);
        Assertions.assertTrue(power_cars.stream().anyMatch(car -> car.getPower() > 12));
    }

    @Test
    public void topThreeCarsByMaxVelocityTest() {
        var garage = new GarageClass();

        var lenin_owner = new Owner(1, "Vladimir", "Lenin", 47);

        var lenins_cars = Arrays.asList(new Car(1, "AA", "a", 3, 10, 1),
                new Car(2, "AA", "b", 4, 20, 1),
                new Car(2, "BB", "c", 5, 10, 1),
                new Car(4, "BB", "d", 50, 10, 1),
                new Car(5, "CC", "e", 50, 10, 1));

        lenins_cars.forEach((Car car) -> garage.addCar(car, lenin_owner));

        var speed_cars = garage.topThreeCarsByMaxVelocity();
        Assertions.assertTrue(speed_cars.stream().anyMatch(car -> car.getMaxVelocity() == 50));
    }

    @Test
    public void meanCarNumberForEachOwnerTest() {
        var owners = Arrays.asList(new Owner(1, "A", "A", 11),
                new Owner(2, "B", "B", 21),
                new Owner(3, "C", "C", 31),
                new Owner(4, "D", "D", 41),
                new Owner(5, "E", "E", 51),
                new Owner(6, "F", "F", 61),
                new Owner(7, "G", "G", 71));

        var garage = new GarageClass();

        for (int i = 0; i < 3; ++i) {
            for (int j = 1; j <= 7; ++j) {
                var car = new Car(j + i * 7, "A", "a", 200, 100, j);
                garage.addCar(car, owners.get(j - 1));
            }
        }

        Assertions.assertEquals(garage.meanCarNumberForEachOwner(), 3);
    }

    @Test
    public void meanOwnersAgeOfCarBrandTest() {
        var owners = Arrays.asList(new Owner(1, "A", "A", 11),
                new Owner(2, "B", "B", 21),
                new Owner(3, "C", "C", 31),
                new Owner(4, "D", "D", 41),
                new Owner(5, "E", "E", 51),
                new Owner(6, "F", "F", 61),
                new Owner(7, "G", "G", 71));

        var garage = new GarageClass();

        for (int i = 0; i < 3; ++i) {
            for (int j = 1; j <= 7; ++j) {
                var car = new Car(j + i * 7, "A", "a", 200, 100, j);
                garage.addCar(car, owners.get(j - 1));
            }
        }

        Assertions.assertEquals(garage.meanOwnersAgeOfCarBrand("A"), 41.0);
    }
}
