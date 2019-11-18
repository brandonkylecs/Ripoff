package model;

/**
 * Defines a user's data like their name, win/loss, password, id.
 * 
 * @author Dakota Simpkins
 */
public class UserData {

    private String userName, userID, userPassword;
    private int userWinRecord, userLossRecord;
    
    /**
     * Construct user
     * @param _userID
     * @param _userName
     * @param _userPassword 
     */
    public UserData(String _userID, String _userName, String _userPassword) {
        this.userID = _userID;
        this.userName = _userName;
        this.userPassword = _userPassword;
        this.userWinRecord = 0;
        this.userLossRecord = 0;
    }
    
    /**
     * This is the toString() method for the Card class. 
     * It will return a String containing information about the user's name, ID, 
     * and win/loss record.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "User's Name: " + this.userName + "\nUser's ID: " + this.userID
                + "\nUser's win/loss record: " + this.userWinRecord + " / " 
                + this.userLossRecord + "\nUser's Games Played: " 
                + this.getGamesPlayed();
    }
    
    /**
     * Increments user's wins
     * @return 
     */
    private int incrementWin(int _wins) {
        return _wins++;
    }
    
    /**
     * Increments user's losses
     * @return 
     */
    private int incrementLoss(int _losses) {
        return _losses++;
    }
    
// ================= GETTERS ==========================
    public String getID() {
        return this.userID;
    }
    
    public String getName() {
        return this.userName;
    }
    
    public String getPassword() {
        return this.userPassword;
    }
    
    public int getWins() {
        return this.userWinRecord;
    }
    
    public int getLosses() {
        return this.userLossRecord;
    }
    
    public int getGamesPlayed() {
        return this.userWinRecord + this.userLossRecord;
    }
    
// ================= SETTERS ==========================
    public String setID() {
        return this.userID;
    }
    
    public String setName() {
        return this.userName;
    }
    
    public String setPassword() {
        return this.userPassword;
    }
    
    public int setWins() {
        return this.userWinRecord;
    }
    
    public int setLosses() {
        return this.userLossRecord;
    }
}