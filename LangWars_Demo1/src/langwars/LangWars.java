/**
 * @author CSE29999_Fall2017_Team6
 */

package langwars;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LangWars extends Application
{
    @Override

    public void start(Stage primaryStage)
    {
        LangWarsPane pane = new LangWarsPane();
        Scene scene = new Scene(pane, 1280, 800);
        pane.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: white");
        primaryStage.setTitle("LANG.WARS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
       
    public static void main(String[] args) 
    {

        LangWarsPlayer player = new LangWarsPlayer(30,10,"New Player");
        LangWarsPlayer computer = new LangWarsPlayer(30,10,"Computer");

        System.out.println("New Player : " + player);
        System.out.println("Computer   : " + computer);
        
        launch(args);
    }    
}