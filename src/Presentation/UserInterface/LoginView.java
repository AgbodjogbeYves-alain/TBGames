package Presentation.UserInterface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import Application.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginView extends Application{

	@Override
    public void start(Stage primaryStage) throws FileNotFoundException {   
		Group root = new Group();
		HBox boutonRegion = new HBox();
		HBox pictureRegion = new HBox();
		GridPane grid = new GridPane();
		Scene scene = new Scene(root, 400, 340, Color.WHITE);
		
		//Add icon
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("Images/iconTB.png")));
		
		//Add image
		final ImageView imv = new ImageView();
        final Image image2 = new Image(LoginView.class.getResourceAsStream("Images/logoTB50.png"));
        imv.setImage(image2); 
        
        pictureRegion.getChildren().add(imv);
        
		
        //Defines the grid layout for the form
        
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(pictureRegion, 1, 1);
        

        //Username
        Label userName = new Label("User Name:");
        //userName.setTextFill(Color.web("#FFFFFF"));
        grid.add(userName, 0, 3);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 3);

        //Password
        Label pw = new Label("Password:");
        //pw.setTextFill(Color.web("#FFFFFF"));
        grid.add(pw, 0, 4);
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 4);
 
        //login message
        Label msg = new Label();
        grid.add(msg, 1, 5);
        
        //login button
        Button loginBtn = new Button("Login");
        Button signupBtn = new Button("Sign Up");
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
        
        boutonRegion.setSpacing(10);
        boutonRegion.getChildren().addAll(loginBtn,signupBtn);
        
        grid.add(boutonRegion,1,6);
        
        root.getChildren().add(grid);  
 
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
