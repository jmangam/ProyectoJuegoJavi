package es.javimg.proyectojuegojavi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;



public class App extends Application {
    
    int imgX = 0;
    int img1X = 998;
    
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
        paneRoot.getChildren().add(img1View);

        Rectangle cuerpo = new Rectangle ();
        cuerpo.setWidth(50);
        cuerpo.setHeight(33);
        cuerpo.setX(5);
        cuerpo.setY(30);
        cuerpo.setFill(Color.GREEN);
        
        Circle cabeza = new Circle();
        cabeza.setRadius(25); 
        cabeza.setCenterX(30);
        cabeza.setCenterY(30);
        cabeza.setFill(Color.GREEN);
        
        Circle ojo = new Circle();
        ojo.setRadius(7); 
        ojo.setCenterX(30);
        ojo.setCenterY(30);
        ojo.setFill(Color.BLACK);
        
        
        paneRoot.getChildren().add(cuerpo);
        paneRoot.getChildren().add(cabeza);
        paneRoot.getChildren().add(ojo);
        
        Timeline animationpaisaje = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                //System.out.println(desiertoX);
                imgView.setX(imgX);
                imgX -= 5;
               
                //System.out.println(desiertoX2);
                img1View.setX(img1X);
                img1X -= 5;
               
                if (imgX < -990) {
                imgX = 998;
                }
               
                if (img1X < -990) {
                img1X = 998;
                }
               
            })
        );
        animationpaisaje.setCycleCount(Timeline.INDEFINITE);
        animationpaisaje.play();

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}