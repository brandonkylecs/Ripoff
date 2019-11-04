/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author tnwallsc who changed like one line of Ike Quigley's code.
 */
public class Main extends Application {

   @Override
    public void start(Stage primaryStage) {
        // Create a SimpleGame object.
        SimpleGameController simpleGame = new SimpleGameController(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        // Initialize the Transaction object.
    }

}
