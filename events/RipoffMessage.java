/** 
 * Ripoff Messages
 */
package events;

/**
 *
 * @author tnwallsc and I guess Ike helped here too.
 */
public class RipoffMessage {
    
    public static final int GAME_PANEL = 1;
    public static final int PLAYER_PANEL = 2;
    public static final int SEE_DECK = 2;
    public static final int SEND_MEMES = 3;
    public static final int HOW_TO_PLAY = 4;
    public static final int PLAY_AGAINST_HOOMANS = 5;
    public static final int PLAY_AGAINST_AI = 6;
    public static final int EXIT_PANEL = 7;
    public static final int PLAYER_WON = 8;
    
    private final int _thismessage;
    
    public RipoffMessage(int message) {
        this._thismessage = message;
    }

    public int getCode() {
        return this._thismessage;
    }
    
}
