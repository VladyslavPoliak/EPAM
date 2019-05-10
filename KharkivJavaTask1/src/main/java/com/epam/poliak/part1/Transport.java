package com.epam.poliak.part1;

import java.util.Objects;

public class Transport {
    private int price;
    private String producer;

    public Transport(int price, String producer) {
        this.price = price;
        this.producer = producer;
    }


    public Transport() {
    }

    public int getPrice() {
        return price ;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return price == transport.price &&
                Objects.equals(producer, transport.producer);
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        return result;
    }
}
