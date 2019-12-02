/*
 * The GUI interface for Ripoff Game.
 */
package gui;

import events.RipoffEvent;
import events.RipoffMessage;
import model.RipoffBase;
import model.Card;
import model.Deck;
import model.Contender;
import games.SimpleGameController;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author tnwallsc and heavily insipired by Ike Quigley
 */
public final class RipoffGUI extends RipoffBase {

    // Track the primary stage so we can add scenes to it.
    private final Stage primaryStage;

    public RipoffGUI(Stage _primaryStage){
        this.primaryStage = _primaryStage;
        // Build the main panel.
        this.loadMainPanel();
    }

   /*
    * Loads the main menu panel.
    */
    public void loadMainPanel(){
        System.out.println("Loading Main Panel");
        Scene rootScene = this.buildMainPanel();
        this.primaryStage.setTitle("Ripoff: The Card Game");
        this.primaryStage.setScene(rootScene);
        this.primaryStage.show();
    }

   /*
    * Loads the transaction panel.
    */
    public void loadGamePanel(){
        System.out.println("Loading Game Panel");
        Scene gameScene = this.buildGamePanel();
        this.primaryStage.setTitle("Game Panel");
        this.primaryStage.setScene(gameScene);
        this.primaryStage.show();
    }

   /*
    * Loads the player panel.
    */
    public void loadPlayerPanel(){
        System.out.println("Loading Player Panel");
        Scene playerScene = this.buildPlayerPanel();
        this.primaryStage.setTitle("Player Panel");
        this.primaryStage.setScene(playerScene);
        this.primaryStage.show();
    }

    /*
    * Loads the registration panel.
    */
    public void loadRegisterPanel(){
        System.out.println("Loading Registration Panel");
        Scene registerScene = this.buildRegisterPanel();
        this.primaryStage.setTitle("Registration");
        this.primaryStage.setScene(registerScene);
        this.primaryStage.show();
    }

    /*
    * Loads the market panel.
    */
    public void loadMarketPanel(){
        System.out.println("Loading Market Panel");
        Scene marketScene = this.buildMarketPanel();
        this.primaryStage.setTitle("Ripoff Market");
        this.primaryStage.setScene(marketScene);
        this.primaryStage.show();
    }

    /*
    * Loads the play panel.
    */
    public void loadPlayPanel(){
        System.out.println("Loading Play Panel");
        Scene playScene = this.buildPlayPanel();
        this.primaryStage.setTitle("Ripoff Play Game");
        this.primaryStage.setScene(playScene);
        this.primaryStage.show();
    }

   /*
    * Helper function for building the main panel. Creates the buttons and returns
    * a scene to be added to the stage.
    */
    private Scene buildMainPanel() {
        Button btnGame = this.addButton("Game", new RipoffMessage(RipoffMessage.GAME_PANEL));
        Button btnPlayer = this.addButton("Player", new RipoffMessage(RipoffMessage.PLAYER_PANEL));
        Button btnMarket = this.addButton("Marketplace", new RipoffMessage(RipoffMessage.MARKET_PANEL));
        VBox vbox = this.addVBox("Ripoff: The Card Game");
        Text text = new Text("\"Wow\" - Owen Wilson");
        text.setFill(Color.MAGENTA);
        vbox.getChildren().add(btnGame);
        vbox.getChildren().add(btnPlayer);
        vbox.getChildren().add(btnMarket);
        vbox.getChildren().add(text);
        // Create the scene and return.
        Scene scene = new Scene(vbox, 400, 200);
        return scene;
    }

   /*
    * Helper function for building the game panel. Creates the buttons and returns
    * a scene to be added to the stage.
    */
    private Scene buildGamePanel(){
        Button btn1 = this.addButton("How to play", new RipoffMessage(RipoffMessage.HOW_TO_PLAY));
        Button btn2 = this.addButton("Play against Hoomans", new RipoffMessage(RipoffMessage.PLAY_PANEL));
        Button btn3 = this.addButton("Play against AI", new RipoffMessage(RipoffMessage.PLAY_PANEL));
        Button btnExit = this.addButton("Main Menu", new RipoffMessage(RipoffMessage.EXIT_PANEL));
        VBox vbox = this.addVBox("Play Ripoff");
        vbox.getChildren().add(btn1);
        vbox.getChildren().add(btn2);
        vbox.getChildren().add(btn3);
        vbox.getChildren().add(btnExit);
        // Create the scene and return.
        Scene scene = new Scene(vbox, 400, 200);
        return scene;
    }

   /*
    * Helper funciton for building the player panel. Creates the buttons and returns
    * a scene to be added to the stage.
    */
    private Scene buildPlayerPanel(){
        Button btn1 = this.addButton("See my Deck", new RipoffMessage(RipoffMessage.SEE_DECK));
        Button btn2 = this.addButton("Send Memes to Player", new RipoffMessage(RipoffMessage.SEND_MEMES));
        Button createProfile = this.addButton("Create Profile/Sign In", new RipoffMessage(RipoffMessage.REGISTER_PANEL));
        Button btnExit = this.addButton("Exit Menu", new RipoffMessage(RipoffMessage.EXIT_PANEL));
        VBox vbox = this.addVBox("Would you like to play a game?");
        vbox.getChildren().add(btn1);
        vbox.getChildren().add(btn2);
        vbox.getChildren().add(createProfile);
        vbox.getChildren().add(btnExit);
        // Create the scene and return.
        Scene scene = new Scene(vbox, 400, 200);
        return scene;
    }

