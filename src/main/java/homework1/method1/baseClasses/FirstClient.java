package homework1.method1.baseClasses;

import homework1.method1.clientTypes.FirstHolding;
import homework1.method1.clientTypes.FirstIndividual;
import homework1.method1.clientTypes.FirstLegalEntity;

import java.util.HashMap;
import java.util.Objects;

public class FirstClient {

    public FirstClient createClient(HashMap<String, String> info){
        return new FirstClient();
    }

    public String getFullInfo(HashMap<String, String>info){
        return null;
    }

    public static FirstClient defineClientType(HashMap<String, String> data){
        FirstClient client = null;
        if (data.containsKey("clientType")){
            if (Objects.equals(data.get("clientType"), "INDIVIDUAL")){
                FirstClient individual = new FirstIndividual();
                client = individual.createClient(data);
            }
            if (Objects.equals(data.get("clientType"), "HOLDING")){
                FirstClient holding = new FirstHolding();
                client = holding.createClient(data);

            }
            if (Objects.equals(data.get("clientType"), "LEGAL_ENTITY")){
                FirstClient legalEntity = new FirstLegalEntity();
                client = legalEntity.createClient(data);
            }
        }
        return client;
    }
}
