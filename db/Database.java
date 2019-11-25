package db;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * @author Tyler Wallschleger and actually Ike wan't involved with this one thank you.
 */
public class Database {
    
    public static void saveUser(String _username, String _firstName, String _password) throws IOException {
        FileWriter write = new FileWriter("/users/" + _username);
        write.write("Username: " + _username + "\nFirstName: " + _firstName + "\nPassword: " + _password);
    }
    
    public Database(int _type, String _data1, String _data2, String _data3) throws IOException{
        switch(_type){
            case DBMessage.USER: saveUser(_data1, _data2, _data3);
        }
    }
}
