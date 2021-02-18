public class Task_9 {
    public static void main(String[] args) {
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));
    }

    //Возвращает true, если строка word начинается
    //с префиксного аргумента prefix
    public static boolean isPrefix(String word, String prefix){
        if (word.length() < prefix.length() - 1)
            return false;
        for (int i = 0; i < prefix.length() - 1; i++)
            if (word.charAt(i) != prefix.charAt(i))
                return false;
        return true;
    }

    //Возвращает true, если строка word заканчивается
    //суффиксным аргументом suffix.
    public static boolean isSuffix(String word, String suffix) {
        if (word.length() < suffix.length() - 1)
            return false;
        for (int i = 1; i < suffix.length(); i++)
            if (word.charAt(word.length() - suffix.length() + i) != suffix.charAt(i))
                return false;
        return true;
    }
}
