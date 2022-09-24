package homework1.method1.clientTypes;

import homework1.method1.baseClasses.FirstClient;

import java.util.HashMap;

public class FirstHolding extends FirstClient {
    String name;
    String owner;
    long inn;
    String clientType;

    @Override
    public FirstHolding createClient(HashMap<String, String> info){
        FirstHolding client = new FirstHolding();
        this.name = info.get("name");
        this.owner = info.get("owner");
        this.inn = Long.parseLong(info.get("inn"));
        this.clientType = info.get("clientType");
        return  client;
    }

    @Override
    public String getFullInfo(HashMap<String, String>info){

        String result = "name:" + " " + info.get("name") + "\n" +
                        "owner:" + " " + info.get("owner") + "\n" +
                        "inn:" + " " + info.get("inn") + "\n" +
                        "clientType:" + " " + info.get("clientType");
        return result;
    }
}
