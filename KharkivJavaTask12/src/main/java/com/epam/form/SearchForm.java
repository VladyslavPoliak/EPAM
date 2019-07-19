package com.epam.form;

import java.util.Arrays;
import java.util.List;

public class SearchForm {

    private String query;
    private List<String> producers;
    private String minPrice;
    private String maxPrice;

    public SearchForm(String query, String[] producers, String minPrice, String maxPrice) {
        this.query = query;
        this.producers = convert(producers);
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    private List<String> convert(String[] producers) {
        if (producers == null) {
            return null;
        } else {
            return Arrays.asList(producers);
        }
    }

    public List<String> getProducers() {
        return producers;
    }

    public void setProducers(List<String> producers) {
        this.producers = producers;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }
}
