package es.javimg.proyectojuegojavi;

import java.time.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class App extends Application {
    
    int imgX = ;
    int img1X = ;
    
    //imagen de fondo
    Image img = new Image(getClass().getResourceAsStream("/images/imagentop.jpg"));
    ImageView imgView = new ImageView(img);
        
    Image img1 = new Image(getClass().getResourceAsStream("/images/imagentop1.jpg"));
    ImageView img1View = new ImageView(img);
    

    @Override
    public void start(Stage stage) {
        Pane paneRoot = new Pane();  
        Scene scene = new Scene(paneRoot, 998, 500);
        stage.setScene(scene);
        stage.setTitle("JuegoJavi");
        stage.show();
        
      
        
        paneRoot.getChildren().add(imgView);
        
        Timeline animationDesierto = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                //System.out.println(desiertoX);
                imgView.setX(imgX);
                imgX -= 5;
               
                //System.out.println(desiertoX2);
                img1View.setX(img1X);
                img1X -= 5;
               
                if (imgX < -1377) {
                imgX = 1350;
                }
               
                if (img1X < -1377) {
                img1X = 1350;
                }
             
                lineaX -= 5 ;
               
                root.getChildren().add(grupoLinea1);

            })
        );
        animationDesierto.setCycleCount(Timeline.INDEFINITE);
        animationDesierto.play();

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}