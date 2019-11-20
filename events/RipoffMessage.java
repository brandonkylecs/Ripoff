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
    public static final int MARKET_PANEL = 5;

    /*
    * Player Messages.
    */
    public static final int SEE_DECK = 10;
    public static final int SEND_MEMES = 20;
    public static final int CREATE_PROFILE = 30;
    public static final int CHECK_LOGIN = 31;

    /*
    * Game Messages.
    */
    public static final int HOW_TO_PLAY = 100;
    public static final int PLAY_AGAINST_HOOMANS = 200;
    public static final int PLAY_AGAINST_AI = 300;
    public static final int PLAYER_WON = 400;

    private final int _thismessage;

    public RipoffMessage(int message) {
        this._thismessage = message;
    }

    public int getCode() {
        return this._thismessage;
    }

}
