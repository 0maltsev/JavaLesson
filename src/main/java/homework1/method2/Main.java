package homework1.method2;


import homework1.method2.baseClasses.SecondClient;


import java.util.HashMap;

import static homework1.method2.baseClasses.SecondClient.createProperClientType;

import static homework1.method2.methods.SecondInfoFromJSON.keyToValue;

public class Main {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> data = keyToValue("src/main/java/homework1/utility/INDIVIDUAL.csv");

        SecondClient result = createProperClientType(data);


        System.out.println(result);
        System.out.println(SecondClient.getFullInfo(data));
    }
}
