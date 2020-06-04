import javax.swing.JOptionPane;
public class CourseDisplay
{
    public static void displayCourse(Course course)
    {
        JOptionPane.showMessageDialog(null,course + "\nAssignments:\n" + course.getAssignments() + "\nRoster:\n" + course.getRoster(), "Course", JOptionPane.INFORMATION_MESSAGE);
    }
}
