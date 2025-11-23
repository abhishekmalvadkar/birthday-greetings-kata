package com.amalvadkar.bgk.application;

import com.amalvadkar.bgk.domain.EmailData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailDataPreparerTest {

    @Test
    void should_prepare_email_data_for_birthday_greeting_email() {
        EmailDataPreparer emailDataPreparer = new EmailDataPreparer();
        EmailData emailData = emailDataPreparer.prepare("John");
        Assertions.assertThat(emailData.subject()).isEqualTo("Happy birthday!");
        Assertions.assertThat(emailData.body()).isEqualTo("Happy birthday, dear John!");
    }
}
