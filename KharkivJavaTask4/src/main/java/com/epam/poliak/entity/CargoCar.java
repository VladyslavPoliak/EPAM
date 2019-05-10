package com.epam.poliak.entity;

public class CargoCar extends Car {
    private int maxTransportWeight;
    private int numberOfTrailers;

    public CargoCar(int id, int price, String producer, int enginePower, int yearOfRelease,
                    int maxTransportWeight, int numberOfTrailers) {
        super(id, price, producer, enginePower, yearOfRelease);
        this.maxTransportWeight = maxTransportWeight;
        this.numberOfTrailers = numberOfTrailers;
    }

    public CargoCar() {
    }

    public int getMaxTransportWeight() {
        return maxTransportWeight;
    }

    public void setMaxTransportWeight(int maxTransportWeight) {
        this.maxTransportWeight = maxTransportWeight;
    }

    public int getNumberOfTrailers() {
        return numberOfTrailers;
    }

    public void setNumberOfTrailers(int numberOfTrailers) {
        this.numberOfTrailers = numberOfTrailers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoCar cargoCar = (CargoCar) o;
        return maxTransportWeight == cargoCar.maxTransportWeight &&
                numberOfTrailers == cargoCar.numberOfTrailers;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + maxTransportWeight;
        result = 31 * result + numberOfTrailers;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " maxTransportWeight=" + maxTransportWeight +
                ", numberOfTrailers=" + numberOfTrailers;
    }
}
