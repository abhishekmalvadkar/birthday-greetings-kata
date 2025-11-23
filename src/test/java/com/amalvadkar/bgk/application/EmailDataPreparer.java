package com.amalvadkar.bgk.application;

import com.amalvadkar.bgk.domain.EmailData;

public class EmailDataPreparer {
    public EmailData prepare(String firstname) {
        String subject = "Happy birthday!";
        String body = String.format("Happy birthday, dear %s!", firstname);
        return EmailData.from(subject, body);
    }
}
