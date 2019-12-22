package com.example.constants;

public enum SpecialNames {
    SPACE(""),
    THOUSAND(" thousand"),
    MILLION(" million"),
    BILLION(" billion"),
    TRILLION(" trillion"),
    QUADRILLION(" quadrillion"),
    QUINTILLION(" quintillion");

    private String value;

    private SpecialNames(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
