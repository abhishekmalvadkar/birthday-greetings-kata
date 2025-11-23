package com.amalvadkar.bgk.domain;

public record FullName(String firstname, String lastname) {
    public static FullName from(String firstname, String lastname) {
        return new FullName(firstname, lastname);
    }

    public String asString() {
        return String.format("%s %s", firstname, lastname);
    }
}
