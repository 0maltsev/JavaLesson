package homework1.method1;


import homework1.method1.baseClasses.FirstClient;


import java.util.HashMap;

import static homework1.method1.baseClasses.FirstClient.defineClientType;
import static homework1.method1.methods.FirstInfoFromJSON.keyToValue;

public class Main {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> data = keyToValue("src/main/java/homework1/utility/MISSED_FIELD.csv");

        FirstClient result = defineClientType(data);

        System.out.println(result);
        System.out.println(result.getFullInfo(data));
    }
}
