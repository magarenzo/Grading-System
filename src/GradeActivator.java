
public class GradeActivator
{
    public static double viewGrade()
    {
        GradeDialog.showDialog(0.0);
        return 0.0;
    }
    
    public static void enterGrade()
    {
        GradeControl.enterGrade();
    }
    
    public static void modifyGrade()
    {
        GradeControl.modifyGrade();
    }
    
    public static void removeGrade()
    {
        GradeControl.removeGrade();
    }
}
