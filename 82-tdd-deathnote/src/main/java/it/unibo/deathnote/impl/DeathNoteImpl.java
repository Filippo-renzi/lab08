package it.unibo.deathnote.impl;

import java.util.HashMap;
import java.util.Map;

import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImpl implements DeathNote{
    
    private final Map<String,Death> deathNote;
    private String lastname;

    public DeathNoteImpl(){
        this.deathNote = new HashMap<>();
    }

    @Override
    public String getRule(int ruleNumber) {
        if(ruleNumber < 1 || ruleNumber > RULES.size() + 1){
            throw new IllegalArgumentException("Rule number can't be 0 or lower and can't be higher of the number of rule'");
        }
        return RULES.get(ruleNumber - 1);
    }


    @Override
    public void writeName(String name) {
        if(name != null){
            deathNote.put(name, new Death());
            this.lastname = name;
        }
        throw new  NullPointerException("The name is null");
    }

    @Override
    public boolean writeDeathCause(String cause) {
        if(cause == null || this.deathNote.isEmpty()){
            throw new IllegalStateException("No name written or cause is null");
        }
        
        if(this.deathNote.get(this.lastname).IsInTimeForCause()){
            this.deathNote.get(this.lastname).setCause(cause);
            return true;
        }
        return false;
    }

    @Override
    public boolean writeDetails(String details) {
        if(details == null || this.deathNote.isEmpty()){
            throw new IllegalStateException("No name written or details are null");
        }
         if(this.deathNote.get(this.lastname).IsInTimeForDetails()){
            this.deathNote.get(this.lastname).setDetails(details);
            return true;
        }
        return false;

    }

    @Override
    public String getDeathCause(String name) {
        if(!isNameWritten(name)){
            throw new IllegalArgumentException("the name isn't in the death note");
        }

        return this.deathNote.get(name).getCause();
    }

    @Override
    public String getDeathDetails(String name) {
        if(!isNameWritten(name)){
            throw new IllegalArgumentException("the name isn't in the death note");
        }

        return this.deathNote.get(name).getDetails();
    }

    @Override
    public boolean isNameWritten(String name) {
        if(name == null){
            throw new IllegalStateException("The name is null");
        }

        if(this.deathNote.containsKey(name)){
            return true;
        }
        return false;
    }

}