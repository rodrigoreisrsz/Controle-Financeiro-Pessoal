package manager;

import java.util.InputMismatchException;

public class OpcaoInvalidaException extends InputMismatchException {

    public OpcaoInvalidaException(String message) {
        super(message);
    }
}
