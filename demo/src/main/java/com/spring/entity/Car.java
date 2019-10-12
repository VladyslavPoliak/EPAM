package com.spring.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
    private Long cost;
    private String status;

    public Car() {
    }

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

    public Long getCost() {
        return cost;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return new EqualsBuilder()
                .append(cost, car.cost)
                .append(id, car.id)
                .append(name, car.name)
                .append(mark, car.mark)
                .append(classCar, car.classCar)
                .append(status, car.status)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(mark)
                .append(classCar)
                .append(cost)
                .append(status)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("mark", mark)
                .append("classCar", classCar)
                .append("cost", cost)
                .append("status", status)
                .toString();
    }

    private static final class CarBuilder {
        private String name;
        private String mark;
        private String classCar;
        private Long cost;
        private String status;

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

        public CarBuilder setCost(Long cost) {
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