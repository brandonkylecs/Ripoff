package games;

import events.RipoffMessage;
import java.io.IOException;
import model.Player;

/**
 *
 * @author Tyler Wallschleger, Last Updated 12/6/2019
 */
public class DBTranslator {
    
    /*
    * This method collects the information necessary for creating a user and passes it to the respective method
    */
    public static RipoffMessage createUser(String _username, String _firstName, String _password) throws IOException{
        String[] userInfo = {_username, _firstName, _password};
        Player player = new Player();
        return player.registerNewUser(userInfo);
    }
}
