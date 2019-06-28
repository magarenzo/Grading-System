import java.util.ArrayList;
import javax.swing.JOptionPane;
public class CourseListDisplay
{
    public static Course displayCourseList(ArrayList<Course> courseList)
    {
        Object[] courseArray = courseList.toArray(); // convert to array
        try
        {
            Object choice = JOptionPane.showInputDialog(null, "Show Course", "Course List", JOptionPane.QUESTION_MESSAGE, null, courseArray, courseArray[0]);
            if(choice instanceof Course) // choice is a course
                return (Course) choice;
        }
        catch(Exception e) // invalid course list
        {
            return null;
        }
        return null; // no cource chosen
    }
    
    public static Course displayCourseList(CourseList courseList)
    {
        return CourseListDisplay.displayCourseList(courseList.getCourses()); // get array list
    }
}
