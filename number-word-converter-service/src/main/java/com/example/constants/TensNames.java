package com.example.constants;

public enum TensNames {
    SPACE(""),
    TEN(" ten"),
    TWENTY(" twenty"),
    THIRTY(" thirty"),
    FORTY(" forty"),
    FIFTY(" fifty"),
    SIXTY(" sixty"),
    SEVENTY(" seventy"),
    EIGHTY(" eighty"),
    NINETY(" ninety");

    private String value;

    private TensNames(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
