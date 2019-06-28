import java.util.ArrayList;
import javax.swing.JOptionPane;
public class AssignmentListDisplay
{
    public static Assignment displayAssignmentList(AssignmentList list)
    {
        return AssignmentListDisplay.displayAssignmentList(list.getAssignments()); // get array list
    }
    
    public static Assignment displayAssignmentList(ArrayList<Assignment> list)
    {
        Object[] assignmentArray = list.toArray(); // convert to array
        try
        {
            Object choice = JOptionPane.showInputDialog(null, "Select Assignment", "Assignment List", JOptionPane.QUESTION_MESSAGE, null, assignmentArray, assignmentArray[0]);
            if(choice instanceof Assignment) // choice is a assignment
                return (Assignment) choice;
        }
        catch(Exception e) // invalid assignment list
        {
            return null;
        }
        return null; // no assignment chosen
    }
}
