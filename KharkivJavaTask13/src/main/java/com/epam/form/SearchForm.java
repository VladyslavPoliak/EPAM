package com.epam.form;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SearchForm {

    private String query;
    private List<String> producers;
    private List<String > carClasses;
    private String minPrice;
    private String maxPrice;

    public SearchForm(String query, String[] producers,String[] carClasses, String minPrice, String maxPrice) {
        this.query = query;
        this.producers = convert(producers);
        this.carClasses=convert(carClasses);
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    private List<String> convert(String[] arrayOfParameters) {
        if (arrayOfParameters == null) {
            return Collections.emptyList();
        } else {
            return Arrays.asList(arrayOfParameters);
        }
    }

    public List<String> getProducers() {
        return producers;
    }

    public String getQuery() {
        return query;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public List<String> getCarClasses() {
        return carClasses;
    }

}
