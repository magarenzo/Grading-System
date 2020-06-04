
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * test the grade subsystem
 */
public class GradeTester
{
    static Grade myGrade;

    @BeforeClass
    public static void setup()
    {
        myGrade = new Grade();
        GradeControl.setGrade(myGrade);
    }

    @AfterClass
    public static void cleanup()
    {
        myGrade = null;
        GradeControl.setGrade(myGrade);
    }

    // test getting grade
    @Test
    public void testGetGrade()
    {
        // ungraded assignment -> grade = -1
        assertEquals(GradeControl.getGrade(), -1, 0);
    }

    // test setting control object's grade object
    @Test
    public void testSetGrade()
    {
        Grade temp = new Grade(18);
        GradeControl.setGrade(temp);

        assertEquals(temp.getGrade(), GradeControl.getGrade(), 0);
    }

    // test enter grade
    @Test
    public void testEnterGrade()
    {
        // set ungraded grade to valid number
        int tmpGrade = 30;
        GradeControl.enterGrade(tmpGrade);

        assertEquals(tmpGrade, GradeControl.getGrade(), 0);

        // try to enter another grade (already graded - nothing should change)
        GradeControl.enterGrade(40);
        assertEquals(tmpGrade, GradeControl.getGrade(), 0);

        // try entering value less than zero
        GradeControl.setGrade(new Grade());
        GradeControl.enterGrade(-5);

        assertEquals(-1, GradeControl.getGrade(), 0); // still not graded
    }

    // test modify grade
    @Test
    public void testModifyGrade()
    {
        // try to modify ungraded assignment
        GradeControl.modifyGrade(40);

        assertEquals(-1, GradeControl.getGrade(), 0); // still not graded
        
        // modify graded assignment
        GradeControl.enterGrade(30);
        int tmpGrade = 97;
        GradeControl.modifyGrade(tmpGrade);
        
        assertEquals(tmpGrade, GradeControl.getGrade(), 0);
        
        // try to modify grade to invalid number (<0)
        GradeControl.modifyGrade(-10);
        
        assertEquals(tmpGrade, GradeControl.getGrade(), 0); // still unchanged
    }
    
    // test removeGrade
    @Test
    public void testRemoveGrade()
    {
        // set grade to valid number
        GradeControl.enterGrade(97);
        // try to remove grade
        GradeControl.removeGrade();
        
        assertEquals(-1, GradeControl.getGrade(), 0); // no longer graded
        
        /* removing an already ungraded grade shows an error message but can't be tested due to grade containing the same value either way */
    }
}
