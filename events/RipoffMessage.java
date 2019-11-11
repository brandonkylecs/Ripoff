/** 
 * Ripoff Messages
 */
package events;

/**
 *
 * @author tnwallsc
 */
public class RipoffMessage {
    
    /*
    * UI Messages.
    */
    public static final int GAME_PANEL = 1;
    public static final int PLAYER_PANEL = 2;
    public static final int EXIT_PANEL = 3;
    public static final int REGISTER_PANEL = 4;
    
    /*
    * Player Messages.
    */
    public static final int SEE_DECK = 1;
    public static final int SEND_MEMES = 2;
    public static final int CREATE_PROFILE = 3;
    
    /*
    * Game Messages.
    */
    public static final int HOW_TO_PLAY = 1;
    public static final int PLAY_AGAINST_HOOMANS = 2;
    public static final int PLAY_AGAINST_AI = 3;
    public static final int PLAYER_WON = 4;
    
    private final int _thismessage;
    
    public RipoffMessage(int message) {
        this._thismessage = message;
    }

    public int getCode() {
        return this._thismessage;
    }
    
}
