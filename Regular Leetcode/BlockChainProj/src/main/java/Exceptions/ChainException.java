package Exceptions;

public abstract class ChainException {

    private String message;

    public String getMessage() {
        return this.message;
    }

    public ChainException(String msg) {
        this.message = msg;
    }
}
