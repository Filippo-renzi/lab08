package it.unibo.deathnote.impl;

public class Death {
    private static final String DEFAULT_CAUSE = "heart attack";
    private static final long VALID_CAUSE_TIMEOUT = 40L;
    private static final long VALID_DETAILS_TIMEOUT = 6000 + VALID_CAUSE_TIMEOUT;
    private String cause;
    private String details;
    private final long timeOfDeath;

    public Death(){
        this(DEFAULT_CAUSE, " ");
    }

    public Death(String cause, String details){
        this.cause = cause;
        this.details = details;
        this.timeOfDeath = System.currentTimeMillis();
    }

    //Set Method
    public void setDetails(String details){
        this.details = details;
    }
    public void setCause(String cause){
        this.cause = cause;
    }

    //Get Method
    public String getCause(){
        return this.cause;
    }

    public String getDetails(){
        return this.details;
    }

    //My Method
    public boolean IsInTimeForCause(){
        long now = System.currentTimeMillis();
        if((now - this.timeOfDeath) < VALID_CAUSE_TIMEOUT){
            return true;
        }
        return false;

    }
    
   public boolean IsInTimeForDetails(){
        long now = System.currentTimeMillis();
        if((now - this.timeOfDeath) < VALID_DETAILS_TIMEOUT){
            return true;
        }
        return false;

    }
    


}
