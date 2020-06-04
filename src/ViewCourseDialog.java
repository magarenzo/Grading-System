import javax.swing.JOptionPane;
public class ViewCourseDialog
{
    public static String showDialog(String displayText)
    {
        String input = null;
        while(input == null)
        {
            input = JOptionPane.showInputDialog(displayText);
            if(input==null)
                ErrorDialog.showDialog("Invalid Input");
        }
        return input;
    }
}
