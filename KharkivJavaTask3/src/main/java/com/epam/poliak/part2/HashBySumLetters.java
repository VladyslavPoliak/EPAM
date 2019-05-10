package com.epam.poliak.part2;

public class HashBySumLetters extends AbstractHash {

    private static final int NUMBER_OF_FIRST_SYMBOLS = 4;

    public HashBySumLetters(String word) {
        super(word);
    }

    @Override
    protected int calculateHash() {
        int result = 0;
        for (int i = 0; i < word.length() && i < NUMBER_OF_FIRST_SYMBOLS; i++) {
            result += word.charAt(i);
        }
        return result;
    }
}
