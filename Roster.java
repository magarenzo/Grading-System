
public class Roster
{
    private String student;
    public Roster()
    {
        student = "";
    }

    public Roster (String studentName)
    {
        this.student = studentName;
    }

    public void setRoster(String newStudent)
    {
        if(newStudent == null)
        {
            ErrorDialog.showDialog("Invalid Roster");
        }
        else 
        {
            student = newStudent;
        }
    }

    public String getStudent()
    {
        return student;
    }
    
    public String toString()
    {
        return student;
    }
}
