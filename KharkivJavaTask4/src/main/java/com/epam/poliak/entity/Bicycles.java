package com.epam.poliak.entity;

public class Bicycles extends Transport {
    private int wheelSize;
    private int numberAbsorber;

    public Bicycles(int id, int price, String producer, int wheelSize, int numberAbsorber) {
        super(id, price, producer);
        this.wheelSize = wheelSize;
        this.numberAbsorber = numberAbsorber;
    }

    public Bicycles() {
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public int getNumberAbsorber() {
        return numberAbsorber;
    }

    public void setNumberAbsorber(int numberAbsorber) {
        this.numberAbsorber = numberAbsorber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bicycles bicycles = (Bicycles) o;
        return wheelSize == bicycles.wheelSize &&
                numberAbsorber == bicycles.numberAbsorber;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + wheelSize;
        result = 31 * result + numberAbsorber;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " wheelSize=" + wheelSize +
                ", numberAbsorber=" + numberAbsorber ;
    }
}
