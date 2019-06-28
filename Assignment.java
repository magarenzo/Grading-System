public class Assignment
{
    private String assignmentName;
    private CourseList courseList;
    private Grade grade;
    private RosterList roster;
    
    public Assignment(String name)
    {
        assignmentName = name;
    }
    public Assignment()
    {
        assignmentName = "Assignment";
    }
    
    public void setName(String name)
    {
        this.assignmentName = name;
    }
    public String getName()
    {
        return assignmentName;
    }
    
    public CourseList getCourse()
    {
        return courseList;
    }
    
    public void setCourse(CourseList courses)
    {
        this.courseList = courses;
    }
    
    public RosterList getStudent(String student)
    {
        return roster;
    }
    
    public void setRoster(RosterList rosterList)
    {
        this.roster = rosterList;
    }
    
    public Grade getGrade()
    {
        return grade;
    }
    
    public void setGrade(Grade g)
    {
        this.grade = g;
    }
    
    public String toString()
    {
        return assignmentName;
    }
}
