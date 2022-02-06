package es.javimg.proyectojuegojavi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;



public class App extends Application {
    
    int velocidad = 5;
    int imgX = 0;
    int img1X = 998;
    int contazulX = 0;
    int movidrio = 0;
    int pospersonaje= 0;
    int velpersonaje=0;
    int velbotella=0;
    int posX = 0;
    int posY = 0;
    int moverde = 0;
    int TEXT_SIZE = 20;
    int zombieY = 265;
    int zombieX = 10;
    int movazul = 0;
    int velocidadcontenedor = 5;
    int puntuacion = 0;

    
    
    //imagen de fondo 1
    Image img = new Image(getClass().getResourceAsStream("/images/imagentop.jpg"));
    ImageView imgView = new ImageView(img);
    //imagen de fondo 2
    Image img1 = new Image(getClass().getResourceAsStream("/images/imagentop1.jpg"));
    ImageView img1View = new ImageView(img);
    //imagen del personaje
    Image img2 = new Image(getClass().getResourceAsStream("/images/personaje.gif"));
    ImageView img2View = new ImageView(img2);
    //item botella vidrio
    Image imgvidrio = new Image(getClass().getResourceAsStream("/images/botella_vidrio.png"));
    ImageView imgvidrioView = new ImageView(imgvidrio);

    
    
    @Override
    public void start(Stage stage) {
        Pane paneRoot = new Pane();  //creacion de ventana con sus dimensiones y su nombre
        Scene scene = new Scene(paneRoot, 998, 500);
        stage.setScene(scene);
        stage.setTitle("JuegoJavi");
        stage.show();
        
        //añadimos todas las imagenes en pantalla y le damos las cordenadas necesarias
        paneRoot.getChildren().add(imgView);
        paneRoot.getChildren().add(img1View);
        paneRoot.getChildren().add(img2View);
        paneRoot.getChildren().add(imgvidrioView);
        img2View.setX(zombieX);
        img2View.setY(zombieY);
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
        
        Rectangle todoverde = new Rectangle();
        todoverde.setWidth(50);
        todoverde.setHeight(60);
        todoverde.setX(5);
        todoverde.setY(7);
        todoverde.setFill(Color.BLUE);
        todoverde.setVisible(false);
        
        //Creacion del grupo de contenedor verde
        Group contverde = new Group();
        contverde.getChildren().add(parteabajo);
        contverde.getChildren().add(partearriba);
        contverde.getChildren().add(agujero);
        contverde.getChildren().add(todoverde);
        contverde.setLayoutY(370);
        contverde.setLayoutX(990);
        
        //mostramos por pantalla contenedor verde
        paneRoot.getChildren().add(contverde);
        //
        
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
        
        Rectangle todoazul = new Rectangle();
        todoazul.setWidth(50);
        todoazul.setHeight(60);
        todoazul.setX(5);
        todoazul.setY(7);
        todoazul.setFill(Color.BLUE);
        todoazul.setVisible(false);

        
        //creacion del grupo que corresponde al contenedor azul
        Group contazul = new Group();
        contazul.getChildren().add(parteabajo1);
        contazul.getChildren().add(partearriba1);
        contazul.getChildren().add(agujero1);
        contazul.getChildren().add(todoazul);
        contazul.setLayoutY(370);
        contazul.setLayoutX(500);
        
        //Mostramos por pantalla el contenedor azul
        paneRoot.getChildren().add(contazul);

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
        
        //mostramos por pantalla contenedor amarillo(si no estuviese comentada la linea)
        //paneRoot.getChildren().add(contamarillo);
        
        
        //creacion del rectangulo que dara la colision a la botella de vidrio
        Rectangle vidriorec = new Rectangle ();
        vidriorec.setWidth(20);
        vidriorec.setHeight(50);
        vidriorec.setX(0);
        vidriorec.setY(382);
        vidriorec.setFill(Color.BLUE);
        vidriorec.setVisible(false);//lo hacemos desaparecer para que solo se vea la botella

        //creacion del rectangulo que dara la colision al personaje
        Rectangle personajerec = new Rectangle ();
        personajerec.setWidth(46);
        personajerec.setHeight(53);
        personajerec.setX(122);
        personajerec.setY(378);
        personajerec.setFill(Color.BLUE);
        personajerec.setVisible(false);//lo hacemos desaparacer para que solo le vea nuestro personaje
        
        //creacion del grupo que une la imagen y el rectangulo que le da colision
        Group vidrio = new Group();
        vidrio.getChildren().addAll(imgvidrioView, vidriorec);
        paneRoot.getChildren().add(vidrio);
        vidrio.setLayoutX(500);
        
                //
        
        //Puntuaciones
        HBox paneScores = new HBox();
        paneScores.setTranslateY(20);
        paneScores.setMinWidth(998);
        paneScores.setAlignment(Pos.CENTER);
        paneScores.setSpacing(100);
        paneRoot.getChildren().add(paneScores);
        //Puntuacion Actual      
        HBox paneCurrentScore = new HBox();
        paneCurrentScore.setSpacing(10);
        paneScores.getChildren().add(paneCurrentScore);
        //Etiqueta Puntuacion      
        Text textTitleScore = new Text ("Puntuacion:");
        textTitleScore.setFont(Font.font(TEXT_SIZE));
        textTitleScore.setFill(Color.BLACK);
        //etiqueta si salimos victoriosos
        Text textTitleScore2 = new Text ("Has Ganado. Presiona la R");
        textTitleScore2.setFont(Font.font(TEXT_SIZE));
        textTitleScore2.setFill(Color.BLACK);
        textTitleScore2.setVisible(false);
        //etiqueta si salimos perdiendo
        Text textTitleScore3 = new Text ("Has perdido. Presiona la R");
        textTitleScore3.setFont(Font.font(TEXT_SIZE));
        textTitleScore3.setFill(Color.BLACK);
        textTitleScore3.setVisible(false);
        
        //Sobre Puntuacion      
        Text textScore = new Text ("1");
        textScore.setFont(Font.font(TEXT_SIZE));
        textScore.setFill(Color.BLACK);
        //Añadir los textos a los layouts
        paneCurrentScore.getChildren().add(textTitleScore);
        paneCurrentScore.getChildren().add(textScore);
        paneCurrentScore.getChildren().add(textTitleScore2);
        paneCurrentScore.getChildren().add(textTitleScore3);
        
        
        
        
        // unimos por un grupo nuestro personaje con el rectangulo que nos dara la colision
        Group personaje = new Group();
        personaje.getChildren().addAll(img2View, personajerec);
        paneRoot.getChildren().add(personaje);
                  
                
                    scene.setOnKeyPressed((KeyEvent event) -> {//en este apartado tenemos el reconocimiento de botones, uno hace que nuestro personaje salte y el otro reinicia la partida
                    if (posY == 0) {
                        switch(event.getCode()) {    
                        case UP:
                            velpersonaje = -6;
                            System.out.println(posY);
                       break;
                        case R:
                            puntuacion = 1;
                            vidrio.setLayoutX(800);
                            textTitleScore2.setVisible(false);
                            textTitleScore3.setVisible(false);
                            textTitleScore.setVisible(true);
                            textScore.setVisible(true);
                            velocidadcontenedor = 5;
                            
                        } 
                    }
                    });



        

        Timeline animationpaisaje = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {

                
                //estas lineas se encargan de hacer que las imagenes de fondo se muevan a la vez
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
                
                
                
                // estas lineas hacen que la botella se mueva a la vez que el fondo
                movidrio -= velocidad;
                vidrio.setLayoutX(movidrio);
                //System.out.println(movLinea);
                if (movidrio < -5) {
                    movidrio = 998;
                    vidrio.setLayoutX(movidrio);
                }
                
                // estas lineas hacen que el contenedor verde se mueva a la vez que el fondo
                 moverde -= velocidadcontenedor;
                contverde.setLayoutX(moverde);
                //System.out.println(movLinea);
                if (moverde < -5) {
                    moverde = 1800;
                    contverde.setLayoutX(moverde);
                }
                // estas lineas hacen que el contenedor azul se mueva a la vez que el fondo
                movazul -= velocidadcontenedor;
                contazul.setLayoutX(movazul);
                if (movazul < -5) {
                    movazul = 2300;
                    contazul.setLayoutX(movazul);
                }
                
                //colosion entre la botella y nuestro personaje
                Shape colision1 = Shape.intersect(vidriorec, personajerec);
                boolean colisionVacia1 = colision1.getBoundsInLocal().isEmpty();
                
                
                //este if hace que nuestro personaje se lleve la botella para empezar la mision principal del juego
                if(colisionVacia1 == false) {
                    //movidrio = 1000;
                    vidrio.setLayoutX(165);
                    velocidad = 0;
                    vidrio.setLayoutY(posY);    
                }
                
                
                //colision entre la botella y el contenedor verde
                Shape colision2 = Shape.intersect(todoverde, vidriorec);
                boolean colisionVacia2 = colision2.getBoundsInLocal().isEmpty();
                
                
                //esto hace que cuando la botella colisione con el contenedor verde nos de un punto
                if(colisionVacia2 == false) {
                    vidrio.setLayoutX(700);
                    moverde = 2000;
                    puntuacion = puntuacion+1;
                    textScore.setText(String.valueOf(puntuacion));
                }
                
                //colision entre el contenedor azul  y la botella
                Shape colision3 = Shape.intersect(todoazul, vidriorec);
                boolean colisionVacia3 = colision3.getBoundsInLocal().isEmpty();
                
                //esto hace que nos quiten puntos cuando la botella colisione con el contenedor azul, ya que es el contenedor equivocado
                 if(colisionVacia3 == false) {
                    vidrio.setLayoutX(700);
                    movazul = 3000;
                    puntuacion = puntuacion - 1;
                    textScore.setText(String.valueOf(puntuacion));
                }
                
                //Le damos el valor de xy del personaje a dos variables para poder hacer el salto
                personaje.setLayoutX(posX);
                personaje.setLayoutY(posY);
                
                //actualizamos el valor de Y del personaje sumandole la velocidad del mismo
                posY+= velpersonaje;
                
                
                //este if se encarga de darle un limite de salto a nuestro personaje
                if(posY < -120) {
                  velpersonaje = 6;
                }
                
                // este if se encarga de darle el limite del suelo a nuestro personaje 
                if(posY == 0) {
                   velpersonaje = 0;
                }
                
                //este if ejecuta las consecuencias de ganar la partida
                if(puntuacion == 10) {
                   textTitleScore2.setVisible(true);
                   textTitleScore.setVisible(false);
                   textScore.setVisible(false);
                   velocidadcontenedor = 5;
                   puntuacion = 1;
                }
                
                //este if incrementa la dificultad cuando nuestra puntuacion es 5 o superior, aumenta la dificultad añadiendole velocidad a los items
                if(puntuacion >= 5)   {
                    
                    velocidadcontenedor = 10;
                    
                }
                                   
                //este if ejecuta las consecuencias de perder la partida
                if(puntuacion == 0) {
                   textTitleScore3.setVisible(true);
                   textTitleScore.setVisible(false);
                   textScore.setVisible(false);
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