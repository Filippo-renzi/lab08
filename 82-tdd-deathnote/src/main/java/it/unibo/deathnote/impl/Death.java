package it.unibo.deathnote.impl;

public class Death {
    private static final String DEFAULT_CAUSE = "heart attack";
    private static final byte VALID_CAUSE_TIMEOUT = 40;
    private static final short VALID_DETAILS_TIMEOUT = 6000 + VALID_CAUSE_TIMEOUT;
    private final String cause;
    private final String details;
    private final long timeOfDeath;
}
