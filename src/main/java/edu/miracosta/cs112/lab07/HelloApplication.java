package edu.miracosta.cs112.lab07;//package name here depending on your IDE

import javafx.application.Application;  //abstract class used for JavaFX GUI's
import javafx.stage.Stage;              //class for GUI window
import javafx.scene.Scene;              //class for specific view in GUI window
import javafx.scene.layout.VBox;        //class for layout pane, organized top-to-bottom
import javafx.scene.control.Label;      //class for label component
import javafx.scene.control.Button;     //class for button component
import javafx.scene.control.TextField;
import javafx.event.EventHandler;       //interface for handling events
import javafx.event.ActionEvent;        //class for type of event for action (like button or key pressed)

public class HelloApplication extends Application implements EventHandler<ActionEvent>  { //inheriting core functionality + this class will handle events
    /*** GUI COMPONENTS ***/
    private Button button;
    private Label message;
    private TextField nameTextField;
    private int click = 0;

    /*** DRIVER main ***/
    public static void main(String[] args) {
        launch(args); //method from Application class, must be called to setup javafx application
    }

    /*** OVERRIDDEN Application METHODS ***/
    @Override
    public void start(Stage primaryStage) throws Exception{ //Application automatically calls this method to run (our) main javafx code. passes in primary stage (main window)
        //SETUP COMPONENTS
        message = new Label("Hi User!");
        button = new Button("Click me!"); //or can set text using setText method separately

        nameTextField = new TextField();
        button.setOnAction(this); //who the event handler is (which object/class should handle the event)


        //ADD COMPONENTS
        VBox layout = new VBox(); //simple layout, components are stacked on top of each other in added order
        layout.getChildren().addAll(message, nameTextField, button);


        //SETUP SCENE AND SHOW
        Scene scene = new Scene(layout, 300, 250); //layout, dimensions of window
        primaryStage.setScene(scene);
        primaryStage.setTitle("Group 1- Rachel Kao"); //setting title of main window
        primaryStage.show();
    }

    /*** OVERRIDDEN EventHandler METHODS ***/
    @Override
    public void handle(ActionEvent actionEvent) { //generic method used to handle when events occur (like handle button click)
        //good practice to identify source, in case you have multiple event types/sources
        if(actionEvent.getSource() == button) {
            click++;
            message.setText("Hi #" + click + "," + nameTextField.getText() +" !");
            System.out.println("hello CS112!");
        }
    }
}