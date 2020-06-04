import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.geometry.*;      
import javafx.event.ActionEvent;
import javafx.scene.control.*; 
import javafx.scene.input.*;

public class TestMenu extends Application
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

    public void start(Stage mainStage)
    {
        mainStage.setTitle("Grading System: Test Menu");

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
        centerVBox.setPadding( new Insets(16) );
        centerVBox.setStyle( "-fx-font-size: 16;" );
        root.setCenter(centerVBox);

        // warning label
        Label warningLabel = new Label("Warning: This menu is for testing only and is not for the final product");

        // info label
        Label infoLabel = new Label("Select user type");

        centerVBox.getChildren().addAll(warningLabel, infoLabel);

        // buttons
        HBox buttonHBox = new HBox();
        buttonHBox.setSpacing(16);
        buttonHBox.setPadding( new Insets(16) );
        buttonHBox.setAlignment( Pos.CENTER );
        centerVBox.getChildren().add(buttonHBox);

        Button studentButton = new Button("Student");
        studentButton.setOnAction( (ActionEvent e) -> MenuGUI.start(mainStage, 0));

        Button teachingAssistantButton = new Button("Teaching Assistant");
        teachingAssistantButton.setOnAction( (ActionEvent e) -> MenuGUI.start(mainStage, 1));

        Button professorButton = new Button("Professor");
        professorButton.setOnAction( (ActionEvent e) -> MenuGUI.start(mainStage, 2));

        buttonHBox.getChildren().addAll(studentButton, teachingAssistantButton, professorButton);

        mainStage.show();
    }
}
