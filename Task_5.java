public class Task_5 {
    public static void main(String[] args) {
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CD5C5Z"));
        System.out.println(isValidHexCode("#CD5C&C"));
        System.out.println(isValidHexCode("CD5C5C"));
    }
    //Функция определяет, является ли строка допустимым 16-ым кодом.
    public static boolean isValidHexCode(String code) {
        if (code.charAt(0) != '#' || code.length() != 7)
            return false;
        for (int i = 1; i < code.length(); i++) {
            char s = code.charAt(i);
            if ((s < 'a' || s > 'f') &&
                (s < 'A' || s > 'F') &&
                (s < '0' || s > '9'))
                return false;
        }
        return true;
    }
}
