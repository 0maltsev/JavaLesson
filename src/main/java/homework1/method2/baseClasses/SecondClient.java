package homework1.method2.baseClasses;


import java.util.HashMap;
import java.util.Objects;

import static homework1.method2.methods.ClientType.*;

abstract public class SecondClient {



    public static SecondClient createProperClientType(HashMap<String, String> data) {

        String key = data.get("clientType");

        if (Objects.equals(key, "INDIVIDUAL")) {
        return INDIVIDUAL.createClient(data);
        }
        if (Objects.equals(key, "HOLDING")){
       return HOLDING.createClient(data);
        }
        if (Objects.equals(key, "LEGAL_ENTITY")){
       return LEGAL_ENTITY.createClient(data);
        }
        else {
            return null;
        }

    }

    public static String getFullInfo(HashMap<String, String> data){
        String key = data.get("clientType");

        if (Objects.equals(key, "INDIVIDUAL")) {
            return INDIVIDUAL.getInfo(data);
        }
        if (Objects.equals(key, "HOLDING")){
            return HOLDING.getInfo(data);
        }
        if (Objects.equals(key, "LEGAL_ENTITY")){
            return LEGAL_ENTITY.getInfo(data);
        }
        else {
            return null;
        }
    };
}
