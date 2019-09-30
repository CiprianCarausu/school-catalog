package model;


import java.util.ArrayList;
import java.util.List;

public class School {
    public static void main(String[] args) {
        System.out.println(readGroup());
    }

    public static int readGroup() {
        List<String> group = new CSVReader().readFile("Group");
        group.remove(0);
        int count = 0;
        for (String line : group) {
            count++;
        }
        return count;
    }
}
