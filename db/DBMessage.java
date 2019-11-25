package db;

/**
 * @author Tyler Wallschleger
 */
public class DBMessage {
    
    public static final int USER = 1;
    
    private final int _thismessage;

    public DBMessage(int message) {
        this._thismessage = message;
    }

    public int getCode() {
        return this._thismessage;
    }
}
