package model;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class CSVWriter {

    public static void main(String[] args) throws IOException {
        csvWriter("succes1");
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

    public static Map<String, ArrayList<String>> messageGroupOrder() {
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
                    System.out.println(key + " - " + message);
                }
            }

        }
        return map;
    }

    public static void csvWriter(String group) throws IOException {

        Map<String, ArrayList<String>> map = (messageGroupOrder());
        FileWriter writer = new FileWriter(group);
        writer.append(map.get("1").get(0));
        writer.append(",");
        writer.append(map.get("2").get(0));
        writer.append(",");
        writer.append(map.get("3").get(0)
        );
        writer.append("\n");

        writer.flush();
        writer.close();

        Set<String> keys = map.keySet();

        for (String key : keys) {
            for (String message : map.get(key)) {
                System.out.println(key + " - " + message);
            }

        }
    }
}







