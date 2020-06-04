import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.geometry.*;      
import javafx.event.ActionEvent;
import javafx.scene.control.*; 
import javafx.scene.input.*;

public class LoginGUI extends Application
{
    public static void main(String[] args) 
    {
        PersistantStorage.loadData(); // load data
        try
        {
            launch(args);
        }
        catch (Exception error)
        {
            error.printStackTrace();
        }
        finally
        {
            System.exit(0);
        }
    }
    TextField userNameField;
    PasswordField passwordField;
    
    public void start(Stage mainStage)
    {
        mainStage.setTitle("Grading System: Login");

        BorderPane root = new BorderPane();

        Scene mainScene = new Scene(root);
        mainStage.setScene(mainScene);

        // menu bar

        MenuBar menuBar = new MenuBar();
        root.setTop(menuBar);

        // file
        Menu menuFile = new Menu("File");
        menuBar.getMenus().add(menuFile);

        // -quit
        MenuItem menuItemQuit = new MenuItem("Quit");
        menuItemQuit.setOnAction( (ActionEvent event) -> mainStage.close() );
        menuItemQuit.setAccelerator( new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN) );
        menuFile.getItems().add(menuItemQuit);

        // center contents
        VBox centerVBox = new VBox();
        centerVBox.setAlignment( Pos.CENTER );
        centerVBox.setSpacing(16);
        centerVBox.setPadding( new Insets(16) );
        centerVBox.setStyle( "-fx-font-size: 16;" );
        root.setCenter(centerVBox);

        // info label
        Label infoLabel = new Label("Unfinished Project - still contains bugs and does not reflect what the finished project will look like.");

        centerVBox.getChildren().add(infoLabel);

        // username line
        HBox userNameBox = new HBox();
        userNameBox.setAlignment( Pos.CENTER );
        centerVBox.getChildren().add(userNameBox);

        Label userNameLabel = new Label("User Name: ");
        userNameField = new TextField();
        userNameField.setOnAction(
            (ActionEvent e) ->
            {
                this.login(mainStage);
            }
        );

        userNameBox.getChildren().addAll(userNameLabel, userNameField);
        // password line
        HBox passwordBox = new HBox();
        passwordBox.setAlignment( Pos.CENTER );
        centerVBox.getChildren().add(passwordBox);

        Label passwordLabel = new Label("Password: ");
        passwordField = new PasswordField();
        passwordField.setOnAction(
            (ActionEvent e) ->
            {
                this.login(mainStage);
            }
        );

        passwordBox.getChildren().addAll(passwordLabel, passwordField);
        Button loginButton = new Button("Login");
        centerVBox.getChildren().add(loginButton);
        loginButton.setOnAction(
            (ActionEvent e) ->
            {
                this.login(mainStage);
            }
        );

        mainStage.show();
    }

    // try to login
    private void login(Stage mainStage)
    {
        String userName = userNameField.getText();
        String password = passwordField.getText();
        
        if(userName == null || password == null || userName.equals("") || password.equals(""))
            return; //blank

        Integer accountType = PersistantStorage.verifyUser(userName, password);
        if(accountType == -1) // invalid input
        {
            ErrorDialog.showDialog("Invalid Credentials");
            return;
        }

        MenuGUI.start(mainStage, accountType); // valid user - continue to menu
    }
}
