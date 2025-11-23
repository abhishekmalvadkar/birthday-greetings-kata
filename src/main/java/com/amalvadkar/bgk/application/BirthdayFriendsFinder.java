package com.amalvadkar.bgk.application;

import com.amalvadkar.bgk.domain.Friend;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class BirthdayFriendsFinder {
    public List<Friend> find(List<Friend> friends, LocalDate today) {
        return friends.stream()
                .filter(ifFriendHasBirthday(today))
                .toList();
    }

    private static Predicate<Friend> ifFriendHasBirthday(LocalDate today) {
        return ifBirthDateHasCurrentMonth(today).and(ifBirthDateHasCurrentDay(today));
    }

    private static Predicate<Friend> ifBirthDateHasCurrentDay(LocalDate today) {
        return friend -> friend.birthDay() == today.getDayOfMonth();
    }

    private static Predicate<Friend> ifBirthDateHasCurrentMonth(LocalDate today) {
        return friend -> friend.birthMonth() == today.getMonth();
    }
}
