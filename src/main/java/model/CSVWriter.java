package model;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;


public class CSVWriter {

    public static void main(String[] args) {
        messageGroupOrder();
    }

    public static void scheduleExport() {
        String jsonArrayString = "{\"oneWeekSchedule\": [{\"idGroup\": \"1\",\"teacher\": \"Andrew\",\"location\": \"Hall\",\"date\": \"11/11/2005\",\"startTime\": \"11\",\"endTime\": \"12\",\"courseDetails\": \"Easy\",\"courses\": \"English\" }]}";
        String jsonArrayNamesString = "[\"idGroup\",\"teacher\",\"location\",\"date\",\"startTime\",\"endTime\",\"courseDetails\",\"courses\" ]";

        JSONObject output = new JSONObject(jsonArrayString);
        JSONArray sort = new JSONArray(jsonArrayNamesString);
        try {
            JSONArray docs = output.getJSONArray("oneWeekSchedule");
            File file = new File("src/main/resources/oneWeekSchedule.csv");
            file.createNewFile();
            String csv = CDL.toString(sort, docs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void messageGroupOrder() {
        List<String> lines = new CSVReader().readFile("message");
        Map<String, ArrayList<String>> map = new HashMap<>();


        for (String line : lines) {
            String[] columns = line.split(",");

            String date = columns[1];
            String msg = columns[2];
            String idGroup = columns[3];


            //ensure idGroup is in the Map
            if (!map.containsKey(idGroup))
                map.put(idGroup, new ArrayList<String>());

            //add to list at idGroup location
            map.get(idGroup).add(msg + " - " + date);


            Set<String> keys = map.keySet();

         //   List<String> sample = new ArrayList<String>(){"key","message","date"};

            for (String key : keys) {
                for (String message : map.get(key)) {
                    System.out.println(key + " - " + message );
                }
            }
        }
    }

   


