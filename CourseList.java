import java.util.ArrayList;
public class CourseList
{
    private static ArrayList<Course> courseList;

    public CourseList()
    {
        courseList = new ArrayList<Course>();
    }

    public void setCourseList(ArrayList<Course> list)
    {
        courseList = list;
    }

    public ArrayList<Course> getCourses()
    {
        return courseList;
    }

    public boolean removeCourse(Course remove)
    {
        return courseList.remove(remove);
    }

    public boolean addCourse(Course newCourse)
    {
        return courseList.add(newCourse);
    }
   
}
