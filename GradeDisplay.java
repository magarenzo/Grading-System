import javax.swing.JOptionPane;
public class GradeDisplay
{
    public static void displayGrade(Grade grade)
    {
        GradeDisplay.displayGrade(grade.getGrade());
    }
    public static void displayGrade(double grade)
    {
        JOptionPane.showMessageDialog(null,"Grade: " + grade, "Grade", JOptionPane.PLAIN_MESSAGE);
    }
}
