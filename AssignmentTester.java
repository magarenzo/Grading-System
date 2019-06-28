import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class AssignmentTester
{
    static AssignmentList assignmentList;

    @Before
    public void setUp()
    {
        assignmentList = new AssignmentList();
        AssignmentControl.setAssignmentList(assignmentList);
    }

    @After
    public void tearDown()
    {
        assignmentList = null;
    }
    
    // test create assignment
    @Test
    public void testCreateAssignment()
    {
        String assignment = "assignment 1";
        
        AssignmentControl.createAssignment(assignment);
        
        assertEquals(assignment, AssignmentControl.getAssignments().get(0).getName() );
    }
    
    // test modify assignment
    @Test
    public void testModifyAssignment()
    {
        Assignment actual = new Assignment("assignment 1");
        String name = "assignment2";
        
        AssignmentControl.modifyAssignment(name, actual);
        
        assertEquals(name, actual.getName());
    }
}
