public class Task_5 {
    public static void main(String[] args) {
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));
    }
    //Функция возращает кол-во знаков после запятой.
    //Функция принимает строку-число
    public static int getDecimalPlaces(String number) {
        int i = 0;
        //Находим индекс точки.
        for (; i < number.length() && number.charAt(i) != '.'; i++);
        //Проверка на наличие точки.
        if (i == number.length())
            i--;
        return number.length() - i - 1;
    }
}
