package model;

import com.sun.media.sound.WaveExtensibleFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CSVReader {

    public static void main(String[] args) {
        System.out.println( new CSVReader().readFile("Group"));

    }


    public List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        File courseFile = new File(this.getClass().getClassLoader().getResource(fileName + ".csv").getFile());
        Scanner courseScanner = null;
        try {
            courseScanner = new Scanner(courseFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (courseScanner.hasNextLine()) {
            lines.add(courseScanner.nextLine());
        }
        return lines;

    }
}
