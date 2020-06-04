public class CourseControl
{
    public static void dropCourse()
    {
        Course drop = DropCourseDialog.dropCourse(PersistantStorage.courseList);
        if(drop == null)
        {
            ErrorDialog.showDialog("No Course Selected");
            return;
        }

        if(!PersistantStorage.courseList.removeCourse(drop))
            ErrorDialog.showDialog("Error Dropping Course");
    }

    public static void viewCourses()
    {
        Course course = CourseListDisplay.displayCourseList(PersistantStorage.courseList);
        if(course != null)
            CourseDisplay.displayCourse(course);
    }
    
    public static void addCourse()
    {
        String courseName = ViewCourseDialog.showDialog("Enter New Course Name: ");
        PersistantStorage.courseList.addCourse(new Course(courseName));
    }
}
