package Model;

public class Courses {
   private String name;
   private String abbreviation;
   private String details;
   private Teacher teachers;

    public Courses(){

       /* public Courses(String name, String abbreviation, String details, Teacher teachers){
            this.name = name;
            this.abbreviation = abbreviation;
            this.details = details;
            this.teachers = teachers;*/

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Teacher getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "name='" + name + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", details='" + details + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
