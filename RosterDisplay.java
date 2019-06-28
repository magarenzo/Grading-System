import java.util.ArrayList;
import javax.swing.JOptionPane;
public class RosterDisplay
{
    public static void displayRoster(String roster)
    {
        JOptionPane.showMessageDialog(null,roster, "Roster", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void displayRoster(Roster roster)
    {
        RosterDisplay.displayRoster(roster.toString());
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

    public static Roster displayRosterList(ArrayList<Roster> rosterList)
    {
        Object[] rosterArray = rosterList.toArray(); // convert to array
        try
        {
            Object choice = JOptionPane.showInputDialog(null, "Remove Roster", "Roster List", JOptionPane.QUESTION_MESSAGE, null, rosterArray, rosterArray[0]);
            if(choice instanceof Roster) // choice is a Roster
                return (Roster) choice;
        }
        catch(Exception e) // invalid Roster list
        {
            return null;
        }
        return null; // no Roster chosen
    }

    public static Roster displayRosterList(RosterList rosterList)
    {
        return RosterDisplay.displayRosterList(rosterList.getList()); // get array list
    }
}
