package db;

/**
 * @author Tyler
 */
import java.util.EventObject;

public class DBEvent extends EventObject{
    
    private final DBMessage message;

    public DBEvent(Object source, DBMessage _message) {
        super(source);
        this.message = _message;
    }

    public DBMessage getMessage() {
        return this.message;
    }
    
}
