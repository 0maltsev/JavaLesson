package method2;

import homework1.method2.baseClasses.SecondClient;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;

import static homework1.method2.methods.SecondInfoFromJSON.keyToValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecondUnitTest {
    @Test
    void testCorrectHolding() throws Exception {
        HashMap<String, String> data = keyToValue("src/main/java/homework1/utility/HOLDING.csv");

        String correctResponse = "name: ARC group" +"\n"+
                "owner: Андрей Васильев" + "\n" +
                "inn: 987654321" +"\n"+
                "clientType: HOLDING";
        assertEquals(correctResponse, SecondClient.getFullInfo(data));
    }

    @Test
    void testCorrectIndividual() throws Exception {
        HashMap<String, String> data = keyToValue("src/main/java/homework1/utility/INDIVIDUAL.csv");

        String correctResponse = "firstName: Олег" + "\n" +
                "secondName: Мальцев" + "\n" +
                "age: 21" + "\n" +
                "inn: 12345678910" + "\n" +
                "clientType: INDIVIDUAL";
        assertEquals(correctResponse,SecondClient.getFullInfo(data));
    }

    @Test
    void testCorrectLegalEntity() throws Exception {
        HashMap<String, String> data = keyToValue("src/main/java/homework1/utility/LEGAL_ENTITY.csv");

        String correctResponse = "name: ООО Матрешка" + "\n" +
                "inn: 13242352" + "\n" +
                "clientType: LEGAL_ENTITY";
        assertEquals(correctResponse,SecondClient.getFullInfo(data));
    }


    @Test
    void testIncorrectFileName(){
        assertThrows(FileNotFoundException.class, () -> keyToValue("src/main/java/homework1/utility/MMM.csv"));
    }
}
