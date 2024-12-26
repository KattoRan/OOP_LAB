package hust.soict.dsai.aims.exception;

public class PlayerException extends Exception {
    public PlayerException(String message) {
        super(message);
    }
    public PlayerException() {
    }
    @Override
    public String toString() {
        return "PlayerException: " + getMessage();
    }
}