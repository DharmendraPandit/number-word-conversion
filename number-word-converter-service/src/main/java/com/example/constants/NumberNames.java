package com.example.constants;

public enum NumberNames {
    SPACE(""),
    ONE(" one"),
    TWO(" two"),
    THREE(" three"),
    FOUR(" four"),
    FIVE(" five"),
    SIX(" six"),
    SEVEN(" seven"),
    EIGHT(" eight"),
    NINE(" nine"),
    TEN(" ten"),
    ELEVEN(" eleven"),
    TWELVE(" twelve"),
    THIRTEEN(" thirteen"),
    FOURTEEN(" fourteen"),
    FIFTEEN(" fifteen"),
    SIXTEEN(" sixteen"),
    SEVENTEEN(" seventeen"),
    EIGHTEEN(" eighteen"),
    NINETEEN(" nineteen");

    private String value;

    private NumberNames(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
