public class Task_7 {
    public static void main(String[] args) {
        System.out.println(isValid("59001"));
        System.out.println(isValid("853a7"));
        System.out.println(isValid("732 32"));
        System.out.println(isValid("393939"));
    }

    //Функция возвращает true если index является
    //действительным почтовым индексом, иначе false
    public static boolean isValid(String index) {
        //Проверка на длину
        if (index.length() > 5)
            return false;
        //Если мы найдем не цифру, возвращаем false
        for (int i = 0; i < index.length(); i++)
            if (index.charAt(i) < '0' || index.charAt(i) > '9')
                return false;
        return true;
    }
}
