package com.epam.entity;

public class Car {

    private int id;
    private String name;
    private String mark;
    private String classCar;
    private int cost;
    private String imageURL;

    private Car(CarBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.mark = builder.mark;
        this.classCar = builder.classCar;
        this.cost = builder.cost;
        this.imageURL = builder.imageURL;
    }

    public static CarBuilder builder() {
        return new CarBuilder();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMark() {
        return mark;
    }

    public String getClassCar() {
        return classCar;
    }

    public int getCost() {
        return cost;
    }

    public String getImageURL() {
        return imageURL;
    }

    public static class CarBuilder {

        private int id;
        private String name;
        private String mark;
        private String classCar;
        private int cost;
        private String imageURL;

        public CarBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public CarBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CarBuilder setMark(String mark) {
            this.mark = mark;
            return this;
        }

        public CarBuilder setClassCar(String classCar) {
            this.classCar = classCar;
            return this;
        }

        public CarBuilder setCost(int cost) {
            this.cost = cost;
            return this;
        }

        public CarBuilder setImageURL(String imageURL) {
            this.imageURL = imageURL;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}