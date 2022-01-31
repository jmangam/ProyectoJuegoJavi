package es.javimg.proyectojuegojavi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;



public class App extends Application {
    
    int imgX = 0;
    int img1X = 998;
    int contazulX = 0;
    int movidrio = 0;
    //imagen de fondo 1
    Image img = new Image(getClass().getResourceAsStream("/images/imagentop.jpg"));
    ImageView imgView = new ImageView(img);
    //imagen de fondo 2
    Image img1 = new Image(getClass().getResourceAsStream("/images/imagentop1.jpg"));
    ImageView img1View = new ImageView(img);
    //gif del personaje
    Image img2 = new Image(getClass().getResourceAsStream("/images/personaje.gif"));
    ImageView img2View = new ImageView(img2);
    
    Image imgvidrio = new Image(getClass().getResourceAsStream("/images/botella_vidrio.png"));
    ImageView imgvidrioView = new ImageView(imgvidrio);

    
    
    @Override
    public void start(Stage stage) {
        Pane paneRoot = new Pane();  
        Scene scene = new Scene(paneRoot, 998, 500);
        stage.setScene(scene);
        stage.setTitle("JuegoJavi");
        stage.show();
        
        //añadimos las 3 imagenes en pantalla
        paneRoot.getChildren().add(imgView);
        paneRoot.getChildren().add(img1View);
        paneRoot.getChildren().add(img2View);
        paneRoot.getChildren().add(imgvidrioView);
        img2View.setX(10);
        img2View.setY(265);
        img2View.setScaleX(0.25);
        img2View.setScaleY(0.25);
        imgvidrioView.setY(370);
        
        
        
        //dibujo contenedor verde
        Rectangle parteabajo = new Rectangle ();
        parteabajo.setWidth(50);
        parteabajo.setHeight(33);
        parteabajo.setX(5);
        parteabajo.setY(30);
        parteabajo.setFill(Color.GREEN);
        
        Circle partearriba = new Circle();
        partearriba.setRadius(25); 
        partearriba.setCenterX(30);
        partearriba.setCenterY(30);
        partearriba.setFill(Color.GREEN);
        
        Circle agujero = new Circle();
        agujero.setRadius(7); 
        agujero.setCenterX(30);
        agujero.setCenterY(25);
        agujero.setFill(Color.BLACK);
        
        Group contverde = new Group();
        contverde.getChildren().add(parteabajo);
        contverde.getChildren().add(partearriba);
        contverde.getChildren().add(agujero);
        
        //paneRoot.getChildren().add(contverde);
        
        //dibujo contenedor azul
        Rectangle parteabajo1 = new Rectangle ();
        parteabajo1.setWidth(50);
        parteabajo1.setHeight(33);
        parteabajo1.setX(5);
        parteabajo1.setY(30);
        parteabajo1.setFill(Color.BLUE);
        
        Circle partearriba1 = new Circle();
        partearriba1.setRadius(25); 
        partearriba1.setCenterX(30);
        partearriba1.setCenterY(30);
        partearriba1.setFill(Color.BLUE);
        
        Circle agujero1 = new Circle();
        agujero1.setRadius(7); 
        agujero1.setCenterX(30);
        agujero1.setCenterY(25);
        agujero1.setFill(Color.BLACK);

        Group contazul = new Group();
        contazul.getChildren().add(parteabajo1);
        contazul.getChildren().add(partearriba1);
        contazul.getChildren().add(agujero1);
        
        //paneRoot.getChildren().add(contazul);

        //dibujo contenedor amarillo
        Rectangle parteabajo2 = new Rectangle ();
        parteabajo2.setWidth(50);
        parteabajo2.setHeight(33);
        parteabajo2.setX(5);
        parteabajo2.setY(30);
        parteabajo2.setFill(Color.YELLOW);
        
        Circle partearriba2 = new Circle();
        partearriba2.setRadius(25); 
        partearriba2.setCenterX(30);
        partearriba2.setCenterY(30);
        partearriba2.setFill(Color.YELLOW);
        
        Circle agujero2 = new Circle();
        agujero2.setRadius(7); 
        agujero2.setCenterX(30);
        agujero2.setCenterY(25);
        agujero2.setFill(Color.BLACK);
        
        Group contamarillo = new Group();
        contamarillo.getChildren().add(parteabajo2);
        contamarillo.getChildren().add(partearriba2);
        contamarillo.getChildren().add(agujero2);

        //paneRoot.getChildren().add(contamarillo);
        
        Rectangle vidriorec = new Rectangle ();
        vidriorec.setWidth(20);
        vidriorec.setHeight(50);
        vidriorec.setX(0);
        vidriorec.setY(382);
        vidriorec.setFill(Color.BLUE);
        vidriorec.setVisible(false);
        
        Rectangle personajerec = new Rectangle ();
        personajerec.setWidth(46);
        personajerec.setHeight(53);
        personajerec.setX(122);
        personajerec.setY(378);
        personajerec.setFill(Color.BLUE);
        personajerec.setVisible(false);
        
        Group vidrio = new Group();
        vidrio.getChildren().addAll(imgvidrioView, vidriorec);
        paneRoot.getChildren().add(vidrio);
        
        Group personaje = new Group();
        personaje.getChildren().addAll(img2View, personajerec);
        paneRoot.getChildren().add(personaje);
                  
       
                
        Timeline animationpaisaje = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {

                imgView.setX(imgX);
                imgX -= 5;
               
                img1View.setX(img1X);
                img1X -= 5;
               
                if (imgX < -990) {
                imgX = 998;
                }
               
                if (img1X < -990) {
                img1X = 998;
                }
                
                movidrio -= 5;
                vidrio.setLayoutX(movidrio);
                //System.out.println(movLinea);
                if (movidrio < -5) {
                    movidrio = 1000;
                    vidrio.setLayoutX(movidrio);
                }
                
                Shape colision1 = Shape.intersect(vidriorec, personajerec);
                boolean colisionVacia = colision1.getBoundsInLocal().isEmpty();
                
                if(colisionVacia == false) {
                     movidrio = 1000;
                    vidrio.setLayoutX(movidrio);
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