package com.amalvadkar.bgk.application;

import com.amalvadkar.bgk.domain.EmailData;
import com.amalvadkar.bgk.domain.FullName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailDataPreparerTest {

    public static final String BIRTHDAY_FRIEND_FIRST_NAME = "John";
    public static final String NON_BIRTH_DAY_FRIEND_FIRST_NAME = "Mary";
    public static final FullName SINGLE_BIRTHDAY_FRIEND_FULL_NAME = FullName.from("John", "Doe");
    public static final List<FullName> MANY_BIRTHDAY_FRIENDS_FULL_NAMES = List.of(FullName.from("John", "Doe"), FullName.from("Tom", "Poe"));

    private EmailDataPreparer emailDataPreparer;

    @BeforeEach
    void setUp() {
        emailDataPreparer = new EmailDataPreparer();
    }

    @Test
    void should_prepare_email_data_for_birthday_greeting_email() {
        EmailData emailData = emailDataPreparer.prepare(BIRTHDAY_FRIEND_FIRST_NAME);

        assertThat(emailData.subject()).isEqualTo("Happy birthday!");
        assertThat(emailData.body()).isEqualTo("Happy birthday, dear John!");
    }

    @Test
    void should_prepare_email_data_for_birthday_reminder_of_single_friend() {
        EmailData emailData = emailDataPreparer.prepareBirthdayReminder(NON_BIRTH_DAY_FRIEND_FIRST_NAME, SINGLE_BIRTHDAY_FRIEND_FULL_NAME);

        assertThat(emailData.subject()).isEqualTo("Birthday Reminder");
        assertThat(emailData.body()).isEqualTo("""
                Dear Mary,
                
                Today is John Doe's birthday.
                Don't forget to send him a message !
                """);
    }

    @Test
    void should_prepare_email_data_for_birthday_reminder_of_more_then_one_friend() {
        EmailData emailData = emailDataPreparer.prepareBirthdayReminder(NON_BIRTH_DAY_FRIEND_FIRST_NAME, MANY_BIRTHDAY_FRIENDS_FULL_NAMES);

        assertThat(emailData.subject()).isEqualTo("Birthday Reminder");
        assertThat(emailData.body()).isEqualTo("""
                Dear Mary,
                
                Today is John Doe, Tom Poe's birthday.
                Don't forget to send them a message !
                """);
    }
}
