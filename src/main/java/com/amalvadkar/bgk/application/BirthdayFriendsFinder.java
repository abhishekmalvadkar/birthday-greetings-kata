package com.amalvadkar.bgk.application;

import com.amalvadkar.bgk.domain.Friend;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.function.Predicate;

public class BirthdayFriendsFinder {
    public List<Friend> find(List<Friend> friends, LocalDate today) {
        return friends.stream()
                .filter(ifFriendHasBirthday(today).or(ifTodayIs28FebAndFriendHasBirthdayOn29Feb(today)))
                .toList();
    }

    private static Predicate<Friend> ifTodayIs28FebAndFriendHasBirthdayOn29Feb(LocalDate today) {
        return ifTodayIs28Feb(today).and(ifFriendHasBirthdayOn29Feb());
    }

    private static Predicate<Friend> ifFriendHasBirthdayOn29Feb() {
        return friend -> friend.birthMonth() == Month.FEBRUARY && friend.birthDay() == 29;
    }

    private static Predicate<Friend> ifTodayIs28Feb(LocalDate today) {
        return _ -> today.getMonth() == Month.FEBRUARY && today.getDayOfMonth() == 28;
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
