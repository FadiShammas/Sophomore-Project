package lang.wars;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LangWarsPane extends HBox
        
{
    final private Image splashImage;
    final private ImageView imgView;
    
    public LangWarsPane()
    {
        splashImage = new Image("splash.jpg");
        imgView = new ImageView(splashImage);

        StackPane imagePane = new StackPane(imgView);
        imagePane.setPrefSize(1000, 650);
        
        getChildren().addAll(imagePane);
    }
}