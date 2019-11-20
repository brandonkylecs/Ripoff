package events;

/**
 * A custom event class for handling events for the Ripoff game.
 * @author tnwallsc
 */
import java.util.EventObject;


public class RipoffEvent extends EventObject {

    private final RipoffMessage message;

    public RipoffEvent(Object source, RipoffMessage _message) {
        super(source);
        this.message = _message;
    }

    public RipoffMessage getMessage() {
        return this.message;
    }

}
