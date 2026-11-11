package it.unibo.deathnote.impl;

import java.util.Map;

import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImpl implements DeathNote{
    
    // private Map<String,Death> deathNote;

    @Override
    public String getRule(int ruleNumber) {
        if(ruleNumber < 1 || ruleNumber > RULES.size() + 1){
            throw new IllegalArgumentException("Rule number can't be 0 or lower and can't be higher of the number of rule'");
        }
        return RULES.get(ruleNumber - 1);
    }


    @Override
    public void writeName(String name) {
        throw new  NullPointerException("The name is null");
    }

    @Override
    public boolean writeDeathCause(String cause) {
        throw new IllegalStateException("No name written or cause is null");
    }

    @Override
    public boolean writeDetails(String details) {
        throw new IllegalStateException("No name written or details are null");
    }

    @Override
    public String getDeathCause(String name) {
        throw new IllegalArgumentException("the name isn't in the death note");
    }

    @Override
    public String getDeathDetails(String name) {
        throw new IllegalArgumentException("the name isn't in the death note");
    }

    @Override
    public boolean isNameWritten(String name) {
        throw new IllegalStateException("The name is null");
    }

}