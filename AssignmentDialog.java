import javax.swing.JOptionPane;
public class AssignmentDialog
{
    public static void showDialog(String text)
    {
        JOptionPane.showMessageDialog(null,text, "Assignment", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static String showInput(String text)
    {
        String input = null;
        while(input == null)
        {
            input = JOptionPane.showInputDialog(text);
            if(input==null)
                ErrorDialog.showDialog("Invalid Input");
        }
        return input;
    }
    
    public static boolean showRemoveDialog(String message)
    {
        int answer = JOptionPane.showConfirmDialog(null, message, "Assignment", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION)
            return true;
        return false;
    }
}
