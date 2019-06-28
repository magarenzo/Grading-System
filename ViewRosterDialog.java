import javax.swing.JOptionPane;
public class ViewRosterDialog
{
    public static void showDialog(String roster)
    {
        JOptionPane.showMessageDialog(null,roster, "Roster", JOptionPane.PLAIN_MESSAGE);
    }

    public static double showInputDialog(String message)
    {
        Double num = -1.0;
        while(num == -1.0) // until valid input is entered
        {
            String input = JOptionPane.showInputDialog(message);
            try
            {
                num = Double.parseDouble(input);
            }
            catch(NullPointerException | NumberFormatException e)
            {
                ErrorDialog.showDialog("Invalid Input");
            }
        }
        return num;
    }

    public static boolean showRemoveDialog(String message)
    {
        int answer = JOptionPane.showConfirmDialog(null, message, "Roster", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION)
            return true;
        return false;
    }
}
