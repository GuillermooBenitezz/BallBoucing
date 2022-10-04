/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package BallBoucing;

import com.sun.javafx.perf.PerformanceTracker;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;


/**
 *
 * @author usu2dam
 */
public class BallBoucing extends Application {
    
    public static double ballSpeed = 2;
    public static double ballSpeedY = 2;

    
    @Override
    public void start(Stage primaryStage) {
        
        Group pane = new Group();
        
        Circle ball = new Circle(10);
        ball.setTranslateX(300 * 0.5);
        ball.setTranslateY(250 * 0.5);
        
        Label label = new Label();
        label.setTranslateX(10);
        label.setTranslateY(10);
        
        pane.getChildren().addAll(ball, label);
        
        
        Scene scene = new Scene(pane, 300, 250);
        
        EventHandler<ActionEvent> eH = e->
        {
            PerformanceTracker perfTracker=
                PerformanceTracker.getSceneTracker(scene);
            label.setText("FPS (Timeline) = "+ perfTracker.getInstantFPS());
            
            if(ball.getTranslateX()< 0 || ball.getTranslateX()> scene.getWidth()){
                ballSpeed*=-1;
            }
            if(ball.getTranslateY() < 0 || ball.getTranslateY() > scene.getHeight())
            {
                ballSpeedY*=-1;
            }
            ball.setTranslateX(ball.getTranslateX()+ ballSpeed);
            ball.setTranslateY(ball.getTranslateY()+ ballSpeedY);
        };
        
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(5),eH));
        
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        
        primaryStage.setTitle("Ball Boucing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
