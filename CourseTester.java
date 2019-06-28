import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CourseTester.

 */
public class CourseTester
{
    static Course course;
    static String name = "Physics";
    @Before
    public void setUp()
    {
        course = new Course();
        course.setName(name);
    }

    @After
    public void tearDown()
    {
        course = null;
    }
    
    // test getCourseName
    @Test
    public void testGetCourseName()
    {
        assertEquals(name, course.getCourseName());
    }
   
    // test setName
    @Test
    public void testSetName()
    {
        String expected = "Computer Science";
        course.setName(expected);
        assertEquals(expected, course.getCourseName());
    }
    
    /* ensure objects are saved correctly */
    
    // test set/getAssignments
    @Test
    public void testAssignments()
    {
        AssignmentList expected = new AssignmentList();
        expected.addAssignment(new Assignment("assignment 1"));
        
        course.setAssignmentList(expected);
        assertEquals(expected, course.getAssignmentList());
    }
    
    // test set/getRoster
    @Test
    public void testRoster()
    {
        RosterList expected = new RosterList();
        
        course.setRoster(expected);
        
        assertEquals(expected, course.getRoster());
    }
}
