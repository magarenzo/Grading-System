import java.util.HashMap;
import javax.swing.JOptionPane;
public class PersistantStorage
{
    public static Grade grade;
    public static RosterList rosterList;
    public static CourseList courseList;
    public static AssignmentList assignmentList;
    private static String currentUserName; // store current user
    private static HashMap<String, Account> accounts; // int stores account type; 0=student, 1=Teachers Assistant, 2=Professor

    public static void loadData()
    {
        // initialize objects
        grade = new Grade(86);

        rosterList = new RosterList();
        rosterList.enterRoster(new Roster("Student 1"));
        rosterList.enterRoster(new Roster("Student 2"));

        assignmentList = new AssignmentList();
        Assignment tempAssignment = new Assignment("Assignment 1");
        tempAssignment.setCourse(courseList);
        tempAssignment.setGrade(grade);
        tempAssignment.setRoster(rosterList);

        assignmentList.addAssignment(tempAssignment);

        Assignment tempAssignment2 = new Assignment("Assignment 2");
        tempAssignment2.setCourse(courseList);
        tempAssignment2.setRoster(rosterList);

        Course course1 = new Course("Course 1");
        course1.setRoster(rosterList);
        course1.setAssignmentList(assignmentList);

        courseList = new CourseList();
        courseList.addCourse(course1);

        assignmentList.addAssignment(tempAssignment2);
        accounts = new HashMap();
        accounts.put("Student1", new Account("123", 0));
        accounts.put("TA1", new Account("456", 1));
        accounts.put("Professor1", new Account("789",2));

        /**
         * TODO: replace with loading from file
         */
    }

    public static void saveData()
    {
        /**
         * TODO: add saving to file
         */
    }

    public static Integer verifyUser(String name, String password)
    {
        if(accounts == null)
        {
            ErrorDialog.showDialog("ERROR: Data not Initialized");
            return -1;
        }
        Account user = accounts.get(name); // try to get password
        if(user == null) // username doesnt exist
            return -1;

        if(user.accountPassword.equals(password))
        {
            currentUserName = name;
            return user.accountType;
        }

        return -1; // password didn't match
    }
    
    // verify current user then allow them to set a new password
    public static boolean changePassword(String currPassword)
    {
        if(currentUserName == null)
            return false;
        if(currPassword == null)
            return false;
        Account user = accounts.get(currentUserName);
        
        if(user == null)
            return false;

        if(user.accountPassword.equals(currPassword)) // account verified, correct password entered
        {
            String newPass = showInput("Enter New Password"); // enter new password
            user.accountPassword = newPass; // set new pass
            return true;
        }

        return false;
    }

    public static String showInput(String text)
    {
        String input = null;
        while(input == null)
        {
            input = JOptionPane.showInputDialog(text);
            if(input==null)
                ErrorDialog.showDialog("Invalid Input");
        }
        return input;
    }
}

