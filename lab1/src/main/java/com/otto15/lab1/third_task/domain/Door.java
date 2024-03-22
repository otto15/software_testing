package com.otto15.lab1.third_task.domain;

public class Door {
    private static final int EASY_STRENGTH_BOUND = 20;
    private static final int MEDIUM_STRENGTH_BOUND = 50;
    private static final int HARD_STRENGTH_BOUND = 90;

    private final String name;
    private final OpeningDifficulty openingDifficulty;

    public Door(String name, OpeningDifficulty openingDifficulty) {
        this.name = name;

        if (openingDifficulty == null) {
            throw new IllegalArgumentException("Opening difficulty must not be null");
        }
        this.openingDifficulty = openingDifficulty;
    }

    public boolean canBeMoved(Strength strength) {
        return switch (openingDifficulty) {
            case EASY -> strength.getValue() > EASY_STRENGTH_BOUND;
            case MEDIUM -> strength.getValue() > MEDIUM_STRENGTH_BOUND;
            case HARD -> strength.getValue() > HARD_STRENGTH_BOUND;
        };
    }

    enum OpeningDifficulty {
        EASY,
        MEDIUM,
        HARD
    }

    @Override
    public String toString() {
        return "Door{" +
                "name='" + name + '\'' +
                ", openingDifficulty=" + openingDifficulty +
                '}';
    }
}
