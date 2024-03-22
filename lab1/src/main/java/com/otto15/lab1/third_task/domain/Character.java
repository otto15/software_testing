package com.otto15.lab1.third_task.domain;

public class Character {
    private final String name;
    private final Strength strength;
    private Location location;


    public Character(String name, Strength strength, Location location) {
        this.name = name;
        this.strength = strength;
        this.location = location;
    }

    public boolean tryChangeLocationGently(Location location) {
        validateLocation(location);

        if (changeLocation(location)) {
            return location.close(strength);
        }

        return false;
    }

    public boolean tryChangeLocationIndifferently(Location location) {
        validateLocation(location);
        return changeLocation(location);
    }

    private void validateLocation(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Invalid location null");
        }
    }

    private boolean changeLocation(Location location) {
        if (location.isOpen()) {
            this.location = location;
            return true;
        }

        if (location.open(strength)) {
            this.location = location;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", location=" + location +
                '}';
    }
}
