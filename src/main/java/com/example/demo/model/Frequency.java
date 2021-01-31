package com.example.demo.model;

import java.util.Arrays;

public enum Frequency {
    WEEK(1),
    TWO_WEEK(2),
    FOUR_WEEK(4),
    MONTH(4),
    QUARTER(13),
    YEAR(52);

    private int frequencyNumber;

    Frequency(final int FrequencyNumber) {
        this.frequencyNumber = FrequencyNumber;
    }

    public int getFrequencyNumber() {
        return frequencyNumber;
    }
}
