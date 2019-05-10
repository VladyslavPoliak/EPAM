package com.epam.poliak.part2;

public class HashByStringLength extends AbstractHash {
    public HashByStringLength(String word) {
        super(word);
    }

    @Override
    protected int calculateHash() {
        return word.length();
    }
}
