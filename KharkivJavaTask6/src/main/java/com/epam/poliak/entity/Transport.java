package com.epam.poliak.entity;

import java.util.Objects;

public class Transport {

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

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
