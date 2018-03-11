package Presentation.UserInterface;

import Application.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginView extends Application{

	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");   
        
        //Defines the grid layout for the form
        StackPane stack = new StackPane();
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        //Define the different elements for the grid
        Text scenetitle = new Text("Welcome!!");
        Text scenetitle2 = new Text("Please fill the form to sign in");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        grid.add(scenetitle2, 0, 1);
        grid.setStyle("-fx-background-color: #336699;");

        //Username
        Label userName = new Label("User Name:");
        userName.setTextFill(Color.web("#FFFFFF"));
        grid.add(userName, 0, 2);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 2);

        //Password
        Label pw = new Label("Password:");
        pw.setTextFill(Color.web("#FFFFFF"));
        grid.add(pw, 0, 3);
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 3);
 
        //login message
        Label msg = new Label();
        grid.add(msg, 1, 4);
        
        //login button
        Button loginBtn = new Button("Login");
        //Quick Assignment of the login action
        //TODO : Create an event handler class
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	if (ApplicationFacade.getInstance().login(userTextField.getText(),pwBox.getText())) {
            		msg.setText("Accepted");
            	}
            	else {
            		msg.setText("Refused");
            	}
            }
        });
        grid.add(loginBtn, 1, 5);
        
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @return
     */
    public String login() {
        // TODO implement here
        return "";
    }

    public static void main(String[] args) {
        launch(args);
    }

}
