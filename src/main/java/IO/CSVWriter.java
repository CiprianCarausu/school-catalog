package IO;

import Model.Message;
import Model.Location;
import Model.Message;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class CSVWriter {

    FileWriter writer;

    public void writeMessagesToFile(int idGroup, List<Message> messages) throws IOException{
        String fileName = "MessageFromGroup"+idGroup;
        writer = new FileWriter("src/main/resources"+fileName);
        writer.append("dateAndTime, message\n");
        for(Message message: messages){
            writer.append(message.singeGroupFileSave());
        }
        writeWriter();
    }

    public void writeAvailableLocations(List<Location> availables) throws IOException{
        String fileName = "AvailableLocations";
        writer = new FileWriter("C:\\Users\\ccipy\\java_firstapp_maven"+fileName);
        writer.append("name,capacity,available,adress\n");
        for(Location loc: availables){
            writer.append(loc.toCSVFileSave());
        }
        writeWriter();
    }

    private void writeWriter(){
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong while writing!");
        }

    }

    public static void main(String[] args) throws IOException {
      /* List<Message> messages = new ArrayList<>();
       Message message = new Message();
       message.loadDataFromCSVString("2005-12-13 at 15:45.20.1432,Hi world,4");
       messages.add(message );
       message.loadDataFromCSVString("2005-12-12 at 14:55.20.1432,Hi Hi,3");
       messages.add(message);
       new CSVWriter().writeMessagesToFile(4, messages);*/

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