    /*
    * Helper funciton for building the register panel. Creates the buttons and returns
    * a scene to be added to the stage.
    */
    private Scene buildRegisterPanel(){
        Label lblUsername = new Label("Enter your username.");
        TextField tfUsername = new TextField();
        Label lblFirstname = new Label("Enter your first name.  Not needed if you've already got an account.");
        TextField tfFirstname = new TextField();
        Label lblPassword = new Label("Enter your password.  No guarentee we save it in any smart way whatsoever.");
        TextField tfPassword = new TextField();
        Label lblSSN = new Label("Enter your social security number for a chance to win $5!");
        TextField tfSSN = new TextField();
        Button btnExit = this.addButton("Main Menu", new RipoffMessage(RipoffMessage.EXIT_PANEL));
        Button btnRegister = this.addButton("Register", new RipoffMessage(RipoffMessage.PLAYER_PANEL));

        // Trying to do this, please help me Quiggles
        //Button btnRegister = this.addButton("Register", new SimpleGameController.registerNewUser(tfUsername.getText(), tfFirstname.getText(), tfPassword.getText()));

        Button btnSignIn = this.addButton("Sign in", new RipoffMessage(RipoffMessage.PLAYER_PANEL));
        VBox vbox = this.addVBox("Register now for free! Trial ends after 5 minutes!");
        vbox.getChildren().add(lblUsername);
        vbox.getChildren().add(tfUsername);
        vbox.getChildren().add(lblFirstname);
        vbox.getChildren().add(tfFirstname);
        vbox.getChildren().add(lblPassword);
        vbox.getChildren().add(tfPassword);
        vbox.getChildren().add(lblSSN);
        vbox.getChildren().add(tfSSN);
        vbox.getChildren().add(btnRegister);
        vbox.getChildren().add(btnSignIn);
        vbox.getChildren().add(btnExit);
        // Create the scene and return.
        Scene scene = new Scene(vbox, 500, 400);
        return scene;
    }

   /*
    * Helper function that builds the marketplace panel.
    */
    private Scene buildMarketPanel(){
        Label lblInfo = new Label("Thanks for visiting the Ripoff market!\n"
                + "We only charge 50% extra convinience fee!  Don't know what that is?\n"
                + "Ask your parents, since you're probably 14!");
        Button btnExit = this.addButton("Main Menu", new RipoffMessage(RipoffMessage.EXIT_PANEL));
        VBox vbox = this.addVBox("\"Totally not a Ripoff\" Market!");
        vbox.getChildren().add(lblInfo);
        vbox.getChildren().add(btnExit);
        Scene scene = new Scene(vbox, 500, 350);
        return scene;
    }

    private Scene buildPlayPanel(){
        Contender player = new Contender();
        Contender ai = new Contender();
        Deck aiDeck = new Deck();
        aiDeck.fillDeck();
        aiDeck.shuffleCards();
        ArrayList<Card> aiCards = new ArrayList();
        //For right now, draw three random cards.
        aiCards = aiDeck.drawCards(3);
        Card aiCard1 = aiCards.get(0);
        Card aiCard2 = aiCards.get(1);
        Card aiCard3 = aiCards.get(2);

        Deck playerDeck = new Deck();
        playerDeck.fillDeck();
        playerDeck.shuffleCards();
        ArrayList<Card> cards = new ArrayList();
        //For right now, draw three random cards.
        cards = playerDeck.drawCards(3);

        Card card1 = cards.get(0);
        Card card2 = cards.get(1);
        Card card3 = cards.get(2);

        Label lblCard1 = new Label(Integer.toString(card1.getPower()));
        Label lblCard2 = new Label(Integer.toString(card2.getPower()));
        Label lblCard3 = new Label(Integer.toString(card3.getPower()));

        Button btnCard1 = new Button("Play Card 1");
        Button btnCard2 = new Button("Play Card 2");
        Button btnCard3 = new Button("Play Card 3");

        btnCard1.setOnAction((ActionEvent e) -> {
            int win = card1.comparePower(aiCard1);
        });
        Button btnExit = this.addButton("Quit like a loser", new RipoffMessage(RipoffMessage.EXIT_PANEL));
        Button btnPlayAgain = this.addButton("Restart Game", new RipoffMessage(RipoffMessage.PLAY_PANEL));
        GridPane grid = new GridPane();

        grid.add(lblCard1, 0, 0);
        grid.add(lblCard2, 1, 0);
        grid.add(lblCard3, 2, 0);
        grid.add(btnCard1, 0, 2);
        grid.add(btnCard2, 1, 2);
        grid.add(btnCard3, 2, 2);

        grid.add(btnExit, 0, 4);
        grid.add(btnPlayAgain, 1, 4);
        Scene scene = new Scene(grid, 600, 400);
        return scene;
    }

   /*
    * Builds a button given a title and a message to throw for its event.
    * @param String _title the label text for the button
    * @param RipoffMessage _throwMessage the message to send with the event.
    */
    private Button addButton(String _title, final RipoffMessage _throwMessage) {
        Button btn = new Button();
        btn.setText(_title);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Fire a custom event.
                RipoffEvent ripEvent = new RipoffEvent(this, _throwMessage);
                fireEvent(ripEvent);
            }
        });
        return btn;
    }

    /*
    * Creates a vertical box with a header.
    * @param String header the header to add to the top of the VBox.
    */
    private VBox addVBox(String header) {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        // Menu Title
        Text title = new Text(header);
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);
        return vbox;
    }
}
