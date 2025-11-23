package com.amalvadkar.bgk.application;

import com.amalvadkar.bgk.domain.Friend;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BirthdayFriendsFinderTest {

    private BirthdayFriendsFinder birthdayFriendsFinder;

    @BeforeEach
    void setUp() {
        birthdayFriendsFinder = new BirthdayFriendsFinder();
    }

    @Test
    void should_return_friends_list_who_has_today_birthday() {
        List<Friend> friends = List.of(
                new Friend("John", "Doe", LocalDate.of(1982, Month.SEPTEMBER, 8), "john.doe@foobar.com"),
                new Friend("Mary", "Ann", LocalDate.of(1975, Month.OCTOBER, 11), "mary.ann@foobar.com"),
                new Friend("Tom", "Poe", LocalDate.of(1975, Month.SEPTEMBER, 8), "tom.poe@foobar.com")
        );

        List<Friend> todayBirthdayFriends = birthdayFriendsFinder.find(friends, LocalDate.of(2025, Month.SEPTEMBER, 8));

        assertThat(todayBirthdayFriends).hasSize(2);
    }

    @Test
    void should_return_friends_list_who_has_today_and_on_29_FEB_birthday() {
        List<Friend> friends = List.of(
                new Friend("John", "Doe", LocalDate.of(1982, Month.FEBRUARY, 28), "john.doe@foobar.com"),
                new Friend("Mary", "Ann", LocalDate.of(1975, Month.OCTOBER, 11), "mary.ann@foobar.com"),
                new Friend("Tom", "Poe", LocalDate.of(2008, Month.FEBRUARY, 29), "tom.poe@foobar.com")
        );

        List<Friend> todayBirthdayFriends = birthdayFriendsFinder.find(friends, LocalDate.of(2025, Month.FEBRUARY, 28));

        assertThat(todayBirthdayFriends).hasSize(2);
    }
}
