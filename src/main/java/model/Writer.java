package model;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;


public class Writer {

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
}
