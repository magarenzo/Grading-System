import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.geometry.*;      
import javafx.event.ActionEvent;
import javafx.scene.control.*; 
import javafx.scene.input.*;

public class MenuGUI
{
    public static void start(Stage stage, Integer userType)
    {
        stage.close();
        Stage mainStage = new Stage();
        mainStage.setTitle("Grading System");

        BorderPane root = new BorderPane();

        Scene mainScene = new Scene(root);
        mainStage.setScene(mainScene);

        // menu bar

        MenuBar menuBar = new MenuBar();
        root.setTop(menuBar);

        // file
        Menu menuFile = new Menu("File");
        menuBar.getMenus().add(menuFile);
        
        // -changePass
        MenuItem menuItemChangePass = new MenuItem("Change Password");
        menuItemChangePass.setOnAction( 
            (ActionEvent event) -> 
            {
                String currPass = PersistantStorage.showInput("Enter current password: ");
                if(!PersistantStorage.changePassword(currPass))
                    ErrorDialog.showDialog("Invalid user/password");
            }
        );
        menuFile.getItems().add(menuItemChangePass);

        // -logout
        MenuItem menuItemLogout = new MenuItem("Logout");
        menuItemLogout.setOnAction( 
            (ActionEvent event) -> 
            {
                LoginGUI temp = new LoginGUI();
                temp.start(stage); // go back to login
                temp = null;
                mainStage.close();
                PersistantStorage.saveData(); // update data
            }
        );
        menuFile.getItems().add(menuItemLogout);

        // -quit
        MenuItem menuItemQuit = new MenuItem("Quit");
        menuItemQuit.setOnAction( (ActionEvent event) -> mainStage.close() );
        menuItemQuit.setAccelerator( new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN) );
        menuFile.getItems().add(menuItemQuit);

        // center contents
        VBox centerVBox = new VBox();
        centerVBox.setAlignment( Pos.CENTER );
        centerVBox.setPadding( new Insets(20) );
        centerVBox.setSpacing( 16 );
        centerVBox.setStyle( "-fx-font-size: 16;" );
        root.setCenter(centerVBox);

        HBox globalBox = new HBox(); // global buttons
        globalBox.setSpacing(16);
        globalBox.setPadding( new Insets(16) );
        globalBox.setAlignment(Pos.CENTER);
        centerVBox.getChildren().add(globalBox);

        Button viewCourseButton = new Button("View Course");
        viewCourseButton.setOnAction((ActionEvent e) -> ViewCourseActivator.viewCourse());

        Button viewAssignmentButton = new Button("View Assignment");
        viewAssignmentButton.setOnAction((ActionEvent e) -> AssignmentActivator.viewAssignment());

        globalBox.getChildren().addAll(viewCourseButton, viewAssignmentButton);

        if(userType == 0) // student
        {
            mainStage.setTitle("Grading System: Student");
            HBox studentBox = new HBox();
            studentBox.setSpacing(16);
            studentBox.setPadding( new Insets(16) );
            studentBox.setAlignment(Pos.CENTER);
            centerVBox.getChildren().add(studentBox);

            Button viewGradeButton = new Button("View Grade");
            viewGradeButton.setOnAction((ActionEvent e) -> ViewGradeActivator.viewGrade());

            Button dropCourseButton = new Button("Drop Course");
            dropCourseButton.setOnAction((ActionEvent e) -> DropCourseActivator.dropCourse());

            studentBox.getChildren().addAll(viewGradeButton, dropCourseButton);
        }

        if(userType > 0) // TA/Professor
        {
            mainStage.setTitle("Grading System: TA");
            HBox taBox = new HBox();
            taBox.setSpacing(16);
            taBox.setPadding( new Insets(16) );
            taBox.setAlignment(Pos.CENTER);
            centerVBox.getChildren().add(taBox);

            Button enterGradeButton = new Button("Enter Grade");
            enterGradeButton.setOnAction((ActionEvent e) -> GradeActivator.enterGrade());

            Button accessRosterButton = new Button("Access Roster");
            accessRosterButton.setOnAction((ActionEvent e) -> RosterActivator.viewRoster());

            taBox.getChildren().addAll(enterGradeButton, accessRosterButton);
        }

        if(userType == 2) // professor
        {
            mainStage.setTitle("Grading System: Professor");
            HBox professorBox = new HBox();
            professorBox.setSpacing(16);
            professorBox.setPadding( new Insets(16) );
            professorBox.setAlignment(Pos.CENTER);
            centerVBox.getChildren().add(professorBox);

            Button changeGradeButton = new Button("Change Grade");
            changeGradeButton.setOnAction((ActionEvent e) -> GradeActivator.modifyGrade());

            Button removeAssignmentButton = new Button("Remove Assignment");
            removeAssignmentButton.setOnAction((ActionEvent e) -> AssignmentActivator.deleteAssignment());

            Button addAssignmentButton = new Button("Add Assignment");
            addAssignmentButton.setOnAction((ActionEvent e) -> AssignmentActivator.createAssignment());

            Button editAssignmentButton = new Button("Edit Assignment");
            editAssignmentButton.setOnAction((ActionEvent e) -> AssignmentActivator.modifyAssignment());

            Button removeStudentButton = new Button("Remove Student");
            removeStudentButton.setOnAction((ActionEvent e) -> RosterActivator.removeStudent());

            Button addStudentButton = new Button("Add Student");
            addStudentButton.setOnAction((ActionEvent e) -> RosterActivator.enterStudent());

            
            professorBox.getChildren().addAll(changeGradeButton, removeAssignmentButton, addAssignmentButton, editAssignmentButton, removeStudentButton, addStudentButton);
        }

        mainStage.show();
    }
}
