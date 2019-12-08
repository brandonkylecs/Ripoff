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
    public static final int PLAY_PANEL = 6;

    /*
    * Player Messages.
    */
    public static final int SEE_DECK = 10;
    public static final int SEND_MEMES = 20;
    public static final int CREATE_PROFILE = 30;
    public static final int CHECK_LOGIN = 31;
    
    /*
    * Registration Messages;
    */
    public static final int MISSING_USERNAME = 32;
    public static final int MISSING_FIRSTNAME = 33;
    public static final int MISSING_PASSWORD = 34;

    /*
    * Game Messages.
    */
    public static final int HOW_TO_PLAY = 100;
    public static final int PLAY_AGAINST_HOOMANS = 200;
    public static final int PLAY_AGAINST_AI = 300;
    public static final int PLAYER_WON_ROUND = 400;
    public static final int AI_WON_ROUND = 401;
    public static final int DRAW_ROUND = 402;
    public static final int PLAYER_WON_GAME = 403;
    public static final int AI_WON_GAME = 404;
    public static final int NO_WINNER = 405;
    public static final int ERROR = 999;

    private final int _thismessage;

    public RipoffMessage(int message) {
        this._thismessage = message;
    }

    public int getCode() {
        return this._thismessage;
    }

}
