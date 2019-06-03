package com.epam.poliak.entity;

import com.epam.poliak.annotation.Getter;
import com.epam.poliak.annotation.Setter;

public class Car extends Transport {

    private int enginePower;
    private int yearOfRelease;

    public Car(int id, int price, String producer, int enginePower, int yearOfRelease) {
        super(id, price, producer);
        this.enginePower = enginePower;
        this.yearOfRelease = yearOfRelease;
    }

    public Car() {
    }

    @Getter(name = "GET_ENGINE_POWER")
    public int getEnginePower() {
        return enginePower;
    }

    @Setter(name = "SET_ENGINE_POWER")
    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    @Getter(name = "GET_YEAR_OF_RELEASE")
    public int getYearOfRelease() {
        return yearOfRelease;
    }

    @Setter(name = "SET_YEAR_OF_RELEASE")
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

    @Override
    public String toString() {
        return super.toString() + " ,enginePower=" + enginePower +
                ", yearOfRelease=" + yearOfRelease;
    }
}
