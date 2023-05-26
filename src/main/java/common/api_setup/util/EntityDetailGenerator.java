package common.api_setup.util;

import java.time.Instant;
import java.util.Random;

public class EntityDetailGenerator {

    private static final String[] FIRST_NAMES = {"John", "Mary", "Slobo", "Srdjan", "Stefan", "Sonja", "Stefania", "Maria", "Violeta"};
    private static final String[] LAST_NAMES = {"Ilic", "Stanojcic", "Prezimenovic", "Lastnejmovic", "Stefanovic", "Jones", "Milovanovic", "Karadzic", "Wick"};
    private static Random random = new Random();

    public static String userBody(String email, String firstName, String lastName) {
        return "{\n" +
                "  \"email\": \""+ email +"\",\n" +
                "  \"firstName\": \""+ firstName +"\",\n" +
                "  \"lastName\": \""+ lastName +"\"}";
    }

    public static String generateRandomEmail(String typeOfEntity) {
        long unixTime = Instant.now().getEpochSecond();
        random = new Random(unixTime);
        return typeOfEntity + random.nextInt() + "@test.com";
    }

    public static String generateRandomName() {
        int randomIndex = random.nextInt(FIRST_NAMES.length);
        return FIRST_NAMES[randomIndex];
    }

    public static String generateRandomLastName() {
        int randomIndex = random.nextInt(LAST_NAMES.length);
        return LAST_NAMES[randomIndex];
    }
}
