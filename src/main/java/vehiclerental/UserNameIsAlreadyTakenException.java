package vehiclerental;

public class UserNameIsAlreadyTakenException extends RuntimeException {
    private String name;

    public UserNameIsAlreadyTakenException() {
    }

    public UserNameIsAlreadyTakenException(String message) {
        super(message);
    }

    public UserNameIsAlreadyTakenException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getName() {
        return name;
    }

}
