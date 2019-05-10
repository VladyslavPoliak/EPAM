package com.epam.poliak.part2;

public abstract class AbstractHash {
protected String word;
protected int hash;

    public AbstractHash(String word) {
        this.word = word;
        this.hash = calculateHash();
    }

    protected abstract int calculateHash();

    @Override
    public int hashCode() {
        return hash;
    }
}
