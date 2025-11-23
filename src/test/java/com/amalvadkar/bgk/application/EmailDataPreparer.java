package com.amalvadkar.bgk.application;

import com.amalvadkar.bgk.domain.EmailData;
import com.amalvadkar.bgk.domain.FullName;

import java.util.List;
import java.util.stream.Collectors;

public class EmailDataPreparer {
    public EmailData prepare(String birthdayFriendFirstName) {
        String subject = "Happy birthday!";
        String body = String.format("Happy birthday, dear %s!", birthdayFriendFirstName);
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

    public EmailData prepareBirthdayReminder(String nonBirthDayFriendFirstName, List<FullName> birthdayFriendsFullNames) {
        String subject = "Birthday Reminder";
        String body = String.format("""
                Dear %s,
                
                Today is %s's birthday.
                Don't forget to send them a message !
                """, nonBirthDayFriendFirstName, joinedWithComma(birthdayFriendsFullNames));
        return EmailData.from(subject, body);
    }

    private static String joinedWithComma(List<FullName> birthdayFriendsFullNames) {
        return birthdayFriendsFullNames.stream()
                .map(FullName::asString)
                .collect(Collectors.joining(", "));
    }
}
