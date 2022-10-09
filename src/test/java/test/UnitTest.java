package test;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import homework_2.GarageClass;
import homework_2.Car;
import homework_2.Owner;



public class UnitTest {

    @Test
    public void allCarsUniqueOwners() {
        var owners = Arrays.asList(new Owner(1, "A", "A", 11),
                new Owner(2, "B", "B", 21),
                new Owner(3, "C", "C", 31),
                new Owner(4, "D", "D", 41),
                new Owner(5, "E", "E", 51));

        var garage = new GarageClass();

        for (int k = 0; k < 3; ++k) {
            for (int n = 1; n <= 5; ++n) {
                var car = new Car(n + k * 5, "A", "a", 1, 1, n);
                garage.addCar(car, owners.get(n - 1));
            }
        }

        var uniqueOwners = garage.allCarsUniqueOwners().stream().
                sorted(Comparator.comparingLong(Owner::getId)).toList();

        Assertions.assertEquals(uniqueOwners, owners);
    }

    @Test
    public void topThreeCarsByMaxVelocityTest() {

        var owner = new Owner(1, "A", "A", 1);

        var garage = new GarageClass();

        var cars = Arrays.asList(new Car(1, "AA", "a", 3, 10, 1),
                new Car(2, "AA", "b", 2, 10, 1),
                new Car(4, "BB", "d", 10, 10, 1),
                new Car(5, "CC", "e", 10, 10, 1));

        cars.forEach((Car car) -> garage.addCar(car, owner));

        Assertions.assertTrue(garage.topThreeCarsByMaxVelocity().stream().anyMatch(car -> car.getMaxVelocity() == 10));
    }


    @Test
    public void allCarsOfBrandTest() {

        var owner = new Owner(1, "A", "A", 11);

        var garage = new GarageClass();

        var cars = Arrays.asList(new Car(1, "AA", "a", 3, 10, 1),
                new Car(2, "AA", "b", 4, 20, 1),
                new Car(2, "BB", "c", 5, 30, 1));

        cars.forEach((Car car) -> garage.addCar(car, owner));

        Assertions.assertTrue(garage.allCarsOfBrand("AA").stream().anyMatch(car -> car.getBrand().equals("AA")));
    }


    @Test
    public void meanCarNumberForEachOwnerTest() {
        var owners = Arrays.asList(new Owner(1, "A", "A", 11),
                new Owner(2, "B", "B", 21),
                new Owner(3, "C", "C", 31),
                new Owner(4, "D", "D", 41),
                new Owner(5, "E", "E", 51));

        var garage = new GarageClass();

        for (int k = 0; k < 3; ++k) {
            for (int n = 1; n <= 5; ++n) {
                var car = new Car(n + k * 5, "A", "a", 1, 1, n);
                garage.addCar(car, owners.get(n - 1));
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
                new Owner(5, "E", "E", 51));

        var garage = new GarageClass();

        for (int k = 0; k < 3; ++k) {
            for (int n = 1; n <= 5; ++n) {
                var car = new Car(n + k * 5, "A", "a", 1, 1, n);
                garage.addCar(car, owners.get(n - 1));
            }
        }

        Assertions.assertEquals(garage.meanOwnersAgeOfCarBrand("A"), 31.0);
    }
}
