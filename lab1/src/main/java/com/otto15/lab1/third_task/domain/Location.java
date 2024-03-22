package com.otto15.lab1.third_task.domain;

public class Location {
    private final String name;
    private final Door door;

    private boolean open;

    public Location(String name, Door door, boolean open) {
        this.name = name;
        this.door = door;
        this.open = open;
    }

    public boolean isOpen() {
        return open;
    }

    private boolean isDoorMovable(Strength strength) {
        return door.canBeMoved(strength);
    }

    public boolean open(Strength strength) {
        if (isDoorMovable(strength)) {
            open = true;
            return true;
        }

        return false;
    }

    public boolean close(Strength strength) {
        if (isDoorMovable(strength)) {
            open = false;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", door=" + door +
                ", open=" + open +
                '}';
    }
}
