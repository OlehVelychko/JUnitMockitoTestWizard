package AliceCompany;

public class StringUtils {
    public static boolean isNumeric(String string) {
        return string != null && string.matches("\\d+");
    }
}