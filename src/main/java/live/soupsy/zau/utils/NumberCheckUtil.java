package live.soupsy.zau.utils;

public class NumberCheckUtil {
    public static boolean isInt(String s) { //int check
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static boolean isDouble(String s) { //int check
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static boolean isFloat(String s) { //int check
        try {
            Float.parseFloat(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
