package com.epam.poliak.entity;

import com.epam.poliak.annotation.Getter;
import com.epam.poliak.annotation.Setter;

import java.io.Serializable;
import java.util.Objects;

public class Transport implements Serializable {

    private int id;
    private int price;
    private String producer;

    public Transport(int id, int price, String producer) {
        this.id = id;
        this.price = price;
        this.producer = producer;
    }

    public Transport() {
    }

    @Getter(name = "GET_PRICE")
    public int getPrice() {
        return price;
    }

    @Setter(name = "SET_PRICE")
    public void setPrice(int price) {
        this.price = price;
    }

    @Getter(name = "GET_PRODUCER")
    public String getProducer() {
        return producer;
    }

    @Setter(name = "SET_PRODUCER")
    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Getter(name = "GET_ID")
    public int getId() {
        return id;
    }

    @Setter(name = "SET_ID")
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transport transport = (Transport) o;

        if (id != transport.id) {
            return false;
        }
        if (price != transport.price) {
            return false;
        }
        return Objects.equals(producer, transport.producer);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + price;
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "id = " + id + ", price = " + price +
                ", producer = " + producer;
    }
}
