
public class Grade
{
    private double grade;

    public Grade()
    {
        grade = -1.0;
    }

    public Grade(double newGrade)
    {
        // cant have negative grade
        if(newGrade >= 0)
            this.grade = newGrade;
    }

    public void setGrade(double newGrade)
    {
        // cant have negative grade
        if(newGrade >= 0)
            this.grade = newGrade;
    }

    public double getGrade()
    {
        return grade;
    }
    
    public void removeGrade()
    {
        grade = -1.0;
    }

}
