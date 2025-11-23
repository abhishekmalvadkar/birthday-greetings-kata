package com.amalvadkar.bgk.application;

import com.amalvadkar.bgk.domain.EmailData;
import com.amalvadkar.bgk.domain.FullName;

public class EmailDataPreparer {
    public EmailData prepare(String firstname) {
        String subject = "Happy birthday!";
        String body = String.format("Happy birthday, dear %s!", firstname);
        return EmailData.from(subject, body);
    }

    public EmailData prepareBirthdayReminder(String nonBirthDayFriendFirstName, FullName birthFriendFullName) {
        String subject = "Birthday Reminder";
        String body = String.format("""
                Dear %s,
                
                Today is %s's birthday.
                Don't forget to send him a message !
                """, nonBirthDayFriendFirstName, birthFriendFullName.asString());
        return EmailData.from(subject, body);
    }
}
