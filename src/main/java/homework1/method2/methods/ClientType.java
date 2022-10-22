package homework1.method2.methods;

import homework1.method2.baseClasses.SecondClient;
import homework1.method2.clientTypes.SecondHolding;
import homework1.method2.clientTypes.SecondIndividual;
import homework1.method2.clientTypes.SecondLegalEntity;

import java.util.HashMap;

public enum ClientType {
    HOLDING{
        @Override
        public SecondClient createClient(HashMap<String, String> info){
            SecondHolding client = new SecondHolding();
            client.name = info.get("name");
            client.owner = info.get("owner");
            client.inn = Long.parseLong(info.get("inn"));
            client.clientType = info.get("clientType");
            return  client;
        }

        @Override
        public String getInfo(HashMap<String, String> info) {
            String result = "name:" + " " + info.get("name") + "\n" +
                    "owner:" + " " + info.get("owner") + "\n" +
                    "inn:" + " " + info.get("inn") + "\n" +
                    "clientType:" + " " + info.get("clientType");
            return result;
        }
    },

    INDIVIDUAL{
        @Override
        public SecondClient createClient(HashMap<String, String> info){
            SecondIndividual client = new SecondIndividual();
            client.firstName = info.get("firstName");
            client.secondName = info.get("secondName");
            client.age = Integer.parseInt(info.get("age"));
            client.inn = Long.parseLong(info.get("inn"));
            client.clientType = info.get("clientType");
            return client;
        }

        @Override
        public String getInfo(HashMap<String, String> info) {
            String result = "firstName:" + " " + info.get("firstName") + "\n" +
                    "secondName:" + " " + info.get("secondName") + "\n" +
                    "age:" + " " + info.get("age") + "\n" +
                    "inn:" + " " + info.get("inn") + "\n" +
                    "clientType:" + " " + info.get("clientType");
            return result;
        }
    },

    LEGAL_ENTITY{
        @Override
        public SecondClient createClient(HashMap<String, String> info){
            SecondLegalEntity client = new SecondLegalEntity();
            client.name = info.get("name");
            client.inn = Long.parseLong(info.get("inn"));
            client.clientType = info.get("clientType");
            return client;
        }

        @Override
        public String getInfo(HashMap<String, String> info) {
            String result = "name:" + " " + info.get("name") + "\n" +
                    "inn:" + " " + info.get("inn") + "\n" +
                    "clientType:" + " " + info.get("clientType");
            return result;
        }
    };

    public abstract SecondClient createClient(HashMap<String, String> info);
    public abstract String getInfo(HashMap<String, String> info);
}
