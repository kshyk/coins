package coins.helpers;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class StringsHelper {
    public static String getRandomUUID() {
        return UUID.randomUUID().toString();
    }
}
