import java.util.ArrayList;
public class RosterControl
{

    public static void addStudent()
    {
        String studentName = RosterDisplay.showInput("Enter New Student: ");
        PersistantStorage.rosterList.enterRoster(new Roster(studentName));
    }

    public static void removeStudent()
    {
        Roster remove = RosterDisplay.displayRosterList(PersistantStorage.rosterList);

        if(remove == null)
        {
            ErrorDialog.showDialog("No Student Select");
            return;
        }

        if(!PersistantStorage.rosterList.removeRoster(remove))
        {
            ErrorDialog.showDialog("Invalid Student");
        }
    }

    public static void viewRoster()
    {
        Roster roster = RosterDisplay.displayRosterList(PersistantStorage.rosterList);
        if(roster != null)
            RosterDisplay.displayRoster(roster);
        else
            ErrorDialog.showDialog("Invalid Data");
    }

}
