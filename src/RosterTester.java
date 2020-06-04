import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RosterTester.
 */
public class RosterTester
{
    static Roster myroster;

    @Before
    public void setUp()
    {
        myroster = new Roster();
        myroster.setRoster("Bob Smith");
    }
    
    @After
    public void cleanUp()
    {
        myroster = null;
    }

    // test getting grade
    @Test
    public void testGetStudent()
    {
        String temp = "Bob Smith";
        assertEquals(temp, myroster.getStudent());
    }

    //test setting control object's grade object
    @Test
    public void testSetRoster()
    {
        Roster temp1 = new Roster();
        temp1.setRoster("John Lang");

        assertEquals("John Lang", temp1.getStudent());
    }

    //testing adding student to roster
    @Test
    public void testAddStudentToRoster()
    {
        Roster temp2 = new Roster("Billy Hunt");
        RosterList list = new RosterList();
        list.enterRoster(temp2);

        assertEquals("Billy Hunt", list.getStudent(temp2).getStudent());
    }

    //testing removing student from roster
    @Test
    public void testRemoveStudentFromRoster()
    {
        Roster temp3 = new Roster("Charlie Hill");
        RosterList list2 = new RosterList();
        list2.enterRoster(temp3);
        list2.removeRoster(temp3);
        if (list2.isEmpty())
        {
            assertTrue(true);
        }
        else
            assertFalse(false);

    }
}
