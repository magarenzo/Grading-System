
public class GradeControl
{
    public GradeControl()
    {
        PersistantStorage.grade = new Grade();
    }
    
    public static void setGrade(Grade newGrade)
    {
        PersistantStorage.grade = newGrade;
    }
    
    public static double getGrade()
    {
        return PersistantStorage.grade.getGrade();
    }

    public static void viewGrade()
    {
        ViewGradeDialog.showGrade(getGrade());
    }
    
    public static void enterGrade()
    {
        GradeControl.enterGrade(GradeDialog.showInputDialog("Enter Grade"));
    }
    
    public static void enterGrade(double grade)
    {
        if(!isGraded()) // no grade entered yet
            PersistantStorage.grade.setGrade(grade);
        else
            ErrorDialog.showDialog("Assignment is already graded.");
    }

    public static void modifyGrade()
    {
        GradeControl.modifyGrade(GradeDialog.showInputDialog("Enter New Grade"));
    }
    
    public static void modifyGrade(double grade)
    {
        if(isGraded()) // has a grade to modify
            PersistantStorage.grade.setGrade(grade);
        else
            ErrorDialog.showDialog("Assignment is not graded.");
    }

    public static void removeGrade()
    {
        if(isGraded()) // has a grade to remove
            PersistantStorage.grade.removeGrade();
        else
            ErrorDialog.showDialog("Assignment is not graded.");
    }

    private static boolean isGraded()
    {
        return PersistantStorage.grade.getGrade() != -1;
    }
}
