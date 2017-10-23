package LangWars;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class LangWarsPane extends HBox        
{
    final private Image splashImage;
    final private Image boardImage;
    final private Image loadingImage;
    final private ImageView boardView;
    
    public LangWarsPane()
    {
        splashImage = new Image("splash.jpg", 1280, 800, false, false);
        boardImage = new Image("board.jpg", 1280, 800, false, false);
        loadingImage = new Image("loading.gif");
        boardView = new ImageView();
        
        StackPane imagePane = new StackPane(boardView);
        imagePane.setPrefSize(1280, 800);
        
        Timeline timeline = new Timeline
        (
            new KeyFrame(Duration.ZERO, new KeyValue(boardView.imageProperty(), splashImage)),
            new KeyFrame(Duration.seconds(2), new KeyValue(boardView.imageProperty(), loadingImage)),
            new KeyFrame(Duration.seconds(7), new KeyValue(boardView.imageProperty(), boardImage))
         );

        timeline.play();      
//       StackPane pane = new StackPane();
        getChildren().addAll(imagePane);
    }
}