/**
 * @author CSE29999_Fall2017_Team6
 */

package lang.wars;

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
    pane.setAlignment(Pos.CENTER);
    pane.setStyle("-fx-background-color: black");
        
    Scene scene = new Scene(pane, 1000, 650);
      primaryStage.setTitle("LANG.WARS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        
    public static void main(String[] args) 
    {
        launch(args);
    }    
}