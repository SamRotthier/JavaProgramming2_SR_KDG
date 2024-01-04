package be.kdg.java2.exceptions;

public class MonsterException extends RuntimeException {
    public MonsterException() {
        super();
    }

    public MonsterException(String message) {
        super(message);
    }

    public MonsterException(String message, Throwable cause) {
        super(message, cause);
    }

    public MonsterException(Throwable cause) {
        super(cause);
    }

    public MonsterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
