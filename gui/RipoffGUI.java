/*
 * The GUI interface for the Simple Ripoff example.
 */
package gui;

import events.RipoffEvent;
import events.RipoffMessage;
import model.RipoffBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author tnwallsc and heavily inspired by Ike Quigley
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
    * Helper function for building the main panel. Creates two buttons and returns
    * a scene to be added to the stage.
    */
    private Scene buildMainPanel() {
        Button btnTransaction = this.addButton("Game", new RipoffMessage(RipoffMessage.GAME_PANEL));
        Button btnInventory = this.addButton("Player", new RipoffMessage(RipoffMessage.PLAYER_PANEL));
        VBox vbox = this.addVBox("Ripoff: The Card Game");
        Text text = new Text("\"Wow\" - Owen Wilson");
        text.setFill(Color.MAGENTA);
        vbox.getChildren().add(btnTransaction);
        vbox.getChildren().add(btnInventory);
        vbox.getChildren().add(text);
        // Create the scene and return.
        Scene scene = new Scene(vbox, 800, 600);
        return scene;
    }

   /*
    * Helper function for building the transaction panel. Creates the buttons and returns
    * a scene to be added to the stage.
    */
    private Scene buildGamePanel(){
        Button btn1 = this.addButton("How to play", new RipoffMessage(RipoffMessage.HOW_TO_PLAY));
        Button btn2 = this.addButton("Play against Hoomans", new RipoffMessage(RipoffMessage.PLAY_AGAINST_HOOMANS));
        Button btn3 = this.addButton("Play against AI", new RipoffMessage(RipoffMessage.PLAY_AGAINST_AI));
        Button btnExit = this.addButton("Exit Menu", new RipoffMessage(RipoffMessage.EXIT_PANEL));
        VBox vbox = this.addVBox("Play Ripoff");
        vbox.getChildren().add(btn1);
        vbox.getChildren().add(btn2);
        vbox.getChildren().add(btn3);
        vbox.getChildren().add(btnExit);
        // Create the scene and return.
        Scene scene = new Scene(vbox, 800, 600);
        return scene;
    }

   /*
    * Helper funciton for building the inventory panel. Creates the buttons and returns
    * a scene to be added to the stage.
    */
    private Scene buildPlayerPanel(){
        Button btn1 = this.addButton("See my Deck", new RipoffMessage(RipoffMessage.SEE_DECK));
        Button btn2 = this.addButton("Send Memes to Player", new RipoffMessage(RipoffMessage.SEND_MEMES));
        Button btnExit = this.addButton("Exit Menu", new RipoffMessage(RipoffMessage.EXIT_PANEL));
        VBox vbox = this.addVBox("Look yourself in the mirror");
        vbox.getChildren().add(btn1);
        vbox.getChildren().add(btn2);
        vbox.getChildren().add(btnExit);
        // Create the scene and return.
        Scene scene = new Scene(vbox, 800, 600);
        return scene;
    }

   /*
    * Builds a button given a title and a message to throw for its event.
    * @param String title the label text for the button
    * @param RegisterMessage throwMessage the message to send with the event.
    */
    private Button addButton(String title, final RipoffMessage throwMessage) {
        Button btn = new Button();
        btn.setText(title);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Fire a custom event.
                RipoffEvent ripEvent = new RipoffEvent(this, throwMessage);
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
