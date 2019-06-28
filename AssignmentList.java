import java.util.ArrayList;
public class AssignmentList extends Assignment
{
    private ArrayList<Assignment> assignmentList;
    public AssignmentList()
    {
        assignmentList = new ArrayList<Assignment>();
    }
    
    public ArrayList<Assignment> getAssignments()
    {
        return assignmentList;
    }
    
    public boolean removeAssignment(Assignment remove)
    {
        return assignmentList.remove(remove);
    }

    public boolean addAssignment(Assignment newAssignment)
    {
        return assignmentList.add(newAssignment);
    }
}
