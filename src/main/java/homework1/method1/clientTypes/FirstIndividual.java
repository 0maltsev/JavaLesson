package homework1.method1.clientTypes;

import homework1.method1.baseClasses.FirstClient;

import java.util.HashMap;

public class FirstIndividual extends FirstClient {

    String firstName;
    String secondName;
    int age;
    long inn;
    String clientType;

    @Override
    public FirstIndividual createClient(HashMap<String, String> info) {
        FirstIndividual client = new FirstIndividual();
        this.firstName = info.get("firstName");
        this.secondName = info.get("secondName");
        this.age = Integer.parseInt(info.get("age"));
        this.inn = Long.parseLong(info.get("inn"));
        this.clientType = info.get("clientType");
        return client;
    }

    @Override
    public String getFullInfo(HashMap<String, String>info){

        String result = "firstName:" + " " + info.get("firstName") + "\n" +
                "secondName:" + " " + info.get("secondName") + "\n" +
                "age:" + " " + info.get("age") + "\n" +
                "inn:" + " " + info.get("inn") + "\n" +
                "clientType:" + " " + info.get("clientType");
        return result;
    }
}
