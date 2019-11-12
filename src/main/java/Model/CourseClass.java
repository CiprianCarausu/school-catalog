package Model;

public class CourseClass {
    private Course course;
    private Group group;
    private Teacher teacher;
    private Appointment appointment;

    public CourseClass(Course course, Group group, Teacher teacher, Appointment appointment) {
        this.group = group;
        this.teacher = teacher;
        this.course = course;
        this.appointment = appointment;
    }

    public Group getGroup() {
        return group;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "idGroup=" + group +
                ", teacher=" + teacher +
                ", appointment=" + appointment +
                ", course=" + course +
                '}';
    }
}
