public class Task_7 {
    public static void main(String[] args) {
        System.out.println(isKaprekar(3));
        System.out.println(isKaprekar(5));
        System.out.println(isKaprekar(297));
    }

    //Функция возращает true, если это число Капрекара, false, если это не так.
    public static boolean isKaprekar(int num) {
        long pow = (long) num * num;
        //Узнаем сколько цифр в квадратичном числе.
        int n = 1;
        for (int i = 10; pow > i; i *= 10, n++);
        //Нахождение левой и правой части.
        long power = (long) Math.pow(10, (n + 1) / 2);
        long right = pow % power;
        long left = pow / power;
        return right + left == num;
    }
}
