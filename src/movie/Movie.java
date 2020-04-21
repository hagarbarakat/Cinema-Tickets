/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import java.io.IOException;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import movie.Database;

/**
 *
 * @author lap store
 */
public class Movie extends Application {

    private Stage primaryStage;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Database d= new Database();

        VIP v= new VIP();
        v.book(30,1, "happy", d);
        this.primaryStage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
      
        primaryStage.show();
        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                primaryStage.close();
            }
        });

        delay.play();

       changeScene("Booking.fxml");
    }

    public void changeScene(String fxml) throws IOException, InterruptedException {

        Parent pane = FXMLLoader.load(
                getClass().getResource(fxml));

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
