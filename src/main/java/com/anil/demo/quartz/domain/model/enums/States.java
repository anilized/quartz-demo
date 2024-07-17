package com.anil.demo.quartz.domain.model.enums;

import lombok.Getter;

@Getter
public enum States {
    CREATED(1, "CREATED"),
    IN_PROGRESS(2, "IN_PROGRESS"),
    HAS_WON(3, "HAS_WON"),
    LOST(4, "LOST");

    private final int code;
    private final String description;

    States(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static States fromCode(int code) {
        for (States state : States.values()) {
            if (state.getCode() == code) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }

    @Override
    public String toString() {
        return this.description;
    }
}

