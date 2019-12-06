package games;

import events.RipoffMessage;

/**
 *
 * @author Tyler Wallschleger, Last Updated 12/6/2019
 */
public class DBTranslator {
    
    /*
    * This method collects the information necessary for creating a user and passes it to the respective method
    */
    public RipoffMessage createUser(String _username, String _firstName, String _password){
        String[] userInfo = {_username, _firstName, _password};
        // Send information to the model.
        return new RipoffMessage(RipoffMessage.EXIT_PANEL);
    }
}
