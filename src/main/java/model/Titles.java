package model;

public enum Titles {
    ASSISTANTPROFESSOR("Assistant Professor"),
    ASSOCIATEPROFESSOR("Associate Professor"),
    PROFESSOR("Professor");

    private final String val;

    private Titles(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val;
    }
}

