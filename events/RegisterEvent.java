package events;

/**
 * A custom event class for handling events for the Simple Register system.
 * @author riquigley
 */
import java.util.EventObject;


public class RegisterEvent extends EventObject {

    private final RegisterMessage message;

    public RegisterEvent(Object source, RegisterMessage _message) {
        super(source);
        this.message = _message;
    }

    public RegisterMessage getMessage() {
        return this.message;
    }

}
