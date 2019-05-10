package com.epam.poliak.part1;

import java.util.Objects;

public class Car extends Transport {
    private int enginePower;
    private int yearOfRelease;

    public Car(int price, String producer, int enginePower, int yearOfRelease) {
        super(price, producer);
        this.enginePower = enginePower;
        this.yearOfRelease = yearOfRelease;
    }

    public Car() {
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Car car = (Car) o;

        if (enginePower != car.enginePower) return false;
        return yearOfRelease == car.yearOfRelease;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + enginePower;
        result = 31 * result + yearOfRelease;
        return result;
    }
}
