package com.amalvadkar.bgk.domain;

public record EmailData(String subject, String body) {
    public static EmailData from(String subject, String body) {
        return new EmailData(subject, body);
    }
}
