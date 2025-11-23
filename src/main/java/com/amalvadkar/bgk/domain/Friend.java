package com.amalvadkar.bgk.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.Month;


@RequiredArgsConstructor
@Getter
public class Friend {
    private final String firstname;
    private final String lastname;
    private final LocalDate birthDate;
    private final String email;

    public boolean has29FebBirthDate() {
        return hasFebBirthMonth() && has29BirthDay();
    }

    public boolean has29BirthDay() {
        return birthDay() == 29;
    }

    public boolean hasFebBirthMonth() {
        return birthMonth() == Month.FEBRUARY;
    }

    public Month birthMonth(){
        return birthDate.getMonth();
    }

    public int birthDay(){
        return birthDate.getDayOfMonth();
    }

}
