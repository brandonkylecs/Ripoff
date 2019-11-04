/*
 * Register messages.
 */
package events;

/**
 *
 * @author riquigley
 */
public class RegisterMessage {

    public static final int TRANSACTION_PANEL = 1;
    public static final int INVENTORY_PANEL = 2;
    public static final int ADD_PRODUCT = 3;
    public static final int REMOVE_PRODUCT = 4;
    public static final int COMPLETE_TRANSACTION = 5;
    public static final int ADD_ITEM_TO_INVENTORY = 6;
    public static final int REMOVE_ITEM_FROM_INVENTORY = 7;
    public static final int EXIT_PANEL = 7;

    private final int _thismessage;

    public RegisterMessage(int message) {
        this._thismessage = message;
    }

    public int getCode() {
        return this._thismessage;
    }

}
