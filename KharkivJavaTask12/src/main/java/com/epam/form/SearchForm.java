package com.epam.form;

import java.util.Arrays;
import java.util.List;

public class SearchForm {

    private String query;
    private List<String> producers;

    public SearchForm(String query, String[] producers) {
        this.query = query;
        this.producers = Arrays.asList(producers);
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

}
