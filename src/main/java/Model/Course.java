package Model;

public class Course {
   private String name;
   private String abbreviation;
   private String details;

    public Course(String name, String abbreviation, String details) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return String.format("{ name={0}, abbreviation={1}, details={2} }",
                name, abbreviation, details);
    }
}
