package com.epam.poliak.entity;

import com.epam.poliak.annotation.Getter;
import com.epam.poliak.annotation.Setter;

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

    @Getter(name = "GET_MAX_TRANSPORT_WEIGHT")
    public int getMaxTransportWeight() {
        return maxTransportWeight;
    }

    @Setter(name = "SET_MAX_TRANSPORT_WEIGHT")
    public void setMaxTransportWeight(int maxTransportWeight) {
        this.maxTransportWeight = maxTransportWeight;
    }

    @Getter(name = "GET_NUMBER_OF_TRAILERS")
    public int getNumberOfTrailers() {
        return numberOfTrailers;
    }

    @Setter(name = "SET_NUMBER_OF_TRAILERS")
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
