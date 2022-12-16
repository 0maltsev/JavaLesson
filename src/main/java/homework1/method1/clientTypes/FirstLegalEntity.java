package homework1.method1.clientTypes;

import homework1.method1.baseClasses.FirstClient;

import java.util.HashMap;

public class FirstLegalEntity extends FirstClient {
    String name;
    long inn;
    String clientType;

    @Override
    public FirstLegalEntity createClient(HashMap<String, String> info){
        FirstLegalEntity client = new FirstLegalEntity();
        this.name = info.get("name");
        this.inn = Long.parseLong(info.get("inn"));
        this.clientType = info.get("clientType");
        return client;
    }

    @Override
    public String getFullInfo(HashMap<String, String>info){

        String result = "name:" + " " + info.get("name") + "\n" +
                "inn:" + " " + info.get("inn") + "\n" +
                "clientType:" + " " + info.get("clientType");
        return result;
    }
}
