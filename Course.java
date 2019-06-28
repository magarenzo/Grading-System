
public class Course
{
    private AssignmentList assignmentList;
    private String courseName;
    private RosterList courseRoster;

    public Course()
    {
        assignmentList = new AssignmentList();
        courseName = "New Course";
        courseRoster = new RosterList();
    }
    
    public Course(String name)
    {
        assignmentList = new AssignmentList();
        courseName = name;
        courseRoster = new RosterList();
    }

    public void setName(String newName)
    {
        courseName = newName;
    }

    public AssignmentList getAssignments()
    {
        return assignmentList;
    }
    
    public void setAssignmentList(AssignmentList al)
    {
        assignmentList = al;
    }
    
    public AssignmentList getAssignmentList()
    {
        return assignmentList;
    }

    public String getCourseName()
    {
        return courseName;
    }
    
    public void setCourseName(String name)
    {
        courseName = name;
    }

    public RosterList getRoster()
    {
        return courseRoster;
    }
    
    public void setRoster(RosterList roster)
    {
        courseRoster = roster;
    }
    
    public String toString()
    {
        return courseName;
    }
}
