package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CSVReader {

    public List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        File courseFile = new File(this.getClass().getClassLoader().getResource("in/" + fileName + ".csv").getFile());
        try {
            Scanner courseScanner = new Scanner(courseFile);
            while (courseScanner.hasNextLine()) {
                lines.add(courseScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        lines.remove(0);
        return lines;

    }
}
