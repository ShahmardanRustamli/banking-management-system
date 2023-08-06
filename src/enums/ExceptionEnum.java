package enums;

public enum ExceptionEnum {
    NOT_NULL_EXCEPTION("Not null Exception!"),

    EMAIL_ALREADY_GIVEN_EXCEPTION("This email already exist!"),

    FAILED_ATTEMPTS_EXCEPTION("Failed Attempts!"),

    INSUFFICIENT_BALANCE_EXCEPTION("Insufficient balance!");



    private String message;

    ExceptionEnum(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
