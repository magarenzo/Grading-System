import javax.swing.JOptionPane;
public class ViewGradeDialog
{
    public static void showGrade(double grade)
    {
        JOptionPane.showMessageDialog(null,"Grade: " + grade, "Grade", JOptionPane.PLAIN_MESSAGE);
    }
}
