import java.util.ArrayList;
public class AssignmentControl
{
    
    public static void setAssignmentList(AssignmentList al)
    {
        PersistantStorage.assignmentList = al;
    }
    
    public static void createAssignment()
    {
        AssignmentControl.createAssignment(AssignmentDialog.showInput("Enter Assignment Name"));
    }
    
    public static void createAssignment(String assignmentName)
    {
        PersistantStorage.assignmentList.addAssignment(new Assignment(assignmentName));
    }
    
    public static void modifyAssignment()
    {
        Assignment assignment = AssignmentListDisplay.displayAssignmentList(PersistantStorage.assignmentList);
        String assignmentName = AssignmentDialog.showInput("Enter New Assignment Name: ");
        AssignmentControl.modifyAssignment(assignmentName, assignment);
    }
    
    public static void modifyAssignment(String assignmentName, Assignment assignment)
    {
        assignment.setName(assignmentName);
    }
    
    public static void deleteAssignment()
    {
        //call assignment list display and remove selected
        Assignment remove = AssignmentListDisplay.displayAssignmentList(PersistantStorage.assignmentList);
        
        // no assignment selected
        if(remove == null)
        {
            ErrorDialog.showDialog("No Assignment Selected");
            return;
        }
        
        // try to remove assignment
        if(!PersistantStorage.assignmentList.removeAssignment(remove))
        {
            // no assignment removed from list
            ErrorDialog.showDialog("Invalid Assignment");
        }
    }
    
    public static void viewAssignment()
    {
        Assignment assignment = AssignmentListDisplay.displayAssignmentList(PersistantStorage.assignmentList);
        if(assignment != null)
            AssignmentDisplay.displayAssignment(assignment.toString());
        else
            ErrorDialog.showDialog("Invalid Data");
    }
    
    public static ArrayList<Assignment> getAssignments()
    {
        return PersistantStorage.assignmentList.getAssignments();
    }
}
