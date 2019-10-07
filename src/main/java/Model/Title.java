package Model;

public enum Title {
    ASSISTANTPROFESSOR("Assistant Professor"),
    ASSOCIATEPROFESSOR("Associate Professor"),
    PROFESSOR("Professor");


    private final String val;

    private Title(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val;
    }
}