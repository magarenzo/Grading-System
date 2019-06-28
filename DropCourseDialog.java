import java.util.ArrayList;
import javax.swing.JOptionPane;
public class DropCourseDialog
{
    public static Course dropCourse(ArrayList<Course> courseList)
    {
        Object[] courseArray = courseList.toArray(); // get arrayList then convert it to array
        try
        {
            Object choice = JOptionPane.showInputDialog(null, "Drop Course", "Course List", JOptionPane.QUESTION_MESSAGE, null, courseArray, courseArray[0]);
            if(choice instanceof Course) // choice is a course
                return (Course) choice;
        }
        catch(Exception e) // invalid course list
        {
            return null;
        }
        return null; // no cource chosen
    }
    public static Course dropCourse(CourseList courseList)
    {
        return DropCourseDialog.dropCourse(courseList.getCourses());
    }
}
