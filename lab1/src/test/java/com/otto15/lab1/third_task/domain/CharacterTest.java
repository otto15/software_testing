package com.otto15.lab1.third_task.domain;

import com.otto15.lab1.third_task.domain.Door.OpeningDifficulty;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharacterTest {
    private static final Door EASY_DOOR = new Door("Easy Door", OpeningDifficulty.EASY);
    private static final Door HARD_DOOR = new Door("Hard Door", OpeningDifficulty.HARD);

    @Test
    @DisplayName("Character changes location gently when door is easily opened")
    void testChangeLocationGentlyWithEasyDoor() {
        Strength strength = new Strength(30);
        Character character = new Character(
                "Character",
                strength,
                new Location("Initial Location", EASY_DOOR, true)
        );
        Location location = new Location("New Location", EASY_DOOR, false);

        assertTrue(character.tryChangeLocationGently(location));
    }

    @Test
    @DisplayName("Character fails to change location gently when door is too hard")
    void testChangeLocationGentlyWithHardDoor() {
        Strength strength = new Strength(30);
        Character character = new Character(
                "Character",
                strength,
                new Location("Initial Location", HARD_DOOR, true)
        );
        Location location = new Location("New Location", HARD_DOOR, false);

        assertFalse(character.tryChangeLocationGently(location));
    }

    @Test
    @DisplayName("Character changes location indifferently when door is easily opened")
    void testChangeLocationIndifferentlyWithEasyDoor() {
        Strength strength = new Strength(10);
        Character character = new Character(
                "Character",
                strength,
                new Location("Initial Location", EASY_DOOR, true)
        );
        Location location = new Location("New Location", EASY_DOOR, true);

        assertTrue(character.tryChangeLocationIndifferently(location));
    }

    @Test
    @DisplayName("Character fails to change location indifferently when door cannot be opened")
    void testChangeLocationIndifferentlyWithDoorCannotBeOpened() {
        Strength strength = new Strength(10);
        Character character = new Character(
                "Character",
                strength,
                new Location("Initial Location", EASY_DOOR, true)
        );
        Location location = new Location("New Location", EASY_DOOR, false);

        assertFalse(character.tryChangeLocationIndifferently(location));
    }

    @Test
    @DisplayName("Character fails to change location gently due to null given as location")
    void testChangeLocationGentlyWithNullLocation() {
        Strength strength = new Strength(10);
        Character character = new Character(
                "Character",
                strength,
                new Location("Initial Location", EASY_DOOR, true)
        );

        assertThrows(IllegalArgumentException.class, () -> character.tryChangeLocationGently(null));
    }

    @Test
    @DisplayName("Character fails to change location indifferently due to null given as location")
    void testChangeLocationIndifferentlyWithNullLocation() {
        Strength strength = new Strength(10);
        Character character = new Character(
                "Character",
                strength,
                new Location("Initial Location", EASY_DOOR, true)
        );

        assertThrows(IllegalArgumentException.class, () -> character.tryChangeLocationIndifferently(null));
    }
}
