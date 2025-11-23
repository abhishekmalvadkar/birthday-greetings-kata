package com.amalvadkar.bgk.application;

import com.amalvadkar.bgk.domain.EmailData;
import com.amalvadkar.bgk.domain.FullName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailDataPreparerTest {

    @Test
    void should_prepare_email_data_for_birthday_greeting_email() {
        EmailDataPreparer emailDataPreparer = new EmailDataPreparer();
        EmailData emailData = emailDataPreparer.prepare("John");
        assertThat(emailData.subject()).isEqualTo("Happy birthday!");
        assertThat(emailData.body()).isEqualTo("Happy birthday, dear John!");
    }

    @Test
    void should_prepare_email_data_for_birthday_reminder_of_single_friend() {
        EmailDataPreparer emailDataPreparer = new EmailDataPreparer();
        EmailData emailData = emailDataPreparer.prepareBirthdayReminder("Mary", FullName.from("John", "Doe"));
        assertThat(emailData.subject()).isEqualTo("Birthday Reminder");
        assertThat(emailData.body()).isEqualTo("""
                Dear Mary,
                
                Today is John Doe's birthday.
                Don't forget to send him a message !
                """);
    }

    @Test
    void should_prepare_email_data_for_birthday_reminder_of_more_then_one_friend() {
        EmailDataPreparer emailDataPreparer = new EmailDataPreparer();
        List<FullName> birthdayFriendsFullNames = List.of(FullName.from("John", "Doe"), FullName.from("Tom", "Poe"));
        EmailData emailData = emailDataPreparer.prepareBirthdayReminder("Mary", birthdayFriendsFullNames);
        assertThat(emailData.subject()).isEqualTo("Birthday Reminder");
        assertThat(emailData.body()).isEqualTo("""
                Dear Mary,
                
                Today is John Doe, Tom Poe's birthday.
                Don't forget to send them a message !
                """);
    }
}
