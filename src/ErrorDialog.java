import javax.swing.JOptionPane;
public class ErrorDialog
{

    public static void showDialog(String error)
    {
        JOptionPane.showMessageDialog(null,error, "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
