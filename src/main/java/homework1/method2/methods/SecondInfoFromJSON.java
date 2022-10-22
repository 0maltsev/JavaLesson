package homework1.method2.methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SecondInfoFromJSON {
    public static HashMap<String, String> keyToValue(String path) throws FileNotFoundException {
        List<String> records = formatArray(path);
        HashMap<String, String> result = new HashMap<>();
        for (int i = 0; i < records.size(); i++) {
            String s = records.get(i);
            String key = s.split(":")[0];
            String value = s.split(":")[1];
            result.put(key.replaceAll("[^A-Za-zА-Яа-я0-9]", ""), value.replaceAll("[\"]", "").substring(1));
        }
        return result;
    }

    public static List<String> formatArray(String path) throws FileNotFoundException {
        List<String> records = getRecordsToArray(path);
        records.remove(0);
        records.remove(records.size()-1);
        records.replaceAll(s -> s.substring(3));
        return records;
    }

    public static List<String> getRecordsToArray(String path) throws FileNotFoundException {

        List<String> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        }
        return records;
    }

    private static String getRecordFromLine(String line) {
        String value;
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");

            value = rowScanner.next();

        }
        return value;
    }
}
