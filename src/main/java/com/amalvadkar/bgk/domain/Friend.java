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

    public Month birthMonth(){
        return birthDate.getMonth();
    }

    public int birthDay(){
        return birthDate.getDayOfMonth();
    }

}
