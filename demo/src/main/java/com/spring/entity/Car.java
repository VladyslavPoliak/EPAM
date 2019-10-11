package com.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mark;
    private String classCar;
    private int cost;
    private String status;

    private Car(CarBuilder builder) {
        this.name = builder.name;
        this.mark = builder.mark;
        this.classCar = builder.classCar;
        this.cost = builder.cost;
        this.status = builder.status;
    }

    public static CarBuilder build() {
        return new CarBuilder();
    }


    public Long getId() {
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

    public String getStatus() {
        return status;
    }

    private static final class CarBuilder {
        private Long id;
        private String name;
        private String mark;
        private String classCar;
        private int cost;
        private String status;

        public CarBuilder setId(Long id) {
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

        public CarBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }
}